package com.producer.goodsreceipt;


import java.util.Objects;

public class StockCheckItems {

    private String skuCode;
    private Integer firstCountQty;
    private Integer expectedQty;
    private Integer inventoryQty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StockCheckItems)) return false;
        StockCheckItems items = (StockCheckItems) o;
        return getSkuCode().equals(items.getSkuCode());

    }

    @Override
    public int hashCode() {
        return getSkuCode().hashCode();
    }

    private String whsBucket;
    private Integer lockedQty;
    private String lockCode;
    private String madeIn;

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setFirstCountQty(Integer firstCountQty) {
        this.firstCountQty = firstCountQty;
    }

    public Integer getFirstCountQty() {
        return firstCountQty;
    }

    public void setExpectedQty(Integer expectedQty) {
        this.expectedQty = expectedQty;
    }

    public Integer getExpectedQty() {
        return expectedQty;
    }

    public void setInventoryQty(Integer inventoryQty) {
        this.inventoryQty = inventoryQty;
    }

    public Integer getInventoryQty() {
        return inventoryQty;
    }

    public void setWhsBucket(String whsBucket) {
        this.whsBucket = whsBucket;
    }

    public String getWhsBucket() {
        return whsBucket;
    }

    public void setLockedQty(Integer lockedQty) {
        this.lockedQty = lockedQty;
    }

    public Integer getLockedQty() {
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
