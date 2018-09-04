package io.bigbearbro.eos4j.eosio.chain.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.transaction.PackedTransaction;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReceipt<T extends PackedTransaction> extends TransactionReceiptHeader {

	@JsonProperty("trx")
	private T trx;

	public T getTrx() {
		return trx;
	}

	public void setTrx(T trx) {
		this.trx = trx;
	}

}
