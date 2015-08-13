package com.bionic.webrestaurant.managebeans;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.OrderDetail;
import com.bionic.webrestaurant.service.OrderDetailService;

@Named
@Scope("session")
public class KitchenBean {
	
	private DateTimeFormatter formatter;

	private List<OrderDetail> listOrders;
	
	@Inject
	private StaffAuthorizationBean staffBean;
		
	@Inject
	private OrderDetailService orderDetailService;

	public KitchenBean() {
		super();
		formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
		listOrders = new ArrayList<OrderDetail>();
	}

	public List<OrderDetail> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<OrderDetail> listOrders) {
		this.listOrders = listOrders;
	}
	
	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	public void getDishesToPrepair() {
		List<OrderDetail> list = orderDetailService.getUnpreparedDished();
		if (list != null) {
			listOrders = list;
		}
	}
	
	public void confirmCook(OrderDetail od) {
		System.out.println("cook hello)");
		od.setCook(staffBean.getStaff());
		orderDetailService.save(od);
	}
	
	public void prepared(OrderDetail od) {
		orderDetailService.setPreparedStatusTrue(od);		
		getDishesToPrepair();
	}
	
	
}
