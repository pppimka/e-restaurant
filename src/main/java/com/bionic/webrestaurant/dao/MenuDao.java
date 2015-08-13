package com.bionic.webrestaurant.dao;

import java.util.List;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;

public interface MenuDao {
	
	public void save(Menu dish);

	public void setAtciveStatusTrue(int id);

	public void setActiveStatusFalse(int id);

	public Menu findById(int id);

	public List<Menu> getAllDishes();
	
	public List<Menu> getDishes(TypeDish dish);
	
	public List<Menu> getAvailableDishes(TypeDish dish);

}
