package com.consumer.releaseorder;

public class ReturnOrderItemsDTO {
	private String skuCode;
	private Double quantity;
	private String uom;
	private Boolean isReturn;
	private String returnOrderId;
	private String returnOrderLineId;
	private String shipToLocationId;
	private String itemConditionId;
	private String returnReason;
	private Boolean isItemVariance;
	private String parentOrderId;
	private String parentOrderLineId;
	private String releaseLineId;
	private String releaseId;
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public Boolean getIsReturn() {
		return isReturn;
	}
	public void setIsReturn(Boolean isReturn) {
		this.isReturn = isReturn;
	}
	public String getReturnOrderId() {
		return returnOrderId;
	}
	public void setReturnOrderId(String returnOrderId) {
		this.returnOrderId = returnOrderId;
	}
	public String getReturnOrderLineId() {
		return returnOrderLineId;
	}
	public void setReturnOrderLineId(String returnOrderLineId) {
		this.returnOrderLineId = returnOrderLineId;
	}
	public String getShipToLocationId() {
		return shipToLocationId;
	}
	public void setShipToLocationId(String shipToLocationId) {
		this.shipToLocationId = shipToLocationId;
	}
	public String getItemConditionId() {
		return itemConditionId;
	}
	public void setItemConditionId(String itemConditionId) {
		this.itemConditionId = itemConditionId;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public Boolean getIsItemVariance() {
		return isItemVariance;
	}
	public void setIsItemVariance(Boolean isItemVariance) {
		this.isItemVariance = isItemVariance;
	}
	public String getParentOrderId() {
		return parentOrderId;
	}
	public void setParentOrderId(String parentOrderId) {
		this.parentOrderId = parentOrderId;
	}
	public String getParentOrderLineId() {
		return parentOrderLineId;
	}
	public void setParentOrderLineId(String parentOrderLineId) {
		this.parentOrderLineId = parentOrderLineId;
	}
	public String getReleaseLineId() {
		return releaseLineId;
	}
	public void setReleaseLineId(String releaseLineId) {
		this.releaseLineId = releaseLineId;
	}
	public String getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

}
