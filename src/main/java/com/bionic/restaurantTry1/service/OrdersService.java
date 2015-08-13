package com.bionic.restaurantTry1.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Convert;

import com.bionic.restaurantTry1.entities.Orders;
import com.bionic.restaurantTry1.entities.Report;

public interface OrdersService {

	public void addNewOrder(Orders order);
	
	@Convert(disableConversion = true)
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod);
	
	@Convert(disableConversion = true)
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod, String cathegory);

	public List<Orders> getOrdersForDelivery();

}
