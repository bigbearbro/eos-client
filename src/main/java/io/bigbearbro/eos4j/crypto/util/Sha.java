package io.bigbearbro.eos4j.crypto.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.crypto.digests.SHA256Digest;

import io.bigbearbro.eos4j.client.exception.CryptoException;
/**
 * 
 * @author wuwei
 *
 */
public class Sha {

	public static byte[] SHA256(byte[] bytes) {
		return SHA256(bytes, 0, bytes.length);
	}

	public static byte[] SHA256(final String text) {
		try {
			return SHA256(text.getBytes("utf8"));
		} catch (UnsupportedEncodingException e) {
			throw new CryptoException("SHA256", e.getMessage());
		}
	}

	public static byte[] SHA256(byte[] bytes, int offset, int size) {
		SHA256Digest sha256Digest = new SHA256Digest();
		sha256Digest.update(bytes, offset, size);
		byte[] sha256 = new byte[32];
		sha256Digest.doFinal(sha256, 0);
		return sha256;
	}

	/**
	 * HMACSHA256
	 * 
	 * @param data
	 * @param key
	 * @return
	 */
	public static byte[] HmacSHA256(byte[] data, byte[] key) {
		SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA256");
		try {
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			return mac.doFinal(data);
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			throw new CryptoException("HmacSHA256", e.getMessage());
		}
	}

	public static byte[] doubleSHA256(byte[] bytes) {
        return doubleSHA256(bytes, 0, bytes.length);
    }

    public static byte[] doubleSHA256(byte[] bytes, int offset, int size) {
    	return SHA256(SHA256(bytes, offset, size));
    }
}
