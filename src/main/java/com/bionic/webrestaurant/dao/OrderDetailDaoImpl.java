package com.bionic.webrestaurant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.entities.Orders;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@PersistenceContext
	public EntityManager em;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
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

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void setPreparedStatusTrue(int id) {
		OrderDetail orderDetail = em.find(OrderDetail.class, id);
		orderDetail.setPreparedStatus("t");
		save(orderDetail);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void save(OrderDetail od) {
		em.merge(od);
	}

	@Override
	public List<OrderDetail> getAllOrderDetail(Orders o) {
		TypedQuery<OrderDetail> query = em
				.createQuery(
						"Select od from OrderDetail od where od.order.id ="
								+ o.getId(), OrderDetail.class);
		return query.getResultList();
	}

	@Override
	public List<OrderDetail> getOrderBeverages(Orders order) {
		TypedQuery<OrderDetail> query = em.createQuery(
				"Select od from OrderDetail od where od.order.id ="
						+ order.getId() + " and od.dish.kitchenType = \"f\"",
				OrderDetail.class);
		return query.getResultList();
	}

}
