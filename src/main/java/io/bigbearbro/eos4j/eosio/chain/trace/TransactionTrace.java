package io.bigbearbro.eos4j.eosio.chain.trace;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.block.TransactionReceiptHeader;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionTrace {

	@JsonProperty("id")
	private String id;

	@JsonProperty("receipt")
	private TransactionReceiptHeader receipt;

	@JsonProperty("elapsed")
	private Long elapsed;

	@JsonProperty("net_usage")
	private Long netUsage;

	@JsonProperty("scheduled")
	private Boolean scheduled;

	@JsonProperty("action_traces")
	private List<ActionTrace> actionTraces;
	
	@JsonProperty("except")
	private Object except;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TransactionReceiptHeader getReceipt() {
		return receipt;
	}

	public void setReceipt(TransactionReceiptHeader receipt) {
		this.receipt = receipt;
	}

	public Long getElapsed() {
		return elapsed;
	}

	public void setElapsed(Long elapsed) {
		this.elapsed = elapsed;
	}

	public Long getNetUsage() {
		return netUsage;
	}

	public void setNetUsage(Long netUsage) {
		this.netUsage = netUsage;
	}

	public Boolean getScheduled() {
		return scheduled;
	}

	public void setScheduled(Boolean scheduled) {
		this.scheduled = scheduled;
	}

	public List<ActionTrace> getActionTraces() {
		return actionTraces;
	}

	public void setActionTraces(List<ActionTrace> actionTraces) {
		this.actionTraces = actionTraces;
	}

	public Object getExcept() {
		return except;
	}

	public void setExcept(Object except) {
		this.except = except;
	}
	
}
