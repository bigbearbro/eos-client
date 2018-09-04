package io.bigbearbro.eos4j.eosio.chain.transaction;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.client.pack.Pack;
import io.bigbearbro.eos4j.client.pack.PackType;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionHeader {
	@Pack(PackType.uint32)
	@JsonProperty("expiration")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date expiration;
	
	@Pack(PackType.uint16)
	@JsonProperty("ref_block_num")
	private Long refBlockNum;
	
	@Pack(PackType.uint32)
	@JsonProperty("ref_block_prefix")
	private Long refBlockPrefix;

	@Pack(PackType.varint32)
	@JsonProperty("max_net_usage_words")
	private Long maxNetUsageWords;

	@Pack(PackType.uint8)
	@JsonProperty("max_cpu_usage_ms")
	private Long maxCpuUsageMs;

	@Pack(PackType.varint32)
	@JsonProperty("delay_sec")
	private Long delaySec;

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Long getRefBlockNum() {
		return refBlockNum;
	}

	public void setRefBlockNum(Long refBlockNum) {
		this.refBlockNum = refBlockNum;
	}

	public Long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	public void setRefBlockPrefix(Long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

	public Long getMaxNetUsageWords() {
		return maxNetUsageWords;
	}

	public void setNetUsageWords(Long maxNetUsageWords) {
		this.maxNetUsageWords = maxNetUsageWords;
	}

	public Long getMaxCpuUsageMs() {
		return maxCpuUsageMs;
	}

	public void setMaxCpuUsageMs(Long maxCpuUsageMs) {
		this.maxCpuUsageMs = maxCpuUsageMs;
	}

	public Long getDelaySec() {
		return delaySec;
	}

	public void setDelaySec(Long delaySec) {
		this.delaySec = delaySec;
	}
	
}
