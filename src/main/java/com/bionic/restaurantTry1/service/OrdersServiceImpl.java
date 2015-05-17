package com.bionic.restaurantTry1.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.restaurantTry1.dao.OrdersDao;
import com.bionic.restaurantTry1.entities.Orders;
import com.bionic.restaurantTry1.entities.Report;

@Named
public class OrdersServiceImpl implements OrdersService {

	@Inject
	private OrdersDao ordersDao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void addNewOrder(Orders order) {
		ordersDao.addNewOrder(order);
	}

	@Override
	public Report getReport(java.sql.Timestamp startPeriod, java.sql.Timestamp endPeriod) {
		Report report = ordersDao.getReport(startPeriod, endPeriod);
		if (report != null) {
			report.setStartPeriod(startPeriod);
			report.setEndPeriod(endPeriod);
		}
		return report;
	}

	@Override
	public Report getReport(java.sql.Timestamp startPeriod, java.sql.Timestamp endPeriod, String category) {
		Report report =  ordersDao.getReport(startPeriod, endPeriod, category);
		if (report != null) {
			report.setStartPeriod(startPeriod);
			report.setEndPeriod(endPeriod);
			report.setCategory(category);
		}
		return report;
	}

	@Override
	public List<Orders> getOrdersForDelivery() {
		return ordersDao.getOrdersForDelivery();
	}
	

}
