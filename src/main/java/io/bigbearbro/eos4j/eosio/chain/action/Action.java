package io.bigbearbro.eos4j.eosio.chain.action;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {
	
	@Pack(PackType.name)
	@JsonProperty("account")
	private String account;

	@Pack(PackType.name)
	@JsonProperty("name")
	private String name;

	@Pack
	@JsonProperty("authorization")
	private List<PermissionLevel> authorization;

	@Pack(PackType.bytes)
	@JsonProperty("data")
	private Object data;
	
	@JsonProperty("hex_data")
	private String hexData;

	public Action() {

	}

	public Action(String actor, String account, String name, Object data) {
		this.account = account;
		this.name = name;
		this.data = data;
		this.authorization = new ArrayList<>();
		this.authorization.add(new PermissionLevel(actor, "active"));
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PermissionLevel> getAuthorization() {
		return authorization;
	}

	public void setAuthorization(List<PermissionLevel> authorization) {
		this.authorization = authorization;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getHexData() {
		return hexData;
	}

	public void setHexData(String hexData) {
		this.hexData = hexData;
	}
}
