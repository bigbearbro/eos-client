package io.bigbearbro.eos4j.client.pack;

/**
 * 
 * @author wangyan
 *
 */
public enum PackType {

	asset("asset"), 
	bytes("bytes"), 
	hexString("hexString"), 
	key("key"), 
	name("name"), 
	object("object"), 
	string("string"), 
	uint16("uint16"), 
	uint32("uint32"), 
	uint64("uint64"), 
	uint8("uint8"), 
	varint32("varint32");

	private String code;

	private PackType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
