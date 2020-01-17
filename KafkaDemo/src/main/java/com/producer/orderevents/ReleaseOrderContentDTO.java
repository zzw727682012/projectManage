package com.producer.orderevents;

import java.util.List;

public class ReleaseOrderContentDTO {
	private String orderType;
	private String whsCode;
	private String purchaseOrder;
	private String capturedDate;
	private String carrierCode;
	private String deliveryNo;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	private String currencyCode;

	public boolean isCanceled() {
		return IsCanceled;
	}

	public void setCanceled(boolean canceled) {
		IsCanceled = canceled;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	private String orderId;
	private String orderSubTotal;
	private String totalDiscounts;
	private boolean IsCanceled;
	private String salesMomeType;
	private String releaseId;
	private ReleaseOrderAddressDTO address;
	private List<ReleaseOrderReleaseLineDTO> releaseLine;
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
	public boolean getIsCanceled() {
		return IsCanceled;
	}
	public void setIsCanceled(boolean isCanceled) {
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

}
