package com.poi;

public class FfOrderImportExcelEntity {
	//步骤
	private String step;
	//订单编号
	private String orderId;
	
	private String portalOrderNumber;
	//订单日期
	private String orderDate;
	//顾客增值税号
	private String customerVATNumber;
	//商品编号
	private String itemId;
	//季节
	private String season;
	//性别
	private String gender;
	//类别
	private String category;
	//子类别
	private String subCategory;
	//品牌
	private String brand;
	//品牌编号
	private String designerId;

	private String sku;
	//颜色
	private String colour;
	//商品名
	private String friendlyName;
	//基价
	private String basePrice;
	//价格
	private String price;
	//尺码标准
	private String sizeScale;
	//尺码
	private String size;
	//发货地点
	private String shippingPoint;
	//买手店
	private String boutique;
	//库存地点名称
	private String stockPointName;
	//网站
	private String site;
	//总计
	private String subTotal;
	//物流
	private String shipping;
	//合计
	private String total;
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPortalOrderNumber() {
		return portalOrderNumber;
	}
	public void setPortalOrderNumber(String portalOrderNumber) {
		this.portalOrderNumber = portalOrderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerVATNumber() {
		return customerVATNumber;
	}
	public void setCustomerVATNumber(String customerVATNumber) {
		this.customerVATNumber = customerVATNumber;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSizeScale() {
		return sizeScale;
	}
	public void setSizeScale(String sizeScale) {
		this.sizeScale = sizeScale;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getShippingPoint() {
		return shippingPoint;
	}
	public void setShippingPoint(String shippingPoint) {
		this.shippingPoint = shippingPoint;
	}
	public String getBoutique() {
		return boutique;
	}
	public void setBoutique(String boutique) {
		this.boutique = boutique;
	}
	public String getStockPointName() {
		return stockPointName;
	}
	public void setStockPointName(String stockPointName) {
		this.stockPointName = stockPointName;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "FfOrderImportExcelEntity{" +
				"step='" + step + '\'' +
				", orderId='" + orderId + '\'' +
				", portalOrderNumber='" + portalOrderNumber + '\'' +
				", orderDate='" + orderDate + '\'' +
				", customerVATNumber='" + customerVATNumber + '\'' +
				", itemId='" + itemId + '\'' +
				", season='" + season + '\'' +
				", gender='" + gender + '\'' +
				", category='" + category + '\'' +
				", subCategory='" + subCategory + '\'' +
				", brand='" + brand + '\'' +
				", designerId='" + designerId + '\'' +
				", sku='" + sku + '\'' +
				", colour='" + colour + '\'' +
				", friendlyName='" + friendlyName + '\'' +
				", basePrice='" + basePrice + '\'' +
				", price='" + price + '\'' +
				", sizeScale='" + sizeScale + '\'' +
				", size='" + size + '\'' +
				", shippingPoint='" + shippingPoint + '\'' +
				", boutique='" + boutique + '\'' +
				", stockPointName='" + stockPointName + '\'' +
				", site='" + site + '\'' +
				", subTotal='" + subTotal + '\'' +
				", shipping='" + shipping + '\'' +
				", total='" + total + '\'' +
				'}';
	}
}
