package io.bigbearbro.eos4j.eosio.chain.block_header;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignedBlockHeader extends BlockHeader {
	
	@JsonProperty("producer_signature")
	private String producerSignature;

	public String getProducerSignature() {
		return producerSignature;
	}

	public void setProducerSignature(String producerSignature) {
		this.producerSignature = producerSignature;
	}
	
}
