package io.bigbearbro.eos4j.api.result;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.api.result.get_transaction.TrxAndReceipt;
import io.bigbearbro.eos4j.eosio.chain.trace.ActionTrace;
/**
 * get_transaction
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionResult {
	@JsonProperty("id")
	private String id;
	@JsonProperty("trx")
	private TrxAndReceipt trx;
	@JsonProperty("block_time")
	private Date blockTime;
	@JsonProperty("block_num")
	private Long blockNum;
	@JsonProperty("last_irreversible_block")
	private Long lastIrreversibleBlock;
	@JsonProperty("traces")
	private List<ActionTrace> traces;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TrxAndReceipt getTrx() {
		return trx;
	}
	public void setTrx(TrxAndReceipt trx) {
		this.trx = trx;
	}
	public Date getBlockTime() {
		return blockTime;
	}
	public void setBlockTime(Date blockTime) {
		this.blockTime = blockTime;
	}
	public Long getBlockNum() {
		return blockNum;
	}
	public void setBlockNum(Long blockNum) {
		this.blockNum = blockNum;
	}	
	public Long getLastIrreversibleBlock() {
		return lastIrreversibleBlock;
	}
	public void setLastIrreversibleBlock(Long lastIrreversibleBlock) {
		this.lastIrreversibleBlock = lastIrreversibleBlock;
	}
	public List<ActionTrace> getTraces() {
		return traces;
	}
	public void setTraces(List<ActionTrace> traces) {
		this.traces = traces;
	}
	
}
