package com.example.coapservice;

import com.example.core.Message;
import com.example.core.MessageInterceptor;

public class OutgoingMessageInterceptor implements MessageInterceptor {
    @Override
    public Message messageInterceptor(Message message) {
        return message;
    }
}
