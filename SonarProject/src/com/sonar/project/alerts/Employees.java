package com.sonar.project.alerts;

import java.util.List;

public class Employees {
	
	public Double id;
	
	private String name;
	
	private List<String> assignments;
	
	private int payRaise;

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<String> assignments) {
		this.assignments = assignments;
	}
	
	public boolean isEmployee() {
		return this instanceof Employees;
	}
	
	public int getPayRaise() {
		int myPay =+ payRaise;
		
		myPay = myPay + 21;
		
		myPay =- 12;
		
		return myPay;
	}
	

}
