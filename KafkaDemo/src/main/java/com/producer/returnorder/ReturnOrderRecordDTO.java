package com.producer.returnorder;

import com.producer.orderevents.ReleaseOrderValueDTO;

public class ReturnOrderRecordDTO {
    private ReturnOrderValueDTO value;

    public ReturnOrderValueDTO getValue() {
        return value;
    }

    public void setValue(ReturnOrderValueDTO value) {
        this.value = value;
    }
}
