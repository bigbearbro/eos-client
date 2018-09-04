package io.bigbearbro.eos4j.api.result;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.AccountResourceLimit;
import io.bigbearbro.eos4j.eosio.chain.authority.Permission;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountResults {

	@JsonProperty("account_name")
	private String accountName;
	
	@JsonProperty("head_block_num")
	private Long headBlockNum;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@JsonProperty("head_block_time")
	private Date headBlockTime;
	
	@JsonProperty("privileged")
	private Boolean privileged;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@JsonProperty("last_code_update")
	private Date lastCodeUpdate;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@JsonProperty("created")
	private Date created;

	@JsonProperty("ram_quota")
	private Long ramQuota;

	@JsonProperty("net_weight")
	private Long netWeight;

	@JsonProperty("cpu_weight")
	private Long cpuWeight;

	@JsonProperty("net_limit")
	private AccountResourceLimit netLimit;

	@JsonProperty("cpu_limit")
	private AccountResourceLimit cpuLimit;

	@JsonProperty("ram_usage")
	private Long ramUsage;

	@JsonProperty("permissions")
	private List<Permission> permissions;

	@JsonProperty("total_resources")
	private Object totalResources;
	
	@JsonProperty("self_delegated_bandwidth")
	private Object selfDelegatedBandwidth;
	
	@JsonProperty("refund_request")
	private Object refundRequest;
	
	@JsonProperty("voter_info")
	private Object voterInfo;
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Boolean getPrivileged() {
		return privileged;
	}

	public void setPrivileged(Boolean privileged) {
		this.privileged = privileged;
	}

	public Date getLastCodeUpdate() {
		return lastCodeUpdate;
	}

	public void setLastCodeUpdate(Date lastCodeUpdate) {
		this.lastCodeUpdate = lastCodeUpdate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getRamQuota() {
		return ramQuota;
	}

	public void setRamQuota(Long ramQuota) {
		this.ramQuota = ramQuota;
	}

	public Long getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Long netWeight) {
		this.netWeight = netWeight;
	}

	public Long getCpuWeight() {
		return cpuWeight;
	}

	public void setCpuWeight(Long cpuWeight) {
		this.cpuWeight = cpuWeight;
	}

	public AccountResourceLimit getNetLimit() {
		return netLimit;
	}

	public void setNetLimit(AccountResourceLimit netLimit) {
		this.netLimit = netLimit;
	}

	public AccountResourceLimit getCpuLimit() {
		return cpuLimit;
	}

	public void setCpuLimit(AccountResourceLimit cpuLimit) {
		this.cpuLimit = cpuLimit;
	}

	public Long getRamUsage() {
		return ramUsage;
	}

	public void setRamUsage(Long ramUsage) {
		this.ramUsage = ramUsage;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public Long getHeadBlockNum() {
		return headBlockNum;
	}

	public void setHeadBlockNum(Long headBlockNum) {
		this.headBlockNum = headBlockNum;
	}

	public Date getHeadBlockTime() {
		return headBlockTime;
	}

	public void setHeadBlockTime(Date headBlockTime) {
		this.headBlockTime = headBlockTime;
	}

	public Object getTotalResources() {
		return totalResources;
	}

	public void setTotalResources(Object totalResources) {
		this.totalResources = totalResources;
	}

	public Object getSelfDelegatedBandwidth() {
		return selfDelegatedBandwidth;
	}

	public void setSelfDelegatedBandwidth(Object selfDelegatedBandwidth) {
		this.selfDelegatedBandwidth = selfDelegatedBandwidth;
	}

	public Object getRefundRequest() {
		return refundRequest;
	}

	public void setRefundRequest(Object refundRequest) {
		this.refundRequest = refundRequest;
	}

	public Object getVoterInfo() {
		return voterInfo;
	}

	public void setVoterInfo(Object voterInfo) {
		this.voterInfo = voterInfo;
	}

}
