package com.consumer.releaseorder;

import com.alibaba.fastjson.annotation.JSONField;

public class ReturnOrderAddressDTO {
	@JSONField(name="returnLocation")
	private String returnLocation;
	@JSONField(name="returnLocationAddress1")
	private String returnLocationAddress1;
	@JSONField(name="returnLocationAddress2")
	private String returnLocationAddress2;
	@JSONField(name="returnLocationAddress3")
	private String returnLocationAddress3;
	@JSONField(name="returnLocationCity")
	private String returnLocationCity;
	@JSONField(name="returnLocationCountry")
	private String returnLocationCountry;
	@JSONField(name="returnLocationCounty")
	private String returnLocationCounty;
	@JSONField(name="returnLocationPostalCode")
	private String returnLocationPostalCode;
	@JSONField(name="returnLocationEmail")
	private String returnLocationEmail;

	@Override
	public String toString() {
		return "ReturnOrderAddressDTO{" +
				"returnLocation='" + returnLocation + '\'' +
				", returnLocationAddress1='" + returnLocationAddress1 + '\'' +
				", returnLocationAddress2='" + returnLocationAddress2 + '\'' +
				", returnLocationAddress3='" + returnLocationAddress3 + '\'' +
				", returnLocationCity='" + returnLocationCity + '\'' +
				", returnLocationCountry='" + returnLocationCountry + '\'' +
				", returnLocationCounty='" + returnLocationCounty + '\'' +
				", returnLocationPostalCode='" + returnLocationPostalCode + '\'' +
				", returnLocationEmail='" + returnLocationEmail + '\'' +
				", returnLocationFirstName='" + returnLocationFirstName + '\'' +
				", returnLocationLastName='" + returnLocationLastName + '\'' +
				", returnLocationPhone='" + returnLocationPhone + '\'' +
				", returnLocationState='" + returnLocationState + '\'' +
				'}';
	}

	@JSONField(name="returnLocationFirstName")
	private String returnLocationFirstName;
	@JSONField(name="returnLocationLastName")
	private String returnLocationLastName;
	@JSONField(name="returnLocationPhone")
	private String returnLocationPhone;
	@JSONField(name="returnLocationState")
	private String returnLocationState;
	public String getReturnLocation() {
		return returnLocation;
	}
	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}
	public String getReturnLocationAddress1() {
		return returnLocationAddress1;
	}
	public void setReturnLocationAddress1(String returnLocationAddress1) {
		this.returnLocationAddress1 = returnLocationAddress1;
	}
	public String getReturnLocationAddress2() {
		return returnLocationAddress2;
	}
	public void setReturnLocationAddress2(String returnLocationAddress2) {
		this.returnLocationAddress2 = returnLocationAddress2;
	}
	public String getReturnLocationAddress3() {
		return returnLocationAddress3;
	}
	public void setReturnLocationAddress3(String returnLocationAddress3) {
		this.returnLocationAddress3 = returnLocationAddress3;
	}
	public String getReturnLocationCity() {
		return returnLocationCity;
	}
	public void setReturnLocationCity(String returnLocationCity) {
		this.returnLocationCity = returnLocationCity;
	}
	public String getReturnLocationCountry() {
		return returnLocationCountry;
	}
	public void setReturnLocationCountry(String returnLocationCountry) {
		this.returnLocationCountry = returnLocationCountry;
	}
	public String getReturnLocationCounty() {
		return returnLocationCounty;
	}
	public void setReturnLocationCounty(String returnLocationCounty) {
		this.returnLocationCounty = returnLocationCounty;
	}
	public String getReturnLocationPostalCode() {
		return returnLocationPostalCode;
	}
	public void setReturnLocationPostalCode(String returnLocationPostalCode) {
		this.returnLocationPostalCode = returnLocationPostalCode;
	}
	public String getReturnLocationEmail() {
		return returnLocationEmail;
	}
	public void setReturnLocationEmail(String returnLocationEmail) {
		this.returnLocationEmail = returnLocationEmail;
	}
	public String getReturnLocationFirstName() {
		return returnLocationFirstName;
	}
	public void setReturnLocationFirstName(String returnLocationFirstName) {
		this.returnLocationFirstName = returnLocationFirstName;
	}
	public String getReturnLocationLastName() {
		return returnLocationLastName;
	}
	public void setReturnLocationLastName(String returnLocationLastName) {
		this.returnLocationLastName = returnLocationLastName;
	}
	public String getReturnLocationPhone() {
		return returnLocationPhone;
	}
	public void setReturnLocationPhone(String returnLocationPhone) {
		this.returnLocationPhone = returnLocationPhone;
	}
	public String getReturnLocationState() {
		return returnLocationState;
	}
	public void setReturnLocationState(String returnLocationState) {
		this.returnLocationState = returnLocationState;
	}

}
