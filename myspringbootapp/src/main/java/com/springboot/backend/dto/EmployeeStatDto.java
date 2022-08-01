package com.springboot.backend.dto;

public class EmployeeStatDto {
	private String department; 
	private Integer count;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	} 
	
	
}
