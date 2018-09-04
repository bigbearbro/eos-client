package io.bigbearbro.eos4j.eosio.chain.authority;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WaitWeight {
	
	@JsonProperty("wait_sec")
	private Long waitSec;
	
	@JsonProperty("weight")
	private Long weight;

	public Long getWaitSec() {
		return waitSec;
	}

	public void setWaitSec(Long waitSec) {
		this.waitSec = waitSec;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
}
