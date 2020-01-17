package com.producer;

import com.producer.stockcheck.Offsets;

import java.util.List;

public class PostOffsets {
    private List<Offsets> offsets;

    public List<Offsets> getOffsets() {
        return offsets;
    }

    public void setOffsets(List<Offsets> offsets) {
        this.offsets = offsets;
    }
}
