package io.bigbearbro.eos4j.eosio.chain.producer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProducerKey {
	
	@JsonProperty("producer_name")
	private String producerName;
	
	@JsonProperty("block_signing_key")
	private String blockSigningKey;

	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	public String getBlockSigningKey() {
		return blockSigningKey;
	}

	public void setBlockSigningKey(String blockSigningKey) {
		this.blockSigningKey = blockSigningKey;
	}
	
}
