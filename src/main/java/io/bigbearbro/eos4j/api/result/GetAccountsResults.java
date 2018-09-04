package io.bigbearbro.eos4j.api.result;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccountsResults {
	@JsonProperty("account_names")
	private List<String> accountNames;

	public List<String> getAccountNames() {
		return accountNames;
	}

	public void setAccountNames(List<String> accountNames) {
		this.accountNames = accountNames;
	}
	
}
