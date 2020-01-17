package com.producer.stockcheck;

public class Offsets {
    private String topic;
    private Integer partition;
    private boolean offset;
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
    public boolean getOffset() {
        return offset;
    }
    public void setOffset(boolean offset) {
        this.offset = offset;
    }
}
