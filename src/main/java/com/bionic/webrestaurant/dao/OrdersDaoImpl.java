package com.bionic.webrestaurant.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Orders;
import com.bionic.webrestaurant.entities.OrdersStatus;
import com.bionic.webrestaurant.entities.Report;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void save(Orders order) {
		if (order.getId() != 0) {
			em.merge(order);
		} else {
			em.persist(order);
		}
	}

	@Override
	public List<Report> getReport(LocalDateTime startPeriod,
			LocalDateTime endPeriod) {
		String txt = "SELECT new com.bionic.webrestaurant.entities.Report "
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
		String txt = "SELECT new com.bionic.webrestaurant.entities.Report "
				+ "(SUM(o.count), SUM(o.price * o.count), FUNC('DATE',o.order.orderDateTime), "
				+ "\""
				+ category
				+ "\") "
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
	public List<Orders> getOrders(OrdersStatus ordersStatus) {
		String txt = "Select o from Orders o where o.status = \"" + ordersStatus.getOrderStatus() + "\"";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void setStatus(Orders o, OrdersStatus st) {
		Orders order = em.find(Orders.class, o.getId());
		order.setStatus(st.getOrderStatus());
		order.setStatusTime(LocalDateTime.now());
		save(order);
	}

	@Override
	public List<Orders> getCustomerOrders(Customer customer) {
		String txt = "Select o from Orders o where o.customer.id = "
				+ customer.getId();
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

	@Override
	public List<Orders> getAllReadyOrders() {
		String txt = "Select o from Orders o where o.status != "
				+ "\"preparing\" ";
		TypedQuery<Orders> query = em.createQuery(txt, Orders.class);
		return query.getResultList();
	}

}
