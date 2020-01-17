package com.producer.goodsreceipt;


import java.util.List;

public class StockCheckContent {

    private String inventoryDate;
    private String uom;
    private Integer pagesTotal;
    private Integer pagesCurrent;
    private Integer countRecords;
    private String whsCode;
    private List<StockCheckItems> items;

    public void setInventoryDate(String inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public String getInventoryDate() {
        return inventoryDate;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public void setPagesTotal(Integer pagesTotal) {
        this.pagesTotal = pagesTotal;
    }

    public Integer getPagesTotal() {
        return pagesTotal;
    }

    public void setPagesCurrent(Integer pagesCurrent) {
        this.pagesCurrent = pagesCurrent;
    }

    public Integer getPagesCurrent() {
        return pagesCurrent;
    }

    public void setCountRecords(Integer countRecords) {
        this.countRecords = countRecords;
    }

    public Integer getCountRecords() {
        return countRecords;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setItems(List<StockCheckItems> items) {
        this.items = items;
    }

    public List<StockCheckItems> getItems() {
        return items;
    }

}
