package com.producer.labelling;

import com.producer.orderevents.ReleaseOrderValueDTO;

public class ReceiveLabellingRecordDTO {
    private ReceiveLabellingValueDTO value;

    public ReceiveLabellingValueDTO getValue() {
        return value;
    }

    public void setValue(ReceiveLabellingValueDTO value) {
        this.value = value;
    }
}
