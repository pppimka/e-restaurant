package com.bionic.webrestaurant.entities;

public enum OrdersStatus {
	PREPARING("preparing"), KITCHEN_DONE("kitchen done"), NON_KITCHEN_DONE(
			"non-kitchen done"), READY_FOR_SHIPMENT("ready for shipment"), DELIVERING(
			"delivering"), DELIVERED("delivered");

	private String orderStatus;

	OrdersStatus(String orderStatus) {
		this.setOrderStatus(orderStatus);
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	private void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
