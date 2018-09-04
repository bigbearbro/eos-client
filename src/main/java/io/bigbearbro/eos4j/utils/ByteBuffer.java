package io.bigbearbro.eos4j.utils;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class ByteBuffer {

	private byte[] buffer = new byte[] {};

	public void concat(byte[] b) {
		buffer = ByteUtils.concat(buffer, b);
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public void setBuffer(byte[] buffer) {
		this.buffer = buffer;
	}
}
