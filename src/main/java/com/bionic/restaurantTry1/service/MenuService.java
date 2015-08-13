package com.bionic.restaurantTry1.service;

import java.util.List;

import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.TypeDish;

public interface MenuService {
	
	public void addNewDish(Menu dish);

	public void changeDish(Menu dish);

	public void setActiveStatusTrue(int id);

	public void setActiveStatusFalse(int id);
	
	public List<Menu> getDishes(TypeDish dish);

}
