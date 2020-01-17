package com.producer.goodsreceipt;




public class FullSyncStockCheckQueryItem  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brandCode;
	private String whsCode;
	private String skuCode;
	private Integer lockedQty;
	private Integer inventoryQty;
	private String whsBucket;
	private String brand;

	
	public String getBrandCode() {
		return brandCode;
	}
	
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getWhsCode() {
		return whsCode;
	}

	public void setWhsCode(String whsCode) {
		this.whsCode = whsCode;
	}
	
	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
	public Integer getInventoryQty() {
		return inventoryQty;
	}
	
	public void setInventoryQty(Integer inventoryQty) {
		this.inventoryQty = inventoryQty;
	}
	
	public Integer getLockedQty() {
		return lockedQty;
	}
	
	public void setLockedQty(Integer lockedQty) {
		this.lockedQty = lockedQty;
	}
	
	public String getWhsBucket() {
		return whsBucket;
	}
	
	public void setWhsBucket(String whsBucket) {
		this.whsBucket = whsBucket;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
