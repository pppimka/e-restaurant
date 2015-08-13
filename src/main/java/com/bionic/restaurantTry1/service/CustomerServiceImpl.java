package com.bionic.restaurantTry1.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.restaurantTry1.dao.CustomerDao;
import com.bionic.restaurantTry1.entities.Customer;

@Named
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerDao customerDao;

	@Override
	public Customer findByLogin(String login) {
		return customerDao.findByLogin(login);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void addNewCustomer(Customer customer) {
		customerDao.save(customer);		
	}

	@Override
	public Customer findById(int id) {
		return customerDao.findById(id);
	}
}
