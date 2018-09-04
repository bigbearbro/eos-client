package io.bigbearbro.eos4j.api.result.get_transaction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.block.TransactionReceiptHeader;
import io.bigbearbro.eos4j.eosio.chain.transaction.PackedTransaction;

/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReceiptWithTrxList<T extends PackedTransaction> extends TransactionReceiptHeader {

	@JsonProperty("trx")
	private List<T> trx;

	public List<T> getTrx() {
		return trx;
	}

	public void setTrx(List<T> trx) {
		this.trx = trx;
	}

}
