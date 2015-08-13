package com.bionic.webrestaurant.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Menu implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

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
	
	@Lob
	private byte[] picture;

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

	
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", nameDish=" + nameDish + ", typeDish="
				+ typeDish + ", kitchenType=" + kitchenType + ", price="
				+ price + ", activeStatus=" + activeStatus + ", description="
				+ description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activeStatus == null) ? 0 : activeStatus.hashCode());
		
		result = prime * result + id;
		result = prime * result
				+ ((kitchenType == null) ? 0 : kitchenType.hashCode());
		result = prime * result
				+ ((nameDish == null) ? 0 : nameDish.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((typeDish == null) ? 0 : typeDish.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (activeStatus == null) {
			if (other.activeStatus != null)
				return false;
		} else if (!activeStatus.equals(other.activeStatus))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (kitchenType == null) {
			if (other.kitchenType != null)
				return false;
		} else if (!kitchenType.equals(other.kitchenType))
			return false;
		if (nameDish == null) {
			if (other.nameDish != null)
				return false;
		} else if (!nameDish.equals(other.nameDish)){
			return false;
		}
		if (typeDish == null) {
			if (other.typeDish != null)
				return false;
		} else if (!typeDish.equals(other.typeDish))
			return false;
		return true;
	}
	
	

}
