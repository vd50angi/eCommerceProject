package com.cogent.ecommerce.model;

public class Supplier {
	
	private String supplierId;
	private String supplierName;
	private String productId;
	private String productName;
	private String orderId;
	private String invId;
	private Double grandTotalPrice;
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getInvId() {
		return invId;
	}
	public void setInvId(String invId) {
		this.invId = invId;
	}
	public Double getGrandTotalPrice() {
		return grandTotalPrice;
	}
	public void setGrandTotalPrice(Double grandTotalPrice) {
		this.grandTotalPrice = grandTotalPrice;
	}
	

}
