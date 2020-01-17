package com.consumer;

import java.util.List;

public class Request {
    private List<Partitions> partitions;

    public List<Partitions> getPartitions() {
        return partitions;
    }

    public void setPartitions(List<Partitions> partitions) {
        this.partitions = partitions;
    }
}
