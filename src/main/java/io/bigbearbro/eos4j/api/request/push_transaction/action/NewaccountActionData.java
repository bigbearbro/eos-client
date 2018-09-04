package io.bigbearbro.eos4j.api.request.push_transaction.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;
/**
 * 创建新账号action用的data
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewaccountActionData extends BaseActionData {

	@Pack(PackType.name)
	@JsonProperty("creator")
	private String creator;

	@Pack(PackType.name)
	@JsonProperty("name")
	private String name;

	@Pack(PackType.key)
	@JsonProperty("owner")
	private String owner;

	@Pack(PackType.key)
	@JsonProperty("active")
	private String active;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
