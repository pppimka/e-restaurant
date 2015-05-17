package com.bionic.restaurantTry1.service;

import java.util.List;
import java.util.Map;

import com.bionic.restaurantTry1.entities.Customer;
import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.OrderDetail;
import com.bionic.restaurantTry1.entities.Orders;

public interface OrderDetailService {

	public void addNewOrderDetail(Orders order, Map<Menu, Integer> menu);

	public void addNewOrderDetailsAndCustomer(Orders order, Customer customer,
			Map<Menu, Integer> menu);
	
	public List<OrderDetail> getUnpreparedDished();
	
	public void setPreparedStatusTrue(int id);
}
