package io.bigbearbro.eos4j.eosio.chain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionReciept {
	@JsonProperty("receiver")
	private String receiver;
	@JsonProperty("act_digest")
	private String actDigest;
	@JsonProperty("global_sequence")
	private Long globalSequence;
	@JsonProperty("recv_sequence")
	private Long recvSequence;
	@JsonProperty("auth_sequence")
	private List<Object> authSequence;
	@JsonProperty("code_sequence")
	private Long codeSequence;
	@JsonProperty("abi_sequence")
	private Long abiSequence;
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getActDigest() {
		return actDigest;
	}
	public void setActDigest(String actDigest) {
		this.actDigest = actDigest;
	}
	public Long getGlobalSequence() {
		return globalSequence;
	}
	public void setGlobalSequence(Long globalSequence) {
		this.globalSequence = globalSequence;
	}
	public Long getRecvSequence() {
		return recvSequence;
	}
	public void setRecvSequence(Long recvSequence) {
		this.recvSequence = recvSequence;
	}
	public List<Object> getAuthSequence() {
		return authSequence;
	}
	public void setAuthSequence(List<Object> authSequence) {
		this.authSequence = authSequence;
	}
	public Long getCodeSequence() {
		return codeSequence;
	}
	public void setCodeSequence(Long codeSequence) {
		this.codeSequence = codeSequence;
	}
	public Long getAbiSequence() {
		return abiSequence;
	}
	public void setAbiSequence(Long abiSequence) {
		this.abiSequence = abiSequence;
	}
	
}
