package io.bigbearbro.eos4j.crypto;

import java.math.BigInteger;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.custom.sec.SecP256K1Curve;
/**
 * 
 * @author wuwei
 *
 */
public class Secp256k1 {

	static ECNamedCurveParameterSpec params;
	static SecP256K1Curve curve;
	static BigInteger qAddOneOverFour;

	static {
		params = ECNamedCurveTable.getParameterSpec("secp256k1");
		curve = (SecP256K1Curve) params.getCurve();
		qAddOneOverFour = curve.getQ().add(BigInteger.ONE).shiftRight(2);
	}

	public static ECPoint G() {
		return params.getG();
	}

	public static BigInteger N() {
		return params.getN();
	}

	public static BigInteger halfCurveOrder() {
		return params.getN().shiftRight(1);
	}

	public static ECCurve getCurve() {
		return curve;
	}

	/**
	 * x^3+ax+b mod q
	 * y = (y2)^ ((q+1)/4)  mod q
	 * @param isOdd
	 * @param x
	 * @return
	 */
	public static ECPoint pointFromX(int isOdd, BigInteger x) {
		ECFieldElement f = curve.getA().multiply(curve.fromBigInteger(x));
		// y^2 = x^3+ax+b mod q
		BigInteger alpha = x.pow(3).add(f.toBigInteger()).add(curve.getB().toBigInteger()).mod(curve.getQ());
		// y = (y2)^ ((q+1)/4)  mod q
		BigInteger beta = alpha.modPow(qAddOneOverFour, curve.getQ());
		BigInteger y = beta;
		if (beta.intValue() % 2 == 0 ^ isOdd == 0) {
			// (y2 = q - y1) is another root
			y = curve.getQ().subtract(y);
		}
		return curve.createPoint(x, y);
	}

	/** Double multiply: R = na*A + ng*G */
	public static ECPoint ecmult(ECPoint A, BigInteger na, ECPoint G, BigInteger ng) {
		int i = Math.max(na.bitLength(), ng.bitLength()) - 1;
		ECPoint R = curve.getInfinity();
		ECPoint both = A.add(G);
		while (i >= 0) {
			Boolean jBit = na.testBit(i);
			Boolean kBit = ng.testBit(i);

			R = R.twice();

			if (jBit) {
				if (kBit) {
					R = R.add(both);
				} else {
					R = R.add(A);
				}
			} else if (kBit) {
				R = R.add(G);
			}
			--i;
		}
		return R;
	}

}
