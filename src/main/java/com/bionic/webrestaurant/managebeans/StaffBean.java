package com.bionic.webrestaurant.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Staff;
import com.bionic.webrestaurant.service.StaffService;

@Named
@Scope("session")
public class StaffBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3036044396294815804L;

	private List<Staff> listStaff;

	private Staff staff;

	@Inject
	private StaffService staffService;

	public StaffBean() {
		super();
	}

	public List<Staff> getListStaff() {
		return listStaff;
	}

	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public void getAllStaff() {
		listStaff = staffService.findAll();
	}

	public String addNewStaff() {
		staff = new Staff();
		return "addNewStaff";
	}

	public String saveStaff() {
		staffService.save(staff);
		return "staffList";
	}

	public String editStaff(String id) {
		Integer sId = Integer.valueOf(id);
		staff = staffService.findById(sId);
		return "editStaff";
	}

	public String setActiveStatusTrue(String id) {
		Integer sId = Integer.valueOf(id);
		staffService.setActiveStatusTrue(sId);
		return "staffList";
	}

	public String setActiveStatusFalse(String id) {
		Integer sId = Integer.valueOf(id);
		staffService.setActiveStatusFalse(sId);
		return "staffList";
	}

	public String editPassword(String i) {
		Integer id = Integer.valueOf(i);
		staff = staffService.findById(id);
		return "editPassword";
	}
}
