package com.producer.goodsreceipt;

import java.util.List;

public class ProducerRecord {
    private List records;
    public void setRecords(List records) {
        this.records = records;
    }
    public List getRecords() {
        return records;
    }
}
