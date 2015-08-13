package com.bionic.webrestaurant.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.dao.StaffDao;
import com.bionic.webrestaurant.entities.Staff;

@Named
public class StaffServiceImpl implements StaffService {

	@Inject
	private StaffDao staffDao;

	@Override
	public Staff findById(int id) {
		return staffDao.findById(id);
	}

	@Override
	public Staff findByLogin(String login) {
		return staffDao.findByLogin(login);
	}

	@Override
	public List<Staff> findAll() {
		return staffDao.findAll();
	}

	@Transactional
	@Override
	public void save(Staff staff) {
		staffDao.save(staff);
	}

	@Transactional
	@Override
	public void setActiveStatusTrue(int id) {
		staffDao.setAtciveStatusTrue(id);
	}

	@Transactional
	@Override
	public void setActiveStatusFalse(int id) {
		staffDao.setActiveStatusFalse(id);
	}

	@Transactional
	@Override
	public boolean changePassword(int id, String oldPassword, String newPassword) {
		Staff s = staffDao.findById(id);
		// if (s.getPassword().hashCode() == oldPassword.hashCode()) {
		s.setPassword(String.valueOf(newPassword.hashCode()));
		save(s);
		return true;
		// }
		// return false;
	}

}
