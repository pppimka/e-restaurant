package com.bionic.restaurantTry1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String surname;
	
	private int phoneNumber;
	
	private String address;
	
	private String email;
	
	private String password;
	
	private String login;
	
	private String role;
	
	private String activeStatus;

	
	public Staff() {
		
	}

	
	public Staff(int id, String name, String surname, int phoneNumber,
			String address, String email, String password, String login,
			String role, String activeStatus) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.login = login;
		this.role = role;
		this.activeStatus = activeStatus;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}


	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", surname=" + surname
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", login="
				+ login + ", role=" + role + ", activeStatus=" + activeStatus
				+ "]";
	}

	
}
