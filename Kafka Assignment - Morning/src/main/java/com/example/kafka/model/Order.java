package com.example.kafka.model;

public class Order {
	
	int orderId;
	
	String orderType;
	
	String orderQuantity;
	
	String orderCreationDate;


	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderType=" + orderType + ", orderQuantity=" + orderQuantity + "]";
	}
		
}
