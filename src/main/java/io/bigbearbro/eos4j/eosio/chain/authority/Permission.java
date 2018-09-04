package io.bigbearbro.eos4j.eosio.chain.authority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Permission {

	@JsonProperty("perm_name")
	private String permName;

	@JsonProperty("parent")
	private String parent;

	@JsonProperty("required_auth")
	private Authority requiredAuth;

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Authority getRequiredAuth() {
		return requiredAuth;
	}

	public void setRequiredAuth(Authority requiredAuth) {
		this.requiredAuth = requiredAuth;
	}
}
