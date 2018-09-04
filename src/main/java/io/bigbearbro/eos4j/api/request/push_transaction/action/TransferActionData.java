package io.bigbearbro.eos4j.api.request.push_transaction.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;
/**
 * 转账action使用的data
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferActionData extends BaseActionData {

	@Pack(PackType.name)
	@JsonProperty("from")
	private String from;

	@Pack(PackType.name)
	@JsonProperty("to")
	private String to;

	@Pack(PackType.asset)
	@JsonProperty("quantity")
	private String quantity;

	@Pack(PackType.string)
	@JsonProperty("memo")
	private String memo;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
