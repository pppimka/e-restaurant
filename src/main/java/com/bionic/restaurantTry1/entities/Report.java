package com.bionic.restaurantTry1.entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Report {

	private long countOrders;

	private double sumOrders;

	private Date day;

	private LocalDateTime startPeriod;

	private LocalDateTime endPeriod;

	private String category;

	public Report() {

	}

	public Report(long countOrders, double sumOrders) {
		super();
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
	}

	public Report(long countOrders, double sumOrders, Date day) {
		super();
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
		this.day = day;
	}
	
	public Report(long countOrders, double sumOrders, Date day, String category) {
		super();
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
		this.day = day;
		this.category = category;
	}

	public Report(int countOrders, double sumOrders, LocalDateTime startPeriod,
			LocalDateTime endPeriod) {
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
	}

	public Report(int countOrders, double sumOrders, LocalDateTime startPeriod,
			LocalDateTime endPeriod, String category) {
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.category = category;
	}

	public void setCountOrders(long countOrders) {
		this.countOrders = countOrders;
	}

	public long getCountOrders() {
		return countOrders;
	}

	public double getSumOrders() {
		return sumOrders;
	}

	public void setSumOrders(double sumOrders) {
		this.sumOrders = sumOrders;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public LocalDateTime getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(LocalDateTime startPeriod) {
		this.startPeriod = startPeriod;
	}

	public LocalDateTime getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(LocalDateTime endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Report [countOrders=" + countOrders + ", sumOrders="
				+ sumOrders + " day=" + day + ", startPeriod=" + startPeriod + ", endPeriod="
				+ endPeriod + ", category=" + category + "]";
	}

}
