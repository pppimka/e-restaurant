package com.bionic.webrestaurant.managebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.service.CustomerService;
import com.bionic.webrestaurant.service.OrdersService;

@Named
@Scope("session")
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5722260630124569834L;

	private String login;

	private String password;

	private Customer customer;
	
	private List<Orders> orderList;

	@Inject
	private OrdersService ordersService;

	@Inject
	private CustomerService customerService;

	public CustomerBean() {
		customer = new Customer();
		orderList = new ArrayList<Orders>();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}

	public void getOrders() {
		if (customer.getId() != 0) {
			orderList = ordersService.getCustomerOrders(customer);
		}
	}
	
	public String authorize(String email, String password) {
		Customer c = customerService.findByEmail(email);
		if (c != null) {
			this.customer = c;
			if (customer.getPassword().equals(password)) {
				orderList = ordersService.getCustomerOrders(customer);
				return "homePage.xhtml?faces-redirect=true"; 
			}
		}
		return "authorizationCustomer.xhtml?faces-redirect=true";
	}

	public String editInformation() {
		return "editInformation.xhtml?faces-redirect=true";
	}

	public String save() {
		customerService.save(customer);
		return "homePage.xhtml?faces-redirect=true";
	}

	public String register() {
		return "registration.xhtml?faces-redirect=true";
	}

}
