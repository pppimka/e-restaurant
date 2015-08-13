package com.bionic.restaurantTry1.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.bionic.restaurantTry1.entities.Orders;
import com.bionic.restaurantTry1.entities.Report;

public interface OrdersDao {
	
	public void addNewOrder(Orders order);

	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod);

	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod, String category);
	
	public List<Orders> getOrdersForDelivery();
	
	public void setStatusKitchenDone(Orders o);
	
	public void setStatusNonKitchenDone(Orders o);
	
	public void setStatusReadyForShipment(Orders o);
	
	public void setStatusDelivering(Orders o);
	
	public void setStatusDelivered(Orders o);
	
	public List<Orders> getKitchenDoneOrders();
	
	public List<Orders> getReadyForShipmentOrders();
	
	public List<Orders> getDeliveringOrders();
	
	public List<Orders> getDeliveredOrders();
	

}
