package com.bionic.restaurantTry1.service;

import com.bionic.restaurantTry1.entities.Staff;

public interface StaffService {
	public Staff findById(int id);
	
	public Staff findByLogin(String login);
}
