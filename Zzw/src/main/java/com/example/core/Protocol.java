package com.example.core;

public interface Protocol {

    public MessageHandlerFactory getMessageHandlerFactory(Message message);
    public RawDataInterceptor getRawDataInterceptor();
}
