package com.bionic.webrestaurant.entities;

public enum TypeStaff {
	
	ADMIN("adm"), CHEF("chef"),
	DELIVERY_MAN("deliver"), ANALYST("analyst"),
	SUPER_USER("superUser");

	private String typeStaff;
	
	TypeStaff(String typeStaff) {
		this.setTypeStaff(typeStaff);
	}

	public String getTypeStaff() {
		return typeStaff;
	}

	private void setTypeStaff(String typeStaff) {
		this.typeStaff = typeStaff;
	}
	
}
