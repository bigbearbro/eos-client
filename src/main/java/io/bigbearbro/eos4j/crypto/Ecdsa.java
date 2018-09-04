package io.bigbearbro.eos4j.crypto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import org.bouncycastle.math.ec.ECPoint;

import io.bigbearbro.eos4j.client.exception.CryptoException;
import io.bigbearbro.eos4j.crypto.util.Sha;
import io.bigbearbro.eos4j.utils.ByteUtils;
import io.bigbearbro.eos4j.utils.Hex;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class Ecdsa {

	/**
	 * sign
	 * 
	 * @param dataHash
	 * @param d
	 * @param nonce
	 * @return
	 */
	public SignBigInt sign(String dataHash, BigInteger d, int nonce) {
		BigInteger n = Secp256k1.N();
		SignBigInt big = new SignBigInt();
		deterministicGenerateK(dataHash, d, nonce, big);
		BigInteger N_OVER_TWO = n.shiftRight(1);
		if (big.getS().compareTo(N_OVER_TWO) > 0) {
			big.setS(n.subtract(big.getS()));
		}
		big.setDer(toDER(big));
		return big;
	}

	/**
	 * toDER
	 * 
	 * @param big
	 * @return
	 */
	private byte[] toDER(SignBigInt big) {
		byte[] rBa = big.getR().toByteArray();
		byte[] sBa = big.getS().toByteArray();
		ArrayList<Byte> sequence = new ArrayList<Byte>();
		sequence.add(new Byte(((byte) 0x02)));
		sequence.add(new Byte(((byte) rBa.length)));
		for (int i = 0; i < rBa.length; i++) {
			sequence.add(rBa[i]);
		}
		sequence.add(new Byte(((byte) 0x02)));
		sequence.add(new Byte(((byte) sBa.length)));
		for (int i = 0; i < sBa.length; i++) {
			sequence.add(sBa[i]);
		}
		int len = sequence.size();
		sequence.add(0, (byte) 0x30);
		sequence.add(1, (byte) len);
		byte[] bf = new byte[sequence.size()];
		for (int i = 0; i < bf.length; i++) {
			bf[i] = sequence.get(i).byteValue();
		}
		return bf;
	}

	private BigInteger deterministicGenerateK(String dataHash, BigInteger d, int nonce,
			SignBigInt big) {
		byte[] hash = Hex.hexStringToBytes(dataHash);
		if (nonce > 0) {
			hash = Sha.SHA256(ByteUtils.concat(hash, new byte[nonce]));
		}
		byte[] x = null;
		if (d.toByteArray()[0] == 0) {
			x = ByteUtils.copy(d.toByteArray(), 1, d.toByteArray().length - 1);
		} else {
			x = d.toByteArray();
		}

		byte[] k = new byte[32];
		byte[] v = new byte[32];

		// b
		Arrays.fill(v, (byte) 0x01);
		// c
		Arrays.fill(k, (byte) 0x00);

		// d
		byte[] db = ByteUtils.concat(ByteUtils.concat(ByteUtils.concat(v, new byte[] { 0 }), x), hash);

		k = Sha.HmacSHA256(db, k);

		// e
		v = Sha.HmacSHA256(v, k);
		// f
		byte[] fb = ByteUtils.concat(ByteUtils.concat(ByteUtils.concat(v, new byte[] { 1 }), x), hash);
		k = Sha.HmacSHA256(fb, k);
		// g
		v = Sha.HmacSHA256(v, k);
		// Step H1/H2a, ignored as tlen === qlen (256 bit)
		// Step H2b
		v = Sha.HmacSHA256(v, k);

		BigInteger T = new BigInteger(Hex.bytesToHexString(v), 16);

		BigInteger e = new BigInteger(dataHash, 16);

		Boolean check = checkSig(T, d, e, big);
		while (T.signum() <= 0 || T.compareTo(Secp256k1.N()) >= 0 || !check) {
			k = Sha.HmacSHA256(ByteUtils.concat(v, new byte[] { 0 }), k);
			v = Sha.HmacSHA256(v, k);
			v = Sha.HmacSHA256(v, k);
			T = new BigInteger(v);
		}

		big.setK(T);
		return T;
	}

	/**
	 * checkSig
	 * 
	 * @param k
	 * @param d
	 * @param e
	 * @param big
	 * @return
	 */
	public Boolean checkSig(BigInteger k, BigInteger d, BigInteger e, SignBigInt big) {
		ECPoint Q = Secp256k1.G().multiply(k);
		if (Q.isInfinity())
			return false;
		BigInteger r = Q.getX().toBigInteger().mod(Secp256k1.N());
		big.setR(r);
		if (r.signum() == 0)
			return false;
		BigInteger s = k.modInverse(Secp256k1.N()).multiply(e.add(d.multiply(r))).mod(Secp256k1.N());
		big.setS(s);
		if (s.signum() == 0)
			return false;
		return true;
	}

	/**
	 * 
	 * @author espritblock http://eblock.io
	 *
	 */
	public static class SignBigInt {
		private BigInteger k;
		private BigInteger r;
		private BigInteger s;
		private byte[] der;

		public BigInteger getK() {
			return k;
		}

		public void setK(BigInteger k) {
			this.k = k;
		}

		public BigInteger getR() {
			return r;
		}

		public void setR(BigInteger r) {
			this.r = r;
		}

		public BigInteger getS() {
			return s;
		}

		public void setS(BigInteger s) {
			this.s = s;
		}

		public byte[] getDer() {
			return der;
		}

		public void setDer(byte[] der) {
			this.der = der;
		}
	}

	public int calcPubKeyRecoveryParam(BigInteger e, SignBigInt sign, ECPoint Q) {
		for (int i = 0; i < 4; i++) {
			ECPoint Qprime = recoverPubKey(e, sign, i);
			if (Qprime.equals(Q)) {
				return i;
			}
		}
		throw new CryptoException("sign_error", "Unable to find valid recovery factor");
	}

	public ECPoint recoverPubKey(BigInteger e, SignBigInt big, int i) {

		BigInteger n = Secp256k1.N();
		ECPoint G = Secp256k1.G();

		BigInteger r = big.getR();
		BigInteger s = big.getS();

		if (!(r.signum() > 0 && r.compareTo(n) < 0)) {
			throw new CryptoException("recover_pubkey_error", "Invalid r value");
		}
		if (!(s.signum() > 0 && s.compareTo(n) < 0)) {
			throw new CryptoException("recover_pubkey_error", "Invalid r value");
		}

		// A set LSB signifies that the y-coordinate is odd
		int isYOdd = i & 1;

		// The more significant bit specifies whether we should use the
		// first or second candidate key.
		int isSecondKey = i >> 1;

		// 1.1 Let x = r + jn
		BigInteger x = isSecondKey == 1 ? r.add(n) : r;

		ECPoint R = Secp256k1.pointFromX(isYOdd, x);

		// // 1.4 Check that nR is at infinity
		ECPoint nR = R.multiply(n);

		if (!nR.isInfinity()) {
			throw new CryptoException("sign_error", "nR is not a valid curve point");
		}

		BigInteger eNeg = e.negate().mod(n);

		BigInteger rInv = r.modInverse(n);

		ECPoint Q = Secp256k1.ecmult(R, s, G, eNeg).multiply(rInv);

		if (Q.isInfinity()) {
			throw new CryptoException("sign_error", "Point is at infinity");
		}

		return Q;
	}
	
}
