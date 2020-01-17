package com.producer.labelling;

public class ReceiveLabellingContentDTO {

	private String orderId;
	private String releaseId;
	private String whsCode;
	private ReceiveLabellingSenderAddressDTO senderAddress;
	private ReceiveLabellingShipperAddressDTO shipperAddress;
	private ReceiveLabellingDeliveryAddressDTO deliveryAddress;
	private ReceiveLabellingBillToAddressDTO billToAddress;
	private ReceiveLabellingUltimateConsigneeAddressDTO ultimateConsigneeAddress;
	private ReceiveLabellingRecipientAddressDTO recipientAddress;
	private ReceiveLabellingShipmentLevelItemsDTO shipmentLevelItems;
	private ReceiveLabellingPackageDetailsDTO packageDetails;
	private ReceiveLabellingContentsInformationDTO contentsInformation;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}
	public String getWhsCode() {
		return whsCode;
	}
	public void setWhsCode(String whsCode) {
		this.whsCode = whsCode;
	}
	public ReceiveLabellingSenderAddressDTO getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(ReceiveLabellingSenderAddressDTO senderAddress) {
		this.senderAddress = senderAddress;
	}
	public ReceiveLabellingShipperAddressDTO getShipperAddress() {
		return shipperAddress;
	}
	public void setShipperAddress(ReceiveLabellingShipperAddressDTO shipperAddress) {
		this.shipperAddress = shipperAddress;
	}
	public ReceiveLabellingDeliveryAddressDTO getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(
			ReceiveLabellingDeliveryAddressDTO deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public ReceiveLabellingBillToAddressDTO getBillToAddress() {
		return billToAddress;
	}
	public void setBillToAddress(ReceiveLabellingBillToAddressDTO billToAddress) {
		this.billToAddress = billToAddress;
	}
	public ReceiveLabellingUltimateConsigneeAddressDTO getUltimateConsigneeAddress() {
		return ultimateConsigneeAddress;
	}
	public void setUltimateConsigneeAddress(
			ReceiveLabellingUltimateConsigneeAddressDTO ultimateConsigneeAddress) {
		this.ultimateConsigneeAddress = ultimateConsigneeAddress;
	}
	public ReceiveLabellingRecipientAddressDTO getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(
			ReceiveLabellingRecipientAddressDTO recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public ReceiveLabellingShipmentLevelItemsDTO getShipmentLevelItems() {
		return shipmentLevelItems;
	}
	public void setShipmentLevelItems(
			ReceiveLabellingShipmentLevelItemsDTO shipmentLevelItems) {
		this.shipmentLevelItems = shipmentLevelItems;
	}
	public ReceiveLabellingPackageDetailsDTO getPackageDetails() {
		return packageDetails;
	}
	public void setPackageDetails(ReceiveLabellingPackageDetailsDTO packageDetails) {
		this.packageDetails = packageDetails;
	}
	public ReceiveLabellingContentsInformationDTO getContentsInformation() {
		return contentsInformation;
	}
	public void setContentsInformation(
			ReceiveLabellingContentsInformationDTO contentsInformation) {
		this.contentsInformation = contentsInformation;
	}
}
