package io.bigbearbro.eos4j.api.request.push_transaction.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;
/**
 * 抵押action用到的data
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DelegatebwActionData extends BaseActionData {

	@Pack(PackType.name)
	@JsonProperty("from")
	private String from;

	@Pack(PackType.name)
	@JsonProperty("receiver")
	private String receiver;

	@Pack(PackType.asset)
	@JsonProperty("stake_net_quantity")
	private String stakeNetQuantity;

	@Pack(PackType.asset)
	@JsonProperty("stake_cpu_quantity")
	private String stakeCpuQuantity;
	
	@Pack(PackType.uint8)
	@JsonProperty("transfer")
	private Long transfer;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getStakeNetQuantity() {
		return stakeNetQuantity;
	}

	public void setStakeNetQuantity(String stakeNetQuantity) {
		this.stakeNetQuantity = stakeNetQuantity;
	}

	public String getStakeCpuQuantity() {
		return stakeCpuQuantity;
	}

	public void setStakeCpuQuantity(String stakeCpuQuantity) {
		this.stakeCpuQuantity = stakeCpuQuantity;
	}

	public Long getTransfer() {
		return transfer;
	}

	public void setTransfer(Long transfer) {
		this.transfer = transfer;
	}
	

}
