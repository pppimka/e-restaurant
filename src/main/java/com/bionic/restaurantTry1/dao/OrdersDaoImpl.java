package com.bionic.restaurantTry1.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.restaurantTry1.entities.Orders;
import com.bionic.restaurantTry1.entities.Report;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public void addNewOrder(Orders order) {
		em.persist(order);
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod) {
		String txt = "SELECT new com.bionic.restaurantTry1.entities.Report "
				+ "(COUNT(o), SUM(o.totalPrice), FUNC('DATE',o.orderDateTime)) FROM Orders o"
				+ " where o.orderDateTime between ?1 and ?2"
				+ " GROUP BY FUNC('DATE',o.orderDateTime) "
				+ "ORDER BY FUNC('DATE',o.orderDateTime)";

		TypedQuery<Report> query = em.createQuery(txt, Report.class);

		query.setParameter(1, startPeriod);
		query.setParameter(2, endPeriod);
		return query.getResultList();
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod, String category) {
		String txt = "SELECT new com.bionic.restaurantTry1.entities.Report "
				+ "(SUM(o.count), SUM(o.price * o.count), FUNC('DATE',o.order.orderDateTime), "
				+ "\"" + category + "\") "
				+ " FROM OrderDetail o where o.order.orderDateTime between ?1 and ?2"
				+ " and o.dish.typeDish = \"" + category + "\""
				+ " GROUP BY FUNC('DATE',o.order.orderDateTime) "
				+ " ORDER BY FUNC('DATE',o.order.orderDateTime)";
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		query.setParameter(1, startPeriod);
		query.setParameter(2, endPeriod);
		return query.getResultList();
	}

	@Override
	public List<Orders> getOrdersForDelivery() {
		String txt = "Select o from Orders o where o.status = "
				+ "\"ready for shipment\" or o.status = \"kitchen done\""
				+ " or o.status = \"delivering\"";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Override
	public void setStatusKitchenDone(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("kitchen done");
		order.setStatusTime(LocalDateTime.now());

	}

	@Override
	public void setStatusNonKitchenDone(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("non-kitchen done");
		order.setStatusTime(LocalDateTime.now());

	}

	@Override
	public void setStatusReadyForShipment(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("ready for shipment");
		order.setStatusTime(LocalDateTime.now());

	}

	@Override
	public void setStatusDelivering(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("delivering");
		order.setStatusTime(LocalDateTime.now());

	}

	@Override
	public void setStatusDelivered(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("delivered");
		order.setStatusTime(LocalDateTime.now());

	}

	@Override
	public List<Orders> getKitchenDoneOrders() {
		String txt = "Select o from Orders o where "
				+ "o.status = \"kitchen done\"";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> getReadyForShipmentOrders() {
		String txt = "Select o from Orders o where o.status = "
				+ "\"ready for shipment\" ";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> getDeliveringOrders() {
		String txt = "Select o from Orders o where "
				+ " o.status = \"delivering\"";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> getDeliveredOrders() {
		String txt = "Select o from Orders o where "
				+ " o.status = \"delivered\"";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

}
