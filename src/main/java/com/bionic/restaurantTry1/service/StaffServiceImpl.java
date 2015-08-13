package com.bionic.restaurantTry1.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bionic.restaurantTry1.dao.StaffDao;
import com.bionic.restaurantTry1.entities.Staff;

@Named
public class StaffServiceImpl implements StaffService{

	@Inject
	private StaffDao staffDao;
	
	@Override
	public Staff findById(int id) {
		return staffDao.findById(id);
	}

	@Override
	public Staff findByLogin(String login) {
		List<Staff> list = staffDao.findByLogin(login);
		if (list != null) {
			return list.get(1);
		}
		return null;
	}

}
