package com.bionic.webrestaurant.service;

import java.util.List;

import com.bionic.webrestaurant.entities.Staff;

public interface StaffService {
	
	public Staff findById(int id);
	
	public Staff findByLogin(String login);
	
	public List<Staff> findAll();
	
	public void save(Staff staff);
	
	public void setActiveStatusTrue(int id);

	public void setActiveStatusFalse(int id);
	
	public boolean changePassword(int id, String oldPassword, String newPassword);
}
