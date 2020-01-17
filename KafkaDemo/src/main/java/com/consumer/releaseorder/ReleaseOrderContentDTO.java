package com.consumer.releaseorder;

import java.util.List;

public class ReleaseOrderContentDTO {
	private String orderType;
	private String whsCode;
	private String purchaseOrder;
	private String capturedDate;
	private String carrierCode;
	private String deliveryNo;
	private String orderId;
	private String releaseId;
	private String orderSubTotal;
	private String totalDiscounts;
	private Boolean IsCanceled;
	private String salesMomeType;
	private ReleaseOrderAddressDTO address;
	private List<ReleaseOrderReleaseLineDTO> releaseLine;
	private List<ReleaseOrderNoteDTO> note;
	public ReleaseOrderAddressDTO getAddress() {
		return address;
	}
	public void setAddress(ReleaseOrderAddressDTO address) {
		this.address = address;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getWhsCode() {
		return whsCode;
	}
	public void setWhsCode(String whsCode) {
		this.whsCode = whsCode;
	}
	public String getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public String getCapturedDate() {
		return capturedDate;
	}
	public void setCapturedDate(String capturedDate) {
		this.capturedDate = capturedDate;
	}
	public String getCarrierCode() {
		return carrierCode;
	}
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderSubTotal() {
		return orderSubTotal;
	}
	public void setOrderSubTotal(String orderSubTotal) {
		this.orderSubTotal = orderSubTotal;
	}
	public String getTotalDiscounts() {
		return totalDiscounts;
	}
	public void setTotalDiscounts(String totalDiscounts) {
		this.totalDiscounts = totalDiscounts;
	}
	public Boolean getIsCanceled() {
		return IsCanceled;
	}
	public void setIsCanceled(Boolean isCanceled) {
		IsCanceled = isCanceled;
	}
	public String getSalesMomeType() {
		return salesMomeType;
	}
	public void setSalesMomeType(String salesMomeType) {
		this.salesMomeType = salesMomeType;
	}
	public List<ReleaseOrderReleaseLineDTO> getReleaseLine() {
		return releaseLine;
	}
	public void setReleaseLine(List<ReleaseOrderReleaseLineDTO> releaseLine) {
		this.releaseLine = releaseLine;
	}
	public String getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}
	public List<ReleaseOrderNoteDTO> getNote() {
		return note;
	}
	public void setNote(List<ReleaseOrderNoteDTO> note) {
		this.note = note;
	}

}
