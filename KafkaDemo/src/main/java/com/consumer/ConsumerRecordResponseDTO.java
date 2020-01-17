package com.consumer;

public class ConsumerRecordResponseDTO {
	private String topic;
	private String key;
	private String value;
	private Integer partition;
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
		return "ConsumerRecordResponseDTO{" +
				"topic='" + topic + '\'' +
				", key='" + key + '\'' +
				", value='" + value + '\'' +
				", partition=" + partition +
				", offset=" + offset +
				'}';
	}

	public Integer getPartition() {
		return partition;
	}
	public void setPartition(Integer partition) {
		this.partition = partition;
	}
	public Long getOffset() {
		return offset;
	}
	public void setOffset(Long offset) {
		this.offset = offset;
	}
}
