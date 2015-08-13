package com.bionic.webrestaurant.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.webrestaurant.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Customer customer) {
		if (em.find(Customer.class, customer.getId()) != null) {
			em.merge(customer);
		} else {
			em.persist(customer);
		}
	}

	@Override
	public Customer findByEmail(String email) {
		TypedQuery<Customer> query = em.createQuery(
				"select cus from Customer cus where cus.email = " + "\""
						+ email + "\"", Customer.class);
		try {
			return query.getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Customer findById(int id) {
		return em.find(Customer.class, id);
	}

}
