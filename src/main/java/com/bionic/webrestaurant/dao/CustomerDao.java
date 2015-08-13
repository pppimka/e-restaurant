package com.bionic.webrestaurant.dao;

import com.bionic.webrestaurant.entities.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);
	
	public Customer findByEmail(String email);
	
	public Customer findById(int id);
}
