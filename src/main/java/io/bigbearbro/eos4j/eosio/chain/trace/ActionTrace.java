package io.bigbearbro.eos4j.eosio.chain.trace;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActionTrace extends BaseActionTrace {
	@JsonProperty("inline_traces")
	private List<ActionTrace> inlineTraces;

	public List<ActionTrace> getInlineTraces() {
		return inlineTraces;
	}

	public void setInlineTraces(List<ActionTrace> inlineTraces) {
		this.inlineTraces = inlineTraces;
	}

}
