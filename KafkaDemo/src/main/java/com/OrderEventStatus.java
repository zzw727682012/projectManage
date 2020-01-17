package com;

public enum  OrderEventStatus {
	PACK("pack"),SHIPPED("shipped"),CANCEL("cancel");
	private String ediType;
	private OrderEventStatus(String ediType){
		this.ediType = ediType;
	}

	public String getEdiType() {
		return ediType;
	}
}
