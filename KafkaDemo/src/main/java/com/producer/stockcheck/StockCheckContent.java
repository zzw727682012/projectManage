package com.producer.stockcheck;


import lombok.Getter;

import java.util.List;

@Getter
public class StockCheckContent {

    private String inventoryDate;
    private String uom;
    private int pagesTotal;
    private int pagesCurrent;
    private int countRecords;
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

    public void setPagesTotal(int pagesTotal) {
        this.pagesTotal = pagesTotal;
    }

    public int getPagesTotal() {
        return pagesTotal;
    }

    public void setPagesCurrent(int pagesCurrent) {
        this.pagesCurrent = pagesCurrent;
    }

    public int getPagesCurrent() {
        return pagesCurrent;
    }

    public void setCountRecords(int countRecords) {
        this.countRecords = countRecords;
    }

    public int getCountRecords() {
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
