package com.consumer;

public class PostOffsetDTO {

	private String topic;
	private Integer partition;
	private Long offset;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
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
