package com.producer.returnorder;

import java.util.List;

public class ReturnOrderContentDTO {
	private String docNumber;
	private String whsCode;
	private String RMAtype;
	private String RMAdecitions;
	private String isReceiptExpected;
	private String trackingNo;
	private String returnTrackingNo;
	private ReturnOrderAddressDTO address;
	private List<ReturnOrderItemsDTO> items;
	public String getDocNumber() {
		return docNumber;
	}
	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}
	public String getWhsCode() {
		return whsCode;
	}
	public void setWhsCode(String whsCode) {
		this.whsCode = whsCode;
	}
	public String getRMAtype() {
		return RMAtype;
	}
	public void setRMAtype(String atype) {
		RMAtype = atype;
	}
	public String getRMAdecitions() {
		return RMAdecitions;
	}
	public void setRMAdecitions(String adecitions) {
		RMAdecitions = adecitions;
	}
	public String getIsReceiptExpected() {
		return isReceiptExpected;
	}
	public void setIsReceiptExpected(String isReceiptExpected) {
		this.isReceiptExpected = isReceiptExpected;
	}
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	public String getReturnTrackingNo() {
		return returnTrackingNo;
	}
	public void setReturnTrackingNo(String returnTrackingNo) {
		this.returnTrackingNo = returnTrackingNo;
	}
	public ReturnOrderAddressDTO getAddress() {
		return address;
	}
	public void setAddress(ReturnOrderAddressDTO address) {
		this.address = address;
	}
	public List<ReturnOrderItemsDTO> getItems() {
		return items;
	}
	public void setItems(List<ReturnOrderItemsDTO> items) {
		this.items = items;
	}
}
