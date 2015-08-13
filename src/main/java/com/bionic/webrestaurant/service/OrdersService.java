package com.bionic.webrestaurant.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Convert;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;
import com.bionic.webrestaurant.entities.Report;

public interface OrdersService {
	
	public boolean isAllKithenDone(Orders order);

	public List<Orders> getCustomerOrders(Customer customer);
	
	public void addNewOrder(HashMap<Menu, Integer> orderMap, Customer customer, Double sum);
	
	public void save(Orders order);
	
	@Convert(disableConversion = true)
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod);
	
	@Convert(disableConversion = true)
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod, String cathegory);

	public List<Orders> getOrders(OrdersStatus os);
	
	public List<Orders> getAllReadyOrders();

}
