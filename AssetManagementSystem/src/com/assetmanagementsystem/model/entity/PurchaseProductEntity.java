package com.assetmanagementsystem.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase_product_table")
public class PurchaseProductEntity {
	
	@Id
	@GeneratedValue
	@Column(name="product_id", length=7)
	private int productId;
	
	@Column(name="product_name", length=25)
	private String productName;
	
	@Column(name="quantity", length=5)
	private int quantity;
	
	@ManyToOne
	private PurchaseEntity purchaseDetails;
	
	public PurchaseEntity getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(PurchaseEntity purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	@Column(name="vendor_name", length=20)
	private String vendorName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
}
