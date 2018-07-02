package com.assetmanagementsystem.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="purchase_history_table")
public class PurchaseEntity {

	@Id
	@GeneratedValue
	@Column(name="order_id", length=7)
	private int orderId;
	
	@Column(name="order_status", length=7)
	private String orderStatus;

	@OneToMany(mappedBy="purchaseDetails")
	private List<PurchaseProductEntity> productList=new ArrayList<>();

	@Temporal(TemporalType.DATE)
	private Date orderPlacedDate;
	
	@Temporal(TemporalType.DATE)
	private Date orderReceiveDate;
	
	public Date getOrderPlacedDate() {
		return orderPlacedDate;
	}

	public void setOrderPlacedDate(Date orderPlacedDate) {
		this.orderPlacedDate = orderPlacedDate;
	}

	public Date getOrderReceiveDate() {
		return orderReceiveDate;
	}

	public void setOrderReceiveDate(Date orderReceiveDate) {
		this.orderReceiveDate = orderReceiveDate;
	}

	public List<PurchaseProductEntity> getProductList() {
		return productList;
	}

	public void setProductList(List<PurchaseProductEntity> productList) {
		this.productList = productList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}