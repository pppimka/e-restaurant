package com.bionic.webrestaurant.dao;

import java.util.List;

import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.entities.Orders;

public interface OrderDetailDao {
	
	public List<OrderDetail> getAllOrderDetail(Orders o);
	
	public List<OrderDetail> getOrderBeverages(Orders order);
	
	public void save(OrderDetail od);
	
	public void addNewOrderDetail(OrderDetail od);
	
	public List<OrderDetail> getUnpreparedDishes();
	
	public void setPreparedStatusTrue(int id);
}
