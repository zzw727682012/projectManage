package com.producer.labelling;

public class ReceiveLabellingBillToAddressDTO {

	private String company;
	private String name;
	private String addressLines;
	private String localityName;
	private String subdivisionName;
	private String postalCode;
	private String phoneNumber;
	private String countryCode;
	private String forwarderAccounts;
	private String vatNumber;
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressLines() {
		return addressLines;
	}
	public void setAddressLines(String addressLines) {
		this.addressLines = addressLines;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public String getSubdivisionName() {
		return subdivisionName;
	}
	public void setSubdivisionName(String subdivisionName) {
		this.subdivisionName = subdivisionName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getForwarderAccounts() {
		return forwarderAccounts;
	}
	public void setForwarderAccounts(String forwarderAccounts) {
		this.forwarderAccounts = forwarderAccounts;
	}
	public String getVatNumber() {
		return vatNumber;
	}
	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	
}
