package com.bionic.webrestaurant.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.Report;
import com.bionic.webrestaurant.entities.TypeDish;
import com.bionic.webrestaurant.service.MenuService;
import com.bionic.webrestaurant.service.OrdersService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/application-config.xml");

		MenuService menuService = context.getBean(MenuService.class);

		OrdersService ordersService = context.getBean(OrdersService.class);
		
//		List<Menu> list = menuService.getDishes(TypeDish.BEVERAGE);
		
		List<Report> list = ordersService.getReport(LocalDateTime.now().minusDays(5), LocalDateTime.now().plusDays(3));

		for (Report m : list) {
			System.out.println(m);
		}

	}

}
