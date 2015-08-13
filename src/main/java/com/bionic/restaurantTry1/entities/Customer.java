package com.bionic.restaurantTry1.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String surname;
	
	private int phoneNumber;
	
	private String address;
	
	private String email;
	
	private String login;
	
	private String password;
	
	@OneToMany(mappedBy="customer",
			cascade=CascadeType.PERSIST)
	private Collection<Orders> ordes;
	
	public Customer() {
		super();
	}

	public Customer(int id, String name, String surname, int phoneNumber,
			String address, String email, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", email=" + email + ", login=" + login + "]";
	}
	
	
}
