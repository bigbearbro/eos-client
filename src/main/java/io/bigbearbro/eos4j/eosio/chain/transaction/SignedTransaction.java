package io.bigbearbro.eos4j.eosio.chain.transaction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * jsonpath: get_transaction#trx.trx
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedTransaction extends Transaction {
	@JsonProperty("signatures")
	private List<String> signatures;
	
	@JsonProperty("context_free_data")
	private List<Object> contextFreeData;

	public List<Object> getContextFreeData() {
		return contextFreeData;
	}

	public void setContextFreeData(List<Object> contextFreeData) {
		this.contextFreeData = contextFreeData;
	}

	public List<String> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<String> signatures) {
		this.signatures = signatures;
	}

}
