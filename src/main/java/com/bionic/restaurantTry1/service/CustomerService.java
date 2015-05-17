package com.bionic.restaurantTry1.service;

import com.bionic.restaurantTry1.entities.Customer;

public interface CustomerService {
	
	public void addNewCustomer(Customer customer);
	
	public Customer findByLogin(String login);
	
	public Customer findById(int id);
}
