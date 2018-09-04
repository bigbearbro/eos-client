package io.bigbearbro.eos4j.client.exception;

/**
 * 
 * @author wangyan
 *
 */
public class CryptoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CryptoException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private String code;

	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}