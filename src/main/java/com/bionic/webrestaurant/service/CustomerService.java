package com.bionic.webrestaurant.service;

import com.bionic.webrestaurant.entities.Customer;

public interface CustomerService {
	
	public void addNewCustomer(Customer customer);
	
	public void save(Customer customer);
	
	public Customer findByEmail(String email);
	
	public Customer findById(int id);
	
	public boolean changePassword(int id, String oldPassword, String newPassword);
}
