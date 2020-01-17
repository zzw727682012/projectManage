package com.consumer.releaseorder;

public class ReleaseOrderValueDTO {
	private String timestamp;
	private String messageId;
	private String sender;
	private String senderCountry;
	private String senderLocation;
	private String correlationId;
	private String schema;
	private String schemaVersion;
	private String brandCode;
	private String brand;
	private ReleaseOrderContentDTO content;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSenderCountry() {
		return senderCountry;
	}
	public void setSenderCountry(String senderCountry) {
		this.senderCountry = senderCountry;
	}
	public String getSenderLocation() {
		return senderLocation;
	}
	public void setSenderLocation(String senderLocation) {
		this.senderLocation = senderLocation;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public ReleaseOrderContentDTO getContent() {
		return content;
	}
	public void setContent(ReleaseOrderContentDTO content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReleaseOrderValueDTO{" +
				"timestamp='" + timestamp + '\'' +
				", messageId='" + messageId + '\'' +
				", sender='" + sender + '\'' +
				", senderCountry='" + senderCountry + '\'' +
				", senderLocation='" + senderLocation + '\'' +
				", correlationId='" + correlationId + '\'' +
				", schema='" + schema + '\'' +
				", schemaVersion='" + schemaVersion + '\'' +
				", brandCode='" + brandCode + '\'' +
				", brand='" + brand + '\'' +
				", content=" + content +
				'}';
	}
}
