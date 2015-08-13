package com.bionic.webrestaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.webrestaurant.entities.Staff;

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
	public Staff findByLogin(String login) {

		TypedQuery<Staff> query = em.createQuery(
				"select s from Staff s where s.login = " + "\"" + login + "\""
						+ "and s.activeStatus = \"t\"", Staff.class);
		try {
			return query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void save(Staff staff) {
		if (em.find(Staff.class, staff.getId()) != null) {
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
			em.merge(staff);
		}
	}

	@Override
	public void setActiveStatusFalse(int id) {
		Staff staff = em.find(Staff.class, id);
		if (staff != null) {
			staff.setActiveStatus("f");
			em.merge(staff);
		}
	}

	@Override
	public List<Staff> findAll() {
		TypedQuery<Staff> query = em.createQuery("select s from Staff s ",
				Staff.class);

		return query.getResultList();
	}
}
