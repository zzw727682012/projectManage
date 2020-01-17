package com.producer.internalmovement;

public class InternalMovementItems {

    private long skuCode;
    private int availableQty;
    private String quantityAdjustmentType;
    private String reasonCode;
    private String madeIn;
    private String notes;
    private String stealthOrder;
    public void setSkuCode(long skuCode) {
        this.skuCode = skuCode;
    }
    public long getSkuCode() {
        return skuCode;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }
    public int getAvailableQty() {
        return availableQty;
    }

    public void setQuantityAdjustmentType(String quantityAdjustmentType) {
        this.quantityAdjustmentType = quantityAdjustmentType;
    }
    public String getQuantityAdjustmentType() {
        return quantityAdjustmentType;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
    public String getReasonCode() {
        return reasonCode;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
    public String getMadeIn() {
        return madeIn;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }

    public void setStealthOrder(String stealthOrder) {
        this.stealthOrder = stealthOrder;
    }
    public String getStealthOrder() {
        return stealthOrder;
    }

}