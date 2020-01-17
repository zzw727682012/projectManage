package com.producer.orderevents;

import java.util.List;

public class OrderEventsItems {

    private long skuCode;
    private int requestedQty;
    private int quantity;
    private String orderLineNb;
    private String huExternalId1;
    private String huExternalId2;
    private String packagingMats;
    private String lineStatus;
    private int toLocation;
    private int batchCode;
    private String madeIn;
    private long parcelId;
    private String palletId;
    private List<Pieces> pieces;
    public void setSkuCode(long skuCode) {
        this.skuCode = skuCode;
    }
    public long getSkuCode() {
        return skuCode;
    }

    public void setRequestedQty(int requestedQty) {
        this.requestedQty = requestedQty;
    }
    public int getRequestedQty() {
        return requestedQty;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setOrderLineNb(String orderLineNb) {
        this.orderLineNb = orderLineNb;
    }
    public String getOrderLineNb() {
        return orderLineNb;
    }

    public void setHuExternalId1(String huExternalId1) {
        this.huExternalId1 = huExternalId1;
    }
    public String getHuExternalId1() {
        return huExternalId1;
    }

    public void setHuExternalId2(String huExternalId2) {
        this.huExternalId2 = huExternalId2;
    }
    public String getHuExternalId2() {
        return huExternalId2;
    }

    public void setPackagingMats(String packagingMats) {
        this.packagingMats = packagingMats;
    }
    public String getPackagingMats() {
        return packagingMats;
    }

    public void setLineStatus(String lineStatus) {
        this.lineStatus = lineStatus;
    }
    public String getLineStatus() {
        return lineStatus;
    }

    public void setToLocation(int toLocation) {
        this.toLocation = toLocation;
    }
    public int getToLocation() {
        return toLocation;
    }

    public void setBatchCode(int batchCode) {
        this.batchCode = batchCode;
    }
    public int getBatchCode() {
        return batchCode;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }
    public String getMadeIn() {
        return madeIn;
    }

    public void setParcelId(long parcelId) {
        this.parcelId = parcelId;
    }
    public long getParcelId() {
        return parcelId;
    }

    public void setPalletId(String palletId) {
        this.palletId = palletId;
    }
    public String getPalletId() {
        return palletId;
    }

    public void setPieces(List<Pieces> pieces) {
        this.pieces = pieces;
    }
    public List<Pieces> getPieces() {
        return pieces;
    }

}