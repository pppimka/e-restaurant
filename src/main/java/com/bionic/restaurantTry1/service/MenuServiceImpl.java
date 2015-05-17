package com.bionic.restaurantTry1.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.restaurantTry1.dao.MenuDao;
import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.TypeDish;

@Named
public class MenuServiceImpl implements MenuService{

	@Inject
	private MenuDao menuDao;
	
	@Transactional
	@Override
	public void addNewDish(Menu dish) {
		menuDao.addNewDish(dish);
	}

	@Transactional
	@Override
	public void changeDish(Menu dish) {
		menuDao.changeDish(dish);
		
	}

	@Override
	public void setActiveStatusTrue(int id) {
		menuDao.setAtciveStatusTrue(id);
	}

	@Override
	public void setActiveStatusFalse(int id) {
		menuDao.setActiveStatusFalse(id);
	}

	@Override
	public List<Menu> getDishes(TypeDish dish) {
		return menuDao.getDishes(dish);
	}

	


}
