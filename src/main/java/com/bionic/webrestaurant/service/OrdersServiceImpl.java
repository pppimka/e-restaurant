package com.bionic.webrestaurant.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.dao.OrdersDao;
import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;
import com.bionic.webrestaurant.entities.Report;

@Named
public class OrdersServiceImpl implements OrdersService {

	@Inject
	private OrdersDao ordersDao;
	
	@Inject
	private OrderDetailService orderDetailService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void save(Orders order) {
		ordersDao.save(order);
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod) {
		List<Report> report = ordersDao.getReport(startPeriod, endPeriod);
		if (report != null) {
			for (Report r : report) {
				r.setStartPeriod(startPeriod);
				r.setEndPeriod(endPeriod);
			}

		}
		return report;
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod, String category) {
		List<Report> report = ordersDao.getReport(startPeriod, endPeriod,
				category);
		if (report != null) {
			for (Report r : report) {
				r.setStartPeriod(startPeriod);
				r.setEndPeriod(endPeriod);
				r.setCategory(category);
			}
		}
		return report;
	}

	@Override
	public List<Orders> getOrders(OrdersStatus os) {
		return ordersDao.getOrders(os);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addNewOrder(HashMap<Menu, Integer> orderMap, Customer customer,
			Double sum) {
		Orders order = new Orders();
		order.setCustomer(customer);
		order.setTotalPrice(sum);
		order.setOrderDateTime(LocalDateTime.now());
		order.setStatus(OrdersStatus.PREPARING.getOrderStatus());
		order.setStatusTime(LocalDateTime.now());
		if (customer.getId() != 0) {
			orderDetailService.addNewOrderDetail(order, orderMap);
		} else {
			orderDetailService.addNewOrderDetailsAndCustomer(order, customer, orderMap);
		}
	}

	@Override
	public List<Orders> getCustomerOrders(Customer customer) {
		return ordersDao.getCustomerOrders(customer);
	}

	@Override
	public boolean isAllKithenDone(Orders order) {
		List<OrderDetail> list = orderDetailService.getAllOrderDetail(order);
		for (OrderDetail od: list) {
			if (od.getDish().getKitchenType().equals("t") && od.getPreparedStatus().equals("t")){
				continue;
			} else if (od.getDish().getKitchenType().equals("f")) {
				continue;
			}
			return false;
		}
		return true;
	}

	@Override
	public List<Orders> getAllReadyOrders() {
		return ordersDao.getAllReadyOrders();
	}

}
