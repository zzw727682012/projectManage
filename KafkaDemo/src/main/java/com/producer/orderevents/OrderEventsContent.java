package com.producer.orderevents;

import java.util.Date;
import java.util.List;

public class OrderEventsContent {
    private long batchNumber;
    private String isShort;
    private String orderStatusId;
    private String statusUpdate;
    private long releaseLineId;
    private long releaseId;
    private String uom;
    private String docNumber;
    private int toBucket;
    private String docType;
    private long pickingListNo;
    private long goodsIssueDate;
    private String whsCode;
    private String customerOrderNumber;
    private String carrierCode;
    private Date eventDate;
    private String loadNumber;
    private String billOfLading;
    private List<OrderEventsCartons> cartons;

    public void setBatchNumber(long batchNumber) {
        this.batchNumber = batchNumber;
    }

    public long getBatchNumber() {
        return batchNumber;
    }

    public void setIsShort(String isShort) {
        this.isShort = isShort;
    }

    public String getIsShort() {
        return isShort;
    }

    public void setOrderStatusId(String orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusId() {
        return orderStatusId;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setReleaseLineId(long releaseLineId) {
        this.releaseLineId = releaseLineId;
    }

    public long getReleaseLineId() {
        return releaseLineId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setToBucket(int toBucket) {
        this.toBucket = toBucket;
    }

    public int getToBucket() {
        return toBucket;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocType() {
        return docType;
    }

    public void setPickingListNo(long pickingListNo) {
        this.pickingListNo = pickingListNo;
    }

    public long getPickingListNo() {
        return pickingListNo;
    }

    public void setGoodsIssueDate(long goodsIssueDate) {
        this.goodsIssueDate = goodsIssueDate;
    }

    public long getGoodsIssueDate() {
        return goodsIssueDate;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setCustomerOrderNumber(String customerOrderNumber) {
        this.customerOrderNumber = customerOrderNumber;
    }

    public String getCustomerOrderNumber() {
        return customerOrderNumber;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setLoadNumber(String loadNumber) {
        this.loadNumber = loadNumber;
    }

    public String getLoadNumber() {
        return loadNumber;
    }

    public void setBillOfLading(String billOfLading) {
        this.billOfLading = billOfLading;
    }

    public String getBillOfLading() {
        return billOfLading;
    }

    public void setCartons(List<OrderEventsCartons> cartons) {
        this.cartons = cartons;
    }

    public List<OrderEventsCartons> getCartons() {
        return cartons;
    }

}