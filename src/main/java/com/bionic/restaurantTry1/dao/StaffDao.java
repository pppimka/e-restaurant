package com.bionic.restaurantTry1.dao;

import java.util.List;

import com.bionic.restaurantTry1.entities.Staff;

public interface StaffDao {
	
	public Staff findById(int id);
	
	public List<Staff> findByLogin(String login);

	public void save(Staff staff);

	public void setAtciveStatusTrue(int id);

	public void setActiveStatusFalse(int id);

}
