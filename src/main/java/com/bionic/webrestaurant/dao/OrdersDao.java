package com.bionic.webrestaurant.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;
import com.bionic.webrestaurant.entities.Report;

public interface OrdersDao {
	
	public void save(Orders order);

	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod);

	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod, String category);
	
	public List<Orders> getOrders(OrdersStatus ordersStatus);
	
	public List<Orders> getAllReadyOrders();
	
	public List<Orders> getCustomerOrders(Customer customer);
	
	public void setStatus(Orders o, OrdersStatus os);

}
