package io.bigbearbro.eos4j.eosio.chain.transaction;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackedTransaction {
	
	private boolean isNumber = false;
	private boolean isTxId = false;
	private String txId;
	
	@JsonProperty("signatures")
	private List<String> signatures;

	@JsonProperty("compression")
	private String compression;

	@JsonProperty("packed_context_free_data")
	private String packedContextFreeData;

	@JsonProperty("packed_trx")
	private String packedTrx;

	public PackedTransaction() {
	}

	/**
	 * 用于get_transaction反序列化trx.trx中出现的整形
	 * 
	 * @param p
	 */
	public PackedTransaction(Long p) {
		isNumber = true;
	}

	public PackedTransaction(String txId) {
		this.txId = txId;
		isTxId = true;
	}

	public List<String> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<String> signatures) {
		this.signatures = signatures;
	}

	public String getCompression() {
		return compression;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public String getPackedContextFreeData() {
		return packedContextFreeData;
	}

	public void setPackedContextFreeData(String packedContextFreeData) {
		this.packedContextFreeData = packedContextFreeData;
	}

	public String getPackedTrx() {
		return packedTrx;
	}

	public void setPackedTrx(String packedTrx) {
		this.packedTrx = packedTrx;
	}

	public boolean isTxId() {
		return isTxId;
	}

	public void setTxId(boolean isTxId) {
		this.isTxId = isTxId;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public boolean isNumber() {
		return isNumber;
	}

	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}

}
