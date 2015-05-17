package com.bionic.restaurantTry1.dao;

import java.sql.Timestamp;
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
	public Report getReport(java.sql.Timestamp startPeriod,
			java.sql.Timestamp endPeriod) {
		String txt = "SELECT new com.bionic.restaurantTry1.entities.Report "
				+ "(COUNT(o), SUM(o.totalPrice) ) " + "FROM Orders o"
				+ " where o.orderDateTime between" + " \'" + startPeriod + "\'"
				+ " and \'" + endPeriod + "\'";
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		return query.getSingleResult();
	}

	@Override
	public Report getReport(java.sql.Timestamp startPeriod, java.sql.Timestamp endPeriod, String category) {
		String txt = "SELECT new com.bionic.restaurantTry1.entities.Report "
				+ "(SUM(o.count), SUM(o.price * o.count) ) " + "FROM OrderDetail o"
				+ " where o.order.orderDateTime between" + " \'" + startPeriod
				+ "\'" + " and \'" + endPeriod + "\'"
				+ " and o.dish.typeDish = " + "\"" + category + "\""; // group by category and date
		TypedQuery<Report> query = em.createQuery(txt, Report.class);
		return query.getSingleResult();
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
		order.setStatusTime(Timestamp.valueOf(LocalDateTime.now()));

	}

	@Override
	public void setStatusNonKitchenDone(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("non-kitchen done");
		order.setStatusTime(Timestamp.valueOf(LocalDateTime.now()));

	}

	@Override
	public void setStatusReadyForShipment(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("ready for shipment");
		order.setStatusTime(Timestamp.valueOf(LocalDateTime.now()));

	}

	@Override
	public void setStatusDelivering(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("delivering");
		order.setStatusTime(Timestamp.valueOf(LocalDateTime.now()));

	}

	@Override
	public void setStatusDelivered(Orders o) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus("delivered");
		order.setStatusTime(Timestamp.valueOf(LocalDateTime.now()));

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
