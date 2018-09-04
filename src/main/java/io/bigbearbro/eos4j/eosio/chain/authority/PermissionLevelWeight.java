package io.bigbearbro.eos4j.eosio.chain.authority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.action.PermissionLevel;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionLevelWeight {
	
	@JsonProperty("permission")
	private PermissionLevel permission;
	
	@JsonProperty("weight")
	private Long weight;

	public PermissionLevel getPermission() {
		return permission;
	}

	public void setPermission(PermissionLevel permission) {
		this.permission = permission;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
}
