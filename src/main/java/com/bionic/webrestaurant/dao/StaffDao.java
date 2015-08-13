package com.bionic.webrestaurant.dao;

import java.util.List;

import com.bionic.webrestaurant.entities.Staff;

public interface StaffDao {
	
	public Staff findById(int id);
	
	public Staff findByLogin(String login);
	
	public List<Staff> findAll();

	public void save(Staff staff);

	public void setAtciveStatusTrue(int id);

	public void setActiveStatusFalse(int id);

}
