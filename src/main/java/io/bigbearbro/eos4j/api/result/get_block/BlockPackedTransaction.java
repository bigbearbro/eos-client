package io.bigbearbro.eos4j.api.result.get_block;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.transaction.PackedTransaction;
import io.bigbearbro.eos4j.eosio.chain.transaction.Transaction;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockPackedTransaction extends PackedTransaction {

	@JsonProperty("id")
	private String id;

	@JsonProperty("context_free_data")
	private List<Object> contextFreeData;

	@JsonProperty("transaction")
	private Transaction transaction;

	/**
	 * 正常返回对象结构的构造函数
	 */
	public BlockPackedTransaction() {

	}

	/**
	 * 在一些情况下trx返回值是交易id
	 * 
	 * @param hash
	 */
	public BlockPackedTransaction(String txId) {
		super(txId);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Object> getContextFreeData() {
		return contextFreeData;
	}

	public void setContextFreeData(List<Object> contextFreeData) {
		this.contextFreeData = contextFreeData;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
