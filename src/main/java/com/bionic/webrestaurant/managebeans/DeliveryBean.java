package com.bionic.webrestaurant.managebeans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;
import com.bionic.webrestaurant.service.OrdersService;

@Named
@Scope("session")
public class DeliveryBean {

	private DateTimeFormatter formatter;

	private List<Orders> listOrders;
	@Inject
	private OrdersService ordersService;

	private String orderStatus;

	public DeliveryBean() {
		super();
		formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		listOrders = new ArrayList<Orders>();
	}

	public List<Orders> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Orders> orders) {
		this.listOrders = orders;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void getAllReadyOrders() {
		listOrders = ordersService.getAllReadyOrders();

	}

	public void getOrdersByStatus() {
		OrdersStatus os = null;
		if (orderStatus.equals(OrdersStatus.KITCHEN_DONE.getOrderStatus())) {
			os = OrdersStatus.KITCHEN_DONE;
		} else if (orderStatus.equals(OrdersStatus.READY_FOR_SHIPMENT
				.getOrderStatus())) {
			os = OrdersStatus.READY_FOR_SHIPMENT;
		} else if (orderStatus.equals(OrdersStatus.DELIVERING.getOrderStatus())) {
			os = OrdersStatus.DELIVERING;
		} else if (orderStatus.equals(OrdersStatus.DELIVERED.getOrderStatus())) {
			os = OrdersStatus.DELIVERED;
		}
		listOrders = ordersService.getOrders(os);
	}

	public void setStatusNonKitchenDone(Orders orders) {
		orders.setStatus(OrdersStatus.READY_FOR_SHIPMENT.getOrderStatus());
		orders.setStatusTime(LocalDateTime.now());
		ordersService.save(orders);
		getAllReadyOrders();
	}

	public void setStatusDelivering(Orders orders) {
		orders.setStatus(OrdersStatus.DELIVERING.getOrderStatus());
		orders.setStatusTime(LocalDateTime.now());
		ordersService.save(orders);
		getAllReadyOrders();
	}

	public void setStatusDelivered(Orders orders) {
		orders.setStatus(OrdersStatus.DELIVERED.getOrderStatus());
		orders.setStatusTime(LocalDateTime.now());
		ordersService.save(orders);
		getAllReadyOrders();
	}
}
