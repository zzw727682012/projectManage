package com.producer.orderevents;

public class ReleaseOrderReleaseLineDTO {
	private String skuCode;
	private String orderLineId;
	private Double quantity;
	private String price;
	private String discount;
	private String salePrice;

	public String getReleaseLineId() {
		return releaseLineId;
	}

	public void setReleaseLineId(String releaseLineId) {
		this.releaseLineId = releaseLineId;
	}

	private String releaseLineId;
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public String getOrderLineId() {
		return orderLineId;
	}
	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

}
