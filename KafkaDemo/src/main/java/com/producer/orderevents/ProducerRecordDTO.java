package com.producer.orderevents;

import java.util.List;

public class ProducerRecordDTO<T> {
    private List<T> records;
    public void setRecords(List<T> records) {
        this.records = records;
    }
    public List<T> getRecords() {
        return records;
    }
}
