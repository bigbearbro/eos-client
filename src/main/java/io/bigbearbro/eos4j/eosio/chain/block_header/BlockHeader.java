package io.bigbearbro.eos4j.eosio.chain.block_header;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.bigbearbro.eos4j.eosio.chain.Extensions;
import io.bigbearbro.eos4j.eosio.chain.producer.ProducerSchedule;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockHeader {

	@JsonProperty("timestamp")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	private Date timestamp;

	@JsonProperty("producer")
	private String producer;

	@JsonProperty("confirmed")
	private Long confirmed;

	@JsonProperty("previous")
	private String previous;

	@JsonProperty("transaction_mroot")
	private String transactionMroot;

	@JsonProperty("action_mroot")
	private String actionMroot;

	@JsonProperty("schedule_version")
	private String scheduleVersion;
	
	@JsonProperty("new_producers")
	private ProducerSchedule newProducers;
	
	@JsonProperty("header_extensions")
	private List<Extensions> headerExtensions;
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getTransactionMroot() {
		return transactionMroot;
	}

	public void setTransactionMroot(String transactionMroot) {
		this.transactionMroot = transactionMroot;
	}

	public String getActionMroot() {
		return actionMroot;
	}

	public void setActionMroot(String actionMroot) {
		this.actionMroot = actionMroot;
	}

	public String getScheduleVersion() {
		return scheduleVersion;
	}

	public void setScheduleVersion(String scheduleVersion) {
		this.scheduleVersion = scheduleVersion;
	}

	public ProducerSchedule getNewProducers() {
		return newProducers;
	}

	public void setNewProducers(ProducerSchedule newProducers) {
		this.newProducers = newProducers;
	}

	public List<Extensions> getHeaderExtensions() {
		return headerExtensions;
	}

	public void setHeaderExtensions(List<Extensions> headerExtensions) {
		this.headerExtensions = headerExtensions;
	}

}
