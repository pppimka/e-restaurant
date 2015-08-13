package com.bionic.restaurantTry1.dao;

import com.bionic.restaurantTry1.entities.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);
	
	public Customer findByLogin(String login);
	
	public Customer findById(int id);
}
