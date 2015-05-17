package com.bionic.restaurantTry1.dao;

import java.util.List;

import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.TypeDish;

public interface MenuDao {
	public void addNewDish(Menu dish);
	
	public void changeDish(Menu dish);
	
	public void setAtciveStatusTrue(int id);
	
	public void setActiveStatusFalse(int id);
	
	public List<Menu> getDishes(TypeDish dish);

}
