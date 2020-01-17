package com.producer.internalmovement;

import java.util.List;

public class InternalMovementDocuments {

    private String ictDocNumber;
    private String invoiceDocNumber;
    private int fromBucket;
    private String fromCode;
    private int toBucket;
    private String toCode;
    private List<InternalMovementItems> items;
    public void setIctDocNumber(String ictDocNumber) {
        this.ictDocNumber = ictDocNumber;
    }
    public String getIctDocNumber() {
        return ictDocNumber;
    }

    public void setInvoiceDocNumber(String invoiceDocNumber) {
        this.invoiceDocNumber = invoiceDocNumber;
    }
    public String getInvoiceDocNumber() {
        return invoiceDocNumber;
    }

    public void setFromBucket(int fromBucket) {
        this.fromBucket = fromBucket;
    }
    public int getFromBucket() {
        return fromBucket;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }
    public String getFromCode() {
        return fromCode;
    }

    public void setToBucket(int toBucket) {
        this.toBucket = toBucket;
    }
    public int getToBucket() {
        return toBucket;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }
    public String getToCode() {
        return toCode;
    }

    public void setItems(List<InternalMovementItems> items) {
        this.items = items;
    }
    public List<InternalMovementItems> getItems() {
        return items;
    }

}