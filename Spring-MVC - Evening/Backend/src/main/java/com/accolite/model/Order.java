package com.accolite.model;

public class Order {

	private Integer orderId;
	private Item[] item;
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Item[] getItem() {
		return item;
	}
	
	public void setItem(Item[] item) {
		this.item = item;
	}
	
}
