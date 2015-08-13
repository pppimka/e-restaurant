package com.bionic.webrestaurant.managebeans;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.context.annotation.Scope;

import com.bionic.webrestaurant.entities.Report;
import com.bionic.webrestaurant.service.OrdersService;

@Named
@Scope("session")
public class BusinessAnalystBean {

	private LocalDateTime startPeriod;

	private LocalDateTime endPeriod;

	private LineChartModel dateModelSum;

	private LineChartModel dateModelCount;

	private String category;


	@Inject
	private OrdersService ordersService;

	public BusinessAnalystBean() {
		super();
		startPeriod = LocalDateTime.now();
		endPeriod = LocalDateTime.now();
		dateModelSum = new LineChartModel();
		dateModelCount = new LineChartModel();
	}

	public Date getStartPeriod() {
		return Date
				.from(startPeriod.atZone(ZoneId.systemDefault()).toInstant());
	}

	public void setStartPeriod(Date startPeriod) {
		this.startPeriod = LocalDateTime.ofInstant(startPeriod.toInstant(),
				ZoneId.systemDefault());
	}

	public Date getEndPeriod() {
		return Date.from(endPeriod.atZone(ZoneId.systemDefault()).toInstant());
	}

	public void setEndPeriod(Date endPeriod) {
		this.endPeriod = LocalDateTime.ofInstant(endPeriod.toInstant(),
				ZoneId.systemDefault());
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public void showModel() {
		dateModelSum = new LineChartModel();
		dateModelCount = new LineChartModel();

		LineChartSeries series1 = new LineChartSeries();
		LineChartSeries series2 = new LineChartSeries();
		List<Report> reports;
		if (category != null && !category.equals("")) {
			reports = ordersService.getReport(startPeriod, endPeriod, category);
		} else {
			reports = ordersService.getReport(startPeriod, endPeriod);
		}
		if (reports.isEmpty()) {
			dateModelSum = null;
			dateModelCount = null;
		} else {
			DateAxis axis = new DateAxis("Dates");
			
			SimpleDateFormat dt = new SimpleDateFormat("dd-MM");
			for (Report r : reports) {
				series1.set(r.getDay().toString(), r.getSumOrders());
				series2.set(r.getDay().toString(), r.getCountOrders());
			}
			dateModelSum.addSeries(series1);
			dateModelSum.setTitle("Sum of orders");
			dateModelSum.setAnimate(true);
			axis.setTickFormat("%b %#d, %y");
			dateModelSum.getAxes().put(AxisType.X, axis);

			dateModelCount.addSeries(series2);
			dateModelCount.setTitle("Count of orders");
			dateModelCount.setAnimate(true);
			dateModelCount.getAxes().put(AxisType.X, axis);
		}
	}

	public LineChartModel getDateModelSum() {
		return dateModelSum;
	}

	public LineChartModel getDateModelCount() {
		return dateModelCount;
	}

}
