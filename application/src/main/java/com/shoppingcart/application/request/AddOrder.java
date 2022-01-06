package com.shoppingcart.application.request;

import java.time.LocalDateTime;

import com.shoppingcart.application.model.ShoppingCartModel;

public class AddOrder {

	private LocalDateTime orderDate;
	private String paymentStatus;
	private String remark;
	private String customerId;
	
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
}
