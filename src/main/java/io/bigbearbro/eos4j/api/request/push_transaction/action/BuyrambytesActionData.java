package io.bigbearbro.eos4j.api.request.push_transaction.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;

/**
 * 购买ram字节action用到的data
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuyrambytesActionData extends BaseActionData {

	@Pack(PackType.name)
	@JsonProperty("payer")
	private String payer;

	@Pack(PackType.name)
	@JsonProperty("receiver")
	private String receiver;

	@Pack(PackType.uint32)
	@JsonProperty("bytes")
	private Long bytes;

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Long getBytes() {
		return bytes;
	}

	public void setBytes(Long bytes) {
		this.bytes = bytes;
	}
}
