package com.bionic.webrestaurant.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.dao.MenuDao;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;

@Named
public class MenuServiceImpl implements MenuService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805387574072370197L;
	@Inject
	private MenuDao menuDao;
	
	@Transactional
	@Override
	public void saveDish(Menu dish) {
		menuDao.save(dish);
	}
	
	@Transactional
	@Override
	public void setActiveStatusTrue(int id) {
		menuDao.setAtciveStatusTrue(id);
	}

	@Transactional
	@Override
	public void setActiveStatusFalse(int id) {
		menuDao.setActiveStatusFalse(id);
	}

	@Override
	public List<Menu> getDishes(TypeDish dish) {
		return menuDao.getDishes(dish);
	}

	@Override
	public Menu findById(int id) {
		return menuDao.findById(id);
	}

	@Override
	public List<Menu> getAllDishes() {
		return menuDao.getAllDishes();
	}

	


}
