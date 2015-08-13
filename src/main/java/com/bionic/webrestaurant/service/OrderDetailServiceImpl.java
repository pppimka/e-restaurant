package com.bionic.webrestaurant.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.dao.CustomerDao;
import com.bionic.webrestaurant.dao.OrderDetailDao;
import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;

@Named
public class OrderDetailServiceImpl implements OrderDetailService {

	@Inject
	private OrderDetailDao orderDetailDao;

	@Inject
	private OrdersService ordersService;

	@Inject
	private CustomerDao customerDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addNewOrderDetail(Orders order, Map<Menu, Integer> menu) {
		ordersService.save(order);
		for (Menu dish : menu.keySet()) {
			OrderDetail od = new OrderDetail();
			od.setCount(menu.get(dish));
			od.setDish(dish);
			od.setOrder(order);
			od.setPrice(dish.getPrice());
			od.setPreparedStatus("f");
			orderDetailDao.addNewOrderDetail(od);
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addNewOrderDetailsAndCustomer(Orders order, Customer customer,
			Map<Menu, Integer> menu) {
		customerDao.save(customer);
		order.setCustomer(customer);
		addNewOrderDetail(order, menu);
	}

	@Override
	public List<OrderDetail> getUnpreparedDished() {
		return orderDetailDao.getUnpreparedDishes();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void setPreparedStatusTrue(OrderDetail orderDetail) {
		orderDetailDao.setPreparedStatusTrue(orderDetail.getId());

		if (ordersService.isAllKithenDone(orderDetail.getOrder())) {
			orderDetail.getOrder().setStatusTime(LocalDateTime.now());
			if (orderDetailDao.getOrderBeverages(orderDetail.getOrder()) == null) {
				orderDetail.getOrder().setStatus(
						OrdersStatus.NON_KITCHEN_DONE.getOrderStatus());
				ordersService.save(orderDetail.getOrder());
			} else {
				orderDetail.getOrder().setStatus(
						OrdersStatus.KITCHEN_DONE.getOrderStatus());
				ordersService.save(orderDetail.getOrder());
			}
		}
	}

	@Transactional
	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);

	}

	@Override
	public List<OrderDetail> getAllOrderDetail(Orders o) {
		return orderDetailDao.getAllOrderDetail(o);
	}

	@Override
	public List<OrderDetail> getOrderBeverages(Orders order) {
		return orderDetailDao.getOrderBeverages(order);
	}

}
