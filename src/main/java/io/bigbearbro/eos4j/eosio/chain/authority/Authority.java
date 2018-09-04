package io.bigbearbro.eos4j.eosio.chain.authority;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Authority {

	@JsonProperty("threshold")
	private Long threshold;
	
	@JsonProperty("keys")
	private List<KeyWeight> keys;
	
	@JsonProperty("accounts")
	private List<PermissionLevelWeight> accounts;

	@JsonProperty("waits")
	private List<WaitWeight> waits;
	
	public List<PermissionLevelWeight> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<PermissionLevelWeight> accounts) {
		this.accounts = accounts;
	}

	public List<KeyWeight> getKeys() {
		return keys;
	}

	public void setKeys(List<KeyWeight> keys) {
		this.keys = keys;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public List<WaitWeight> getWaits() {
		return waits;
	}

	public void setWaits(List<WaitWeight> waits) {
		this.waits = waits;
	}
	
}
