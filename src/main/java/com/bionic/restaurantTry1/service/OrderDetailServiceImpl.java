package com.bionic.restaurantTry1.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.restaurantTry1.dao.CustomerDao;
import com.bionic.restaurantTry1.dao.OrderDetailDao;
import com.bionic.restaurantTry1.entities.Customer;
import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.OrderDetail;
import com.bionic.restaurantTry1.entities.Orders;

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
	public void addNewOrderDetail(Orders order, Map<Menu,Integer> menu) {
		ordersService.addNewOrder(order);
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

	@Transactional
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


	@Override
	public void setPreparedStatusTrue(int id) {
		orderDetailDao.setPreparedStatusTrue(id);
	}

}
