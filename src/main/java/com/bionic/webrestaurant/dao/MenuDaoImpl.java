package com.bionic.webrestaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;

@Repository
public class MenuDaoImpl implements MenuDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Menu dish) {
		if (em.find(Menu.class, dish.getId()) != null) {
			em.merge(dish);
		} else {
			em.persist(dish);
		}
	}

	@Override
	public void setAtciveStatusTrue(int id) {
		Menu dish = em.find(Menu.class, id);
		if (dish != null) {
			dish.setActiveStatus("t");
			em.merge(dish);
		}
	}

	@Override
	public void setActiveStatusFalse(int id) {
		Menu dish = em.find(Menu.class, id);
		if (dish != null) {
			dish.setActiveStatus("f");
			em.merge(dish);
		}
	}

	@Override
	public List<Menu> getDishes(TypeDish dish) {
		TypedQuery<Menu> query = em.createQuery(
				"select dish from Menu dish where dish.typeDish = \""
						+ dish.getTypeDish() + "\"", Menu.class);
		return query.getResultList();
	}

	@Override
	public Menu findById(int id) {
		Menu dish = em.find(Menu.class, id);
		return dish;
	}

	@Override
	public List<Menu> getAvailableDishes(TypeDish dish) {
		TypedQuery<Menu> query = em.createQuery(
				"select dish from Menu dish where dish.typeDish = \""
						+ dish.getTypeDish() + "\" "
						+ "and dish.activeStatus = \"t\"", Menu.class);
		return query.getResultList();
	}

	@Override
	public List<Menu> getAllDishes() {
		TypedQuery<Menu> query = em.createQuery("select dish from Menu dish",
				Menu.class);
		return query.getResultList();
	}

}
