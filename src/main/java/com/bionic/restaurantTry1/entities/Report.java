package com.bionic.restaurantTry1.entities;

import java.sql.Timestamp;

public class Report {

	private long countOrders;
	
	private double sumOrders;
	
	private java.sql.Timestamp startPeriod;
	
	private java.sql.Timestamp endPeriod;
	
	private String category;
	
	public Report() {
		
	}
	
	public Report(long countOrders, double sumOrders) {
		super();
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
	}
	
	public Report(int countOrders, double sumOrders, Timestamp startPeriod,
			Timestamp endPeriod, String category) {
		this.countOrders = countOrders;
		this.sumOrders = sumOrders;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.category = category;
	}

	public long getCountOrders() {
		return countOrders;
	}

	public void setCountOrders(int countOrders) {
		this.countOrders = countOrders;
	}

	public double getSumOrders() {
		return sumOrders;
	}

	public void setSumOrders(double sumOrders) {
		this.sumOrders = sumOrders;
	}

	public java.sql.Timestamp getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(java.sql.Timestamp startPeriod) {
		this.startPeriod = startPeriod;
	}

	public java.sql.Timestamp getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(java.sql.Timestamp endPeriod) {
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
				+ sumOrders + ", startPeriod=" + startPeriod + ", endPeriod="
				+ endPeriod + ", category=" + category + "]";
	}
		
	
}
