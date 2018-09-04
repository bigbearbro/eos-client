package io.bigbearbro.eos4j.api.result.get_transaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.transaction.PackedTransaction;
import io.bigbearbro.eos4j.eosio.chain.transaction.SignedTransaction;
/**
 * jsonpath 
 * get_transaction#trx
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrxAndReceipt {
	
	@JsonProperty("receipt")
	private TransactionReceiptWithTrxList<PackedTransaction> receipt;
	
	@JsonProperty("trx")
	private SignedTransaction trx;

	public TransactionReceiptWithTrxList<PackedTransaction> getReceipt() {
		return receipt;
	}

	public void setReceipt(TransactionReceiptWithTrxList<PackedTransaction> receipt) {
		this.receipt = receipt;
	}

	public SignedTransaction getTrx() {
		return trx;
	}

	public void setTrx(SignedTransaction trx) {
		this.trx = trx;
	}
	
}
