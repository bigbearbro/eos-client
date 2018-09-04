package io.bigbearbro.eos4j.api.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.api.result.get_block.BlockPackedTransaction;
import io.bigbearbro.eos4j.eosio.chain.block.SignedBlock;
import io.bigbearbro.eos4j.eosio.chain.block.TransactionReceipt;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlockResult extends SignedBlock<TransactionReceipt<BlockPackedTransaction>> {

	@JsonProperty("id")
	private String id;

	@JsonProperty("block_num")
	private Long blockNum;

	@JsonProperty("ref_block_prefix")
	private Long refBlockPrefix;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(Long blockNum) {
		this.blockNum = blockNum;
	}

	public Long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	public void setRefBlockPrefix(Long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

}
