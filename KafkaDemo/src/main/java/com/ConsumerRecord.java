package com;

import com.producer.goodsreceipt.StockCheckItems;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class ConsumerRecord implements Serializable {
	private String topic;
	private String key;
	private String value;
	private Set<StockCheckItems> partition;
	private Long offset;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ConsumerRecord{" +
				"topic='" + topic + '\'' +
				", key='" + key + '\'' +
				", value='" + value + '\'' +
				", partition=" + partition +
				", offset=" + offset +
				'}';
	}

	public Set<StockCheckItems> getPartition() {
		return partition;
	}

	public void setPartition(Set<StockCheckItems> partition) {
		this.partition = partition;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}
}
