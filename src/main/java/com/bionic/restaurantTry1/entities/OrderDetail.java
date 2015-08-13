package com.bionic.restaurantTry1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idOrder")
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name="idDish")
	private Menu dish;
	
	private int count;
	
	private String preparedStatus;
	
	private double price;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, Orders order, Menu dish, int count,
			String preparedStatus, double price) {
		super();
		this.id = id;
		this.order = order;
		this.dish = dish;
		this.count = count;
		this.preparedStatus = preparedStatus;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Menu getDish() {
		return dish;
	}

	public void setDish(Menu dish) {
		this.dish = dish;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPreparedStatus() {
		return preparedStatus;
	}

	public void setPreparedStatus(String preparedStatus) {
		this.preparedStatus = preparedStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", idOrder=" + order.getStatus() + ", idDish="
				+ dish.getNameDish() + ", count=" + count + ", preparedStatus="
				+ preparedStatus + ", price=" + price + "]";
	}
	
	
}
