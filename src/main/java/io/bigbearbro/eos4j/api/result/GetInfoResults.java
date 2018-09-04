package io.bigbearbro.eos4j.api.result;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetInfoResults {

	@JsonProperty("server_version")
	private String serverVersion;

	@JsonProperty("chain_id")
	private String chainId;

	@JsonProperty("head_block_num")
	private Long headBlockNum;

	@JsonProperty("last_irreversible_block_num")
	private Long lastIrreversibleBlockNum;

	@JsonProperty("last_irreversible_block_id")
	private String lastIrreversibleBlockId;

	@JsonProperty("head_block_id")
	private String headBlockId;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@JsonProperty("head_block_time")
	private Date headBlockTime;

	@JsonProperty("head_block_producer")
	private String headBlockProducer;

	@JsonProperty("virtual_block_cpu_limit")
	private String virtualBlockCpuLimit;

	@JsonProperty("virtual_block_net_limit")
	private String virtualBlockNetLimit;

	@JsonProperty("block_cpu_limit")
	private String blockCpuLimit;

	@JsonProperty("block_net_limit")
	private String blockNetLimit;

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getChainId() {
		return chainId;
	}

	public void setChainId(String chainId) {
		this.chainId = chainId;
	}

	public Long getHeadBlockNum() {
		return headBlockNum;
	}

	public void setHeadBlockNum(Long headBlockNum) {
		this.headBlockNum = headBlockNum;
	}

	public Long getLastIrreversibleBlockNum() {
		return lastIrreversibleBlockNum;
	}

	public void setLastIrreversibleBlockNum(Long lastIrreversibleBlockNum) {
		this.lastIrreversibleBlockNum = lastIrreversibleBlockNum;
	}

	public String getLastIrreversibleBlockId() {
		return lastIrreversibleBlockId;
	}

	public void setLastIrreversibleBlockId(String lastIrreversibleBlockId) {
		this.lastIrreversibleBlockId = lastIrreversibleBlockId;
	}

	public Date getHeadBlockTime() {
		return headBlockTime;
	}

	public void setHeadBlockTime(Date headBlockTime) {
		this.headBlockTime = headBlockTime;
	}

	public String getHeadBlockProducer() {
		return headBlockProducer;
	}

	public void setHeadBlockProducer(String headBlockProducer) {
		this.headBlockProducer = headBlockProducer;
	}

	public String getVirtualBlockCpuLimit() {
		return virtualBlockCpuLimit;
	}

	public void setVirtualBlockCpuLimit(String virtualBlockCpuLimit) {
		this.virtualBlockCpuLimit = virtualBlockCpuLimit;
	}

	public String getVirtualBlockNetLimit() {
		return virtualBlockNetLimit;
	}

	public void setVirtualBlockNetLimit(String virtualBlockNetLimit) {
		this.virtualBlockNetLimit = virtualBlockNetLimit;
	}

	public String getBlockCpuLimit() {
		return blockCpuLimit;
	}

	public void setBlockCpuLimit(String blockCpuLimit) {
		this.blockCpuLimit = blockCpuLimit;
	}

	public String getBlockNetLimit() {
		return blockNetLimit;
	}

	public void setBlockNetLimit(String blockNetLimit) {
		this.blockNetLimit = blockNetLimit;
	}

	public String getHeadBlockId() {
		return headBlockId;
	}

	public void setHeadBlockId(String headBlockId) {
		this.headBlockId = headBlockId;
	}
}
