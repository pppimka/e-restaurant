package com.bionic.webrestaurant.managebeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.service.StaffService;

@Named
@Scope("request")
public class EditPasswordBean {

	private String oldPassword;

	private String newPassword;

	@Inject
	private StaffService staffService;

	public EditPasswordBean() {
		super();
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String changeStaffPassword(String id) {
		Integer n = Integer.valueOf(id);
		if (!staffService.changePassword(n, oldPassword, newPassword)) {
			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("Wrong password!"));
			return "editPassword";
		}
		return "staffList";
	}
}
