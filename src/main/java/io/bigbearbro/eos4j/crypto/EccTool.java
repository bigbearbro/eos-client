package io.bigbearbro.eos4j.crypto;

import java.math.BigInteger;
import java.util.Arrays;

import org.bouncycastle.math.ec.ECPoint;

import io.bigbearbro.eos4j.client.exception.CryptoException;
import io.bigbearbro.eos4j.client.pack.PackUtils;
import io.bigbearbro.eos4j.client.transaction.TransactionToSign;
import io.bigbearbro.eos4j.crypto.util.Base58;
import io.bigbearbro.eos4j.crypto.util.Ripemd160;
import io.bigbearbro.eos4j.crypto.util.Sha;
import io.bigbearbro.eos4j.utils.ByteBuffer;
import io.bigbearbro.eos4j.utils.ByteUtils;
import io.bigbearbro.eos4j.utils.Hex;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class EccTool {

	public static final String address_prefix = "EOS";

	public static String privateKeyFromSeed(String seed) {
		return privateKeyFromBigInteger(new BigInteger(Sha.SHA256(seed)));
	}

	public static String privateKeyFromBigInteger(BigInteger d) {
		byte[] a = { (byte) 0x80 };
		byte[] b = d.toByteArray();
		byte[] private_key = ByteUtils.concat(a, b);
		byte[] checksum = ByteUtils.copy(Sha.doubleSHA256(private_key), 0, 4);
		byte[] pk = ByteUtils.concat(private_key, checksum);
		return Base58.encode(pk);
	}

	/**
	 * privateKey
	 * 
	 * @param pk
	 * @return
	 */
	private static BigInteger privateKey(String pk) {
		byte[] private_wif = Base58.decode(pk);
		byte version = (byte) 0x80;
		if (private_wif[0] != version) {
			throw new CryptoException("version_error", "Expected version " + 0x80 + ", instead got " + version);
		}
		byte[] private_key = ByteUtils.copy(private_wif, 0, private_wif.length - 4);
		byte[] new_checksum = ByteUtils.copy(Sha.doubleSHA256(private_key), 0, 4);
		byte[] checksum = ByteUtils.copy(private_wif, private_wif.length - 4, 4);
		if (!Arrays.equals(new_checksum, checksum)) {
			throw new CryptoException("privateKey", "checksum is not equal");
		}
		byte[] last_private_key = ByteUtils.copy(private_key, 1, private_key.length - 1);
		BigInteger d = new BigInteger(Hex.bytesToHexString(last_private_key), 16);
		return d;
	}

	/**
	 * privateToPublic
	 * 
	 * @param pk
	 * @return
	 */
	public static String privateToPublic(String pk) {
		if (pk == null || pk.length() == 0) {
			throw new CryptoException("args_empty", "args is empty");
		}
		// private key
		BigInteger d = privateKey(pk);
		// publick key
		ECPoint ep = Secp256k1.G().multiply(d);
		byte[] pub_buf = ep.getEncoded(false);
		byte[] csum = Ripemd160.digest(pub_buf);
		csum = ByteUtils.copy(csum, 0, 4);
		byte[] addy = ByteUtils.concat(pub_buf, csum);
		StringBuffer bf = new StringBuffer(address_prefix);
		bf.append(Base58.encode(addy));
		return bf.toString();
	}

	/**
	 * signHash
	 * 
	 * @param pk
	 * @param b
	 * @return
	 */
	public static String signHash(String pk, byte[] b) {
		String dataSha256 = Hex.bytesToHexString(Sha.SHA256(b));
		BigInteger e = new BigInteger(dataSha256, 16);
		int nonce = 0;
		int i = 0;
		BigInteger d = privateKey(pk);
		ECPoint Q = Secp256k1.G().multiply(d);
		nonce = 0;
		Ecdsa ecd = new Ecdsa();
		Ecdsa.SignBigInt sign;
		while (true) {
			sign = ecd.sign(dataSha256, d, nonce++);
			byte der[] = sign.getDer();
			byte lenR = der[3];
			byte lenS = der[5 + lenR];
			if (lenR == 32 && lenS == 32) {
				i = ecd.calcPubKeyRecoveryParam(e, sign, Q);
				i += 4; // compressed
				i += 27; // compact // 24 or 27 :( forcing odd-y 2nd key candidate)
				break;
			}
		}
		byte[] pub_buf = new byte[65];
		pub_buf[0] = (byte) i;
		ByteUtils.copy(sign.getR().toByteArray(), 0, pub_buf, 1, sign.getR().toByteArray().length);
		ByteUtils.copy(sign.getS().toByteArray(), 0, pub_buf, sign.getR().toByteArray().length + 1,
				sign.getS().toByteArray().length);

		byte[] checksum = Ripemd160.digest(ByteUtils.concat(pub_buf, "K1".getBytes()));

		byte[] signatureString = ByteUtils.concat(pub_buf, ByteUtils.copy(checksum, 0, 4));

		return "SIG_K1_" + Base58.encode(signatureString);
	}

	/**
	 * sign string
	 * 
	 * @param pk
	 * @param data
	 * @return
	 */
	public static String sign(String pk, String data) {
		String dataSha256 = Hex.bytesToHexString(Sha.SHA256(data));
		BigInteger e = new BigInteger(dataSha256, 16);
		int nonce = 0;
		int i = 0;
		BigInteger d = privateKey(pk);
		ECPoint Q = Secp256k1.G().multiply(d);
		nonce = 0;
		Ecdsa ecd = new Ecdsa();
		Ecdsa.SignBigInt sign;
		while (true) {
			sign = ecd.sign(dataSha256, d, nonce++);
			byte der[] = sign.getDer();
			byte lenR = der[3];
			byte lenS = der[5 + lenR];
			if (lenR == 32 && lenS == 32) {
				i = ecd.calcPubKeyRecoveryParam(e, sign, Q);
				i += 4; // compressed
				i += 27; // compact // 24 or 27 :( forcing odd-y 2nd key candidate)
				break;
			}
		}
		byte[] pub_buf = new byte[65];
		pub_buf[0] = (byte) i;
		ByteUtils.copy(sign.getR().toByteArray(), 0, pub_buf, 1, sign.getR().toByteArray().length);
		ByteUtils.copy(sign.getS().toByteArray(), 0, pub_buf, sign.getR().toByteArray().length + 1,
				sign.getS().toByteArray().length);

		byte[] checksum = Ripemd160.digest(ByteUtils.concat(pub_buf, "K1".getBytes()));

		byte[] signatureString = ByteUtils.concat(pub_buf, ByteUtils.copy(checksum, 0, 4));

		return "SIG_K1_" + Base58.encode(signatureString);
	}

	/**
	 * signTransaction
	 * 
	 * @param privateKey
	 * @param push
	 * @return
	 */
	public static String signTransaction(String privateKey, TransactionToSign push) {
		// tx
		ByteBuffer bf = new ByteBuffer();
		PackUtils.packObj(push, bf);
		byte[] real = bf.getBuffer();
		// append
		real = ByteUtils.concat(real, java.nio.ByteBuffer.allocate(32).array());

		return signHash(privateKey, real);
	}

}
