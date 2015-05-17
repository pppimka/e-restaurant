package com.bionic.restaurantTry1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.bionic.restaurantTry1.entities.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@PersistenceContext
	public EntityManager em;

	@Override
	public void addNewOrderDetail(OrderDetail od) {
		em.persist(od);
	}

	@Override
	public List<OrderDetail> getUnpreparedDishes() {
		TypedQuery<OrderDetail> query = em
				.createQuery(
						"Select od from OrderDetail od where od.preparedStatus = \"f\" "
								+ " and od.dish.kitchenType = \"t\" order by od.order.orderDateTime",
						OrderDetail.class);
		return query.getResultList();
	}

	@Override
	public void setPreparedStatusTrue(int id) {
		OrderDetail orderDetail = em.find(OrderDetail.class, id);
		orderDetail.setPreparedStatus("t");
	}

}
