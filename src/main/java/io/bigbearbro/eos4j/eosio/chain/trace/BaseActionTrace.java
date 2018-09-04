package io.bigbearbro.eos4j.eosio.chain.trace;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.ActionReciept;
import io.bigbearbro.eos4j.eosio.chain.action.Action;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseActionTrace {
	@JsonProperty("receipt")
	private ActionReciept receipt;
	@JsonProperty("act")
	private Action act;
	@JsonProperty("elapsed")
	private Long elapsed;
	@JsonProperty("cpu_usage")
	private Long cpuUsage;
	@JsonProperty("console")
	private String console;
	@JsonProperty("total_cpu_usage")
	private Long totalCpuUsage;
	@JsonProperty("trx_id")
	private String trxId;
	
	public ActionReciept getReceipt() {
		return receipt;
	}
	public void setReceipt(ActionReciept receipt) {
		this.receipt = receipt;
	}
	public Action getAct() {
		return act;
	}
	public void setAct(Action act) {
		this.act = act;
	}
	public Long getElapsed() {
		return elapsed;
	}
	public void setElapsed(Long elapsed) {
		this.elapsed = elapsed;
	}
	public Long getCpuUsage() {
		return cpuUsage;
	}
	public void setCpuUsage(Long cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public Long getTotalCpuUsage() {
		return totalCpuUsage;
	}
	public void setTotalCpuUsage(Long totalCpuUsage) {
		this.totalCpuUsage = totalCpuUsage;
	}
	public String getTrxId() {
		return trxId;
	}
	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}
	
}
