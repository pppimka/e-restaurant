package com.bionic.restaurantTry1.service;

import java.util.List;

import com.bionic.restaurantTry1.entities.Orders;
import com.bionic.restaurantTry1.entities.Report;


public interface OrdersService {
	
	public void addNewOrder(Orders order);

	public Report getReport(java.sql.Timestamp startPeriod, java.sql.Timestamp endPeriod);
	
	public Report getReport(java.sql.Timestamp startPeriod, java.sql.Timestamp endPeriod, String cathegory);
	
	public List<Orders> getOrdersForDelivery();

}
