package com.example.coapservice;

import com.example.core.RawData;
import com.example.core.RawDataInterceptor;

public class IncomingRawDataInterceptor implements RawDataInterceptor {
    @Override
    public RawData doInterceptor(RawData rawData) {
        return rawData;
    }
}
