package com.bionic.webrestaurant.managebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Customer;
import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.service.MenuService;
import com.bionic.webrestaurant.service.OrdersService;

@Named
@Scope("session")
public class ShoppingCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7057437172462593672L;

	private HashMap<Menu, Integer> shopCart;

	private List<Menu> list;

	private Menu m;

	private Integer count = 1;

	private Double sum;
	
	@Inject
	private CustomerBean customerBean;

	@Inject
	private MenuService menuService;
	
	@Inject
	private OrdersService ordersService;

	public ShoppingCart() {
		super();
		list = new ArrayList<Menu>();
		sum = 0.0;
		shopCart = new HashMap<Menu, Integer>();
	}

	public HashMap<Menu, Integer> getShopCart() {
		return shopCart;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSum() {
		return sum;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}

	public void addToCart(String id, String count) {
		Integer mId = Integer.valueOf(id);
		Integer mCount = Integer.valueOf(count);
		Menu dish = menuService.findById(mId);
		if (!shopCart.containsKey(dish)) {
			list.add(dish);
		}
		shopCart.put(dish, mCount);
	}

	public void updateSum() {
		sum = 0.0;
		for (Menu m : list) {
			sum += m.getPrice() * shopCart.get(m);
		}
		System.out.println("sum updated");

	}

	public void goToChangeCount(Menu m) {
		this.m = m;
	}

	public void changeCount(Integer count) {
		shopCart.put(m, count);
		updateSum();
	}

	public void update(Integer id, String count) {
		Menu m = menuService.findById(id);
		shopCart.put(m, Integer.valueOf(count));
	}

	public void remove(String id) {
		Menu m = menuService.findById(Integer.valueOf(id));
		shopCart.remove(m);
		list.remove(m);
		updateSum();
	}

	public String confirmOrder(){
		ordersService.addNewOrder(shopCart, customerBean.getCustomer(), sum);
		shopCart = new HashMap<Menu, Integer>();
		list = new ArrayList<Menu>();
		return "homePage";
	}
	
	
	public String confirm(Customer c) {
		System.out.println("Go to confirm");
		if (c.getId() == 0) {
			return "confirmationOrder.xhtml?faces-redirect=true";
		}
		return "informationOrder.xhtml?faces-redirect=true";
	}
}
