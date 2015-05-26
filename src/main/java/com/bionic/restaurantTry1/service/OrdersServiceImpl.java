package com.bionic.restaurantTry1.service;

import java.time.LocalDateTime;
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
	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod) {
		List<Report> report = ordersDao.getReport(startPeriod, endPeriod);
//		if (report != null) {
//			for (Report r: report) {
//				r.setStartPeriod(startPeriod);
//				r.setEndPeriod(endPeriod);
//			}
//			
//		}
		return report;
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod, LocalDateTime endPeriod, String category) {
		List<Report> report =  ordersDao.getReport(startPeriod, endPeriod, category);
//		if (report != null) {
//			report.setStartPeriod(startPeriod);
//			report.setEndPeriod(endPeriod);
//			report.setCategory(category);
//		}
		return report;
	}

	@Override
	public List<Orders> getOrdersForDelivery() {
		return ordersDao.getOrdersForDelivery();
	}
	

}
