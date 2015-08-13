package com.bionic.webrestaurant.service;

import java.util.List;
import java.util.Map;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.entities.Orders;

public interface OrderDetailService {
	
	public List<OrderDetail> getAllOrderDetail(Orders o);
	
	public void save(OrderDetail orderDetail);

	public void addNewOrderDetail(Orders order, Map<Menu, Integer> menu);

	public void addNewOrderDetailsAndCustomer(Orders order, Customer customer,
			Map<Menu, Integer> menu);
	
	public List<OrderDetail> getUnpreparedDished();
	
	public List<OrderDetail> getOrderBeverages(Orders order);
	
	public void setPreparedStatusTrue(OrderDetail orderDetail);
}
