package com.bionic.restaurantTry1.entities;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	private String status;
	
	private Timestamp orderDateTime;
	
	private double totalPrice;
	
	private Timestamp statusTime;
	
	@OneToMany(mappedBy="order")
	private Collection<OrderDetail> orderDetail;
	
	public Orders() {
		
	}

	public Orders(int id, Customer customer, String status,
			Timestamp orderDateTime, double totalPrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.status = status;
		this.orderDateTime = orderDateTime;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Timestamp statusTime) {
		this.statusTime = statusTime;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", customer=" + customer + ", status="
				+ status + ", orderDateTime=" + orderDateTime + ", totalPrice="
				+ totalPrice + ", statusTime=" + statusTime + "]";
	}

	
		
}
