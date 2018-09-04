package io.bigbearbro.eos4j.crypto.util;

import org.bouncycastle.crypto.digests.RIPEMD160Digest;
/**
 * 
 * @author wuwei
 *
 */
public class Ripemd160 {

	public static byte[] digest(byte[] data) {
		return Ripemd160.digest(data, 0, (data != null) ? data.length : 0);
	}

	public static byte[] digest(byte[] data, int startOffset, int length) {
		RIPEMD160Digest digest = new RIPEMD160Digest();
		digest.update(data, startOffset, length);
		byte[] result = new byte[digest.getDigestSize()];
		digest.doFinal(result, 0);
		return result;
	}
}
