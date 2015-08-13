package com.bionic.webrestaurant.managebeans;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Staff;
import com.bionic.webrestaurant.entities.TypeStaff;
import com.bionic.webrestaurant.service.StaffService;

@Named
@Scope("session")
public class StaffAuthorizationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6552222719787965946L;

	private String login;

	private String password;

	private Staff staff;

	@Inject
	private StaffService staffService;

	public StaffAuthorizationBean() {
		staff = new Staff();
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String authorize(String login, String password) {
		Staff s = staffService.findByLogin(login);
		if (s != null) {
			if (s.getRole().equals(TypeStaff.ADMIN.getTypeStaff())) {
				if (s.getPassword().equals(password)) {
					this.staff = s;
					return "adminPages/dishList.xhtml?faces-redirect=true";
				}
			} else if (s.getRole().equals(TypeStaff.CHEF.getTypeStaff())) {
				if (s.getPassword().equals(password)) {
					this.staff = s;
					return "kitchen/listOrders.xhtml?faces-redirect=true";
				}
			} else if (s.getRole().equals(TypeStaff.SUPER_USER.getTypeStaff())) {
				if (s.getPassword().equals(password)) {
					this.staff = s;
					return "superUser/staffList.xhtml?faces-redirect=true";
				}
			} else if (s.getRole().equals(TypeStaff.ANALYST.getTypeStaff())) {
				if (s.getPassword().equals(password)) {
					this.staff = s;
					return "analyst/businessAnalyst.xhtml?faces-redirect=true";
				}
			} else if (s.getRole()
					.equals(TypeStaff.DELIVERY_MAN.getTypeStaff())) {
				if (s.getPassword().equals(password)) {
					this.staff = s;
					return "delivery/deliveryOrderList.xhtml?faces-redirect=true";
				}
			}
		}

		password = null;
		return "authorizationStaff.xhtml?faces-redirect=true";
	}

}
