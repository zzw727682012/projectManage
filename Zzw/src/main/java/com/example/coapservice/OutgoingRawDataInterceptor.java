package com.example.coapservice;

import com.example.core.RawData;
import com.example.core.RawDataInterceptor;

public class OutgoingRawDataInterceptor implements RawDataInterceptor {
    @Override
    public RawData doInterceptor(RawData rawData) {
        return rawData;
    }
}
