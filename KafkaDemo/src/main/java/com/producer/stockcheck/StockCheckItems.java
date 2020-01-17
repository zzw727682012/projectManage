package com.producer.stockcheck;

public class StockCheckItems {

    private String skuCode;
    private int firstCountQty;
    private int expectedQty;
    private int inventoryQty;
    private String whsBucket;
    private int lockedQty;
    private String lockCode;
    private String madeIn;

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setFirstCountQty(int firstCountQty) {
        this.firstCountQty = firstCountQty;
    }

    public int getFirstCountQty() {
        return firstCountQty;
    }

    public void setExpectedQty(int expectedQty) {
        this.expectedQty = expectedQty;
    }

    public int getExpectedQty() {
        return expectedQty;
    }

    public void setInventoryQty(int inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public int getInventoryQty() {
        return inventoryQty;
    }

    public void setWhsBucket(String whsBucket) {
        this.whsBucket = whsBucket;
    }

    public String getWhsBucket() {
        return whsBucket;
    }

    public void setLockedQty(int lockedQty) {
        this.lockedQty = lockedQty;
    }

    public int getLockedQty() {
        return lockedQty;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode;
    }

    public String getLockCode() {
        return lockCode;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getMadeIn() {
        return madeIn;
    }
}
