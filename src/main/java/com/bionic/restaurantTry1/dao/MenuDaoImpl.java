package com.bionic.restaurantTry1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.restaurantTry1.entities.Menu;
import com.bionic.restaurantTry1.entities.TypeDish;

@Repository
public class MenuDaoImpl implements MenuDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addNewDish(Menu dish) {
		em.persist(dish);
	}

	@Override
	public void changeDish(Menu dish) {
		if (em.contains(dish)) {
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
		}
	}

	@Override
	public void setActiveStatusFalse(int id) {
		Menu dish = em.find(Menu.class, id);
		if (dish != null) {
			dish.setActiveStatus("f");
		}
	}

	@Override
	public List<Menu> getDishes(TypeDish dish) {
		TypedQuery<Menu> query = em.createQuery(
				"select dessert from Menu dessert where dessert.typeDish = \""
						+ dish.getTypeDish() + "\" "
						+ "and dessert.activeStatus = \"t\"", Menu.class);
		return query.getResultList();
	}

}
