package com.bionic.webrestaurant.managebeans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.service.CustomerService;

@Named
@Scope("session")
public class RegistrationBean {

	private Customer customer;

	@Inject
	private CustomerService customerService;

	public RegistrationBean() {
		super();
		customer = new Customer();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String register() {		
		System.out.println("Reigsrtation bean register");
		customerService.addNewCustomer(customer);
		return "authorizationCustomer.xhtml?faces-redirect=true";
	}
}
