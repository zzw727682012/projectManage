package com.producer.labelling;

public class ReceiveLabellingPackageDetailsDTO {
	private String grossWeight;
	private String grossWeightUnitOfMeasure;
	private String packageType;
	private String length;
	private String width;
	private String height;
	private String dimensionsUnitOfMeasure;
	private String content;
	public String getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	public String getGrossWeightUnitOfMeasure() {
		return grossWeightUnitOfMeasure;
	}
	public void setGrossWeightUnitOfMeasure(String grossWeightUnitOfMeasure) {
		this.grossWeightUnitOfMeasure = grossWeightUnitOfMeasure;
	}
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDimensionsUnitOfMeasure() {
		return dimensionsUnitOfMeasure;
	}
	public void setDimensionsUnitOfMeasure(String dimensionsUnitOfMeasure) {
		this.dimensionsUnitOfMeasure = dimensionsUnitOfMeasure;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
