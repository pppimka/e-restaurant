package com.bionic.webrestaurant.managebeans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Staff;
import com.bionic.webrestaurant.entities.TypeStaff;

@Named
@Scope("request")
public class AccessBean {

	@Inject
	private CustomerBean customerBean;

	@Inject
	private StaffAuthorizationBean staff;

	public boolean checkCustomerRights() {
		if (customerBean.getCustomer().getId() != 0) {
			return true;
		}
		return false;
	}	
	

	public boolean checkStaffAnalysRights() {
		if (staff.getStaff().getId() != 0
				&& staff.getStaff().getRole()
						.equals(TypeStaff.ANALYST.getTypeStaff())) {
			System.out.println("analyst true");
			return true;
		}
		System.out.println("analyst false");
		return false;
	}
	
	public boolean checkStaffAdminRights() {
		if (staff.getStaff().getId() != 0
				&& staff.getStaff().getRole()
						.equals(TypeStaff.ADMIN.getTypeStaff())) {
			System.out.println("admin true");
			return true;
		}
		System.out.println("admin false");
		return false;
	}
	
	public boolean checkStaffDeliveryRights() {
		if (staff.getStaff().getId() != 0
				&& staff.getStaff().getRole()
						.equals(TypeStaff.DELIVERY_MAN.getTypeStaff())) {
			System.out.println("delivery true");
			return true;
		}
		System.out.println("delivery false");
		return false;
	}
	
	public boolean checkStaffChefRights() {
		if (staff.getStaff().getId() != 0
				&& staff.getStaff().getRole()
						.equals(TypeStaff.CHEF.getTypeStaff())) {
			System.out.println("chef true");
			return true;
		}
		System.out.println("chef false");
		return false;
	}
	
	public boolean checkStaffSuperUserRights() {
		if (staff.getStaff().getId() != 0
				&& staff.getStaff().getRole()
						.equals(TypeStaff.SUPER_USER.getTypeStaff())) {
			System.out.println("super true");
			return true;
		}
		System.out.println("super false");
		return false;
	}
	
	public String customerLogOut() {
		customerBean.setCustomer(new Customer());
		return "authorizationCustomer.xhtml?faces-redirect=true";
	}
	
	public void staffLogOut() {
		staff.setStaff(new Staff());
		
	}
}
