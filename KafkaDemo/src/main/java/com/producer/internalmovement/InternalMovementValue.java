package com.producer.internalmovement;
import com.producer.Value;

import java.util.Date;

public class InternalMovementValue implements Value {

    private Date timestamp;
    private String messageId;
    private String sender;
    private String senderCountry;
    private String senderLocation;
    private String correlationId;
    private String schema;
    private String schemaVersion;
    private String brandCode;
    private String brand;
    private String intendedReceiver;
    private InternalMovementContent content;
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public Date getTimestamp() {
        return timestamp;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
    public String getMessageId() {
        return messageId;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getSender() {
        return sender;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }
    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderLocation(String senderLocation) {
        this.senderLocation = senderLocation;
    }
    public String getSenderLocation() {
        return senderLocation;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
    public String getCorrelationId() {
        return correlationId;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
    public String getSchema() {
        return schema;
    }

    public void setSchemaVersion(String schemaVersion) {
        this.schemaVersion = schemaVersion;
    }
    public String getSchemaVersion() {
        return schemaVersion;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    public String getBrandCode() {
        return brandCode;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }

    public void setIntendedReceiver(String intendedReceiver) {
        this.intendedReceiver = intendedReceiver;
    }
    public String getIntendedReceiver() {
        return intendedReceiver;
    }

    public void setContent(InternalMovementContent content) {
        this.content = content;
    }
    public InternalMovementContent getContent() {
        return content;
    }

}