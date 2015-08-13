package com.bionic.webrestaurant.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.dao.CustomerDao;
import com.bionic.webrestaurant.entities.Customer;

@Named
public class CustomerServiceImpl implements CustomerService {

	@Inject
	private CustomerDao customerDao;

	@Override
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
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

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);			
	}

	@Override
	public boolean changePassword(int id, String oldPassword, String newPassword) {
		Customer c = customerDao.findById(id);
//		if (c.getPassword().hashCode() == oldPassword.hashCode()) {
			c.setPassword(String.valueOf(newPassword.hashCode()));
			save(c);
			return true;
//		}
//		return false;
	}
}
