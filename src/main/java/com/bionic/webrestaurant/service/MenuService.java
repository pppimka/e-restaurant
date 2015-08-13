package com.bionic.webrestaurant.service;

import java.util.List;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;

public interface MenuService {
	
	public void saveDish(Menu dish);

	public void setActiveStatusTrue(int id);

	public void setActiveStatusFalse(int id);
	
	public Menu findById(int id);
	
	public List<Menu> getDishes(TypeDish dish);
	
	public List<Menu> getAllDishes();

}
