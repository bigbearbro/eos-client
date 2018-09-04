package io.bigbearbro.eos4j.eosio.chain.producer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author wangyan
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProducerSchedule {
	
	@JsonProperty("version")
	private Integer version;
	
	@JsonProperty("producers")
	private List<ProducerKey> producers;
	
	public ProducerSchedule() {
	}
	
	public ProducerSchedule(String arg) {
	}
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public List<ProducerKey> getProducers() {
		return producers;
	}
	public void setProducers(List<ProducerKey> producers) {
		this.producers = producers;
	}
	
}
