package com.bionic.restaurantTry1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.restaurantTry1.entities.Staff;

@Repository
public class StaffDaoImpl implements StaffDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Staff findById(int id) {
		Staff s = null;
		s = em.find(Staff.class, id);
		return s;
	}

	@Override
	public List<Staff> findByLogin(String login) {
		TypedQuery<Staff> query = em.createQuery(
				"select s form Staff s where s.login = " + "\"" + login + "\"",
				Staff.class);
		return query.getResultList();
	}

	@Override
	public void save(Staff staff) {
		if (em.contains(staff)) {
			em.merge(staff);
		} else {
			em.persist(staff);
		}
	}

	@Override
	public void setAtciveStatusTrue(int id) {
		Staff staff = em.find(Staff.class, id);
		if (staff != null) {
			staff.setActiveStatus("t");
		}
	}

	@Override
	public void setActiveStatusFalse(int id) {
		Staff staff = em.find(Staff.class, id);
		if (staff != null) {
			staff.setActiveStatus("f");
		}
	}
}
