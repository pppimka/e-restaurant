package com.bionic.webrestaurant.entities;

public enum TypeDish {
	
	BEVERAGE("beverage"), SOUP("soup"),
	MAIN_COURSE("mainCourse"), SALAD("salad"),
	DESSERT("dessert");

	private String typeDish;
	
	TypeDish(String typeDish) {
		this.setTypeDish(typeDish);
	}

	public String getTypeDish() {
		return typeDish;
	}

	private void setTypeDish(String typeDish) {
		this.typeDish = typeDish;
	}
	
}
