package com.bionic.restaurantTry1.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.restaurantTry1.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Customer customer) {
		if (em.contains(customer)) {
			em.merge(customer);
		} else {
			em.persist(customer);
		}
	}

	@Override
	public Customer findByLogin(String login) {
		TypedQuery<Customer> query = em.createQuery(
				"select cus form Customer cus where cus.login = " + "\""
						+ login + "\"", Customer.class);
		return query.getSingleResult();
	}

	@Override
	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}

}
