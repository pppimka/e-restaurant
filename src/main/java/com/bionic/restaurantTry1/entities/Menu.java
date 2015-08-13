package com.bionic.restaurantTry1.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nameDish;
	private String typeDish;
	private String kitchenType;
	private double price;
	private String activeStatus;
	private String description;
	@OneToMany(mappedBy="dish",
			cascade=CascadeType.PERSIST)
	private Collection<OrderDetail> orderDetail;

	public Menu() {

	}

	public Menu(int id, String nameDish, String typeDish, String kitchenType,
			double price, String activeStatus, String description) {
		super();
		this.id = id;
		this.nameDish = nameDish;
		this.typeDish = typeDish;
		this.kitchenType = kitchenType;
		this.price = price;
		this.activeStatus = activeStatus;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameDish() {
		return nameDish;
	}

	public void setNameDish(String nameDish) {
		this.nameDish = nameDish;
	}

	public String getTypeDish() {
		return typeDish;
	}

	public void setTypeDish(String typeDish) {
		this.typeDish = typeDish;
	}

	public String getKitchenType() {
		return kitchenType;
	}

	public void setKitchenType(String kitchenType) {
		this.kitchenType = kitchenType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", nameDish=" + nameDish + ", typeDish="
				+ typeDish + ", kitchenType=" + kitchenType + ", price="
				+ price + ", activeStatus=" + activeStatus + ", description="
				+ description + "]";
	}
	
	

}
