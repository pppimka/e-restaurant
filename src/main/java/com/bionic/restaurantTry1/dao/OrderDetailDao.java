package com.bionic.restaurantTry1.dao;

import java.util.List;

import com.bionic.restaurantTry1.entities.OrderDetail;

public interface OrderDetailDao {
	
	public void addNewOrderDetail(OrderDetail od);
	
	public List<OrderDetail> getUnpreparedDishes();
	
	public void setPreparedStatusTrue(int id);
}
