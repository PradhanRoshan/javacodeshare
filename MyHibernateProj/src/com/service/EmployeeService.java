package com.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.Employee;

public class EmployeeService {

	public List<Employee> fetchAllEmployee(EntityManager entityManager) {
		List<Employee> list = 
			entityManager.createQuery("select e from Employee e", Employee.class)
			.getResultList();
		
		return list;
	}
 
}
/*
 * ORM: Object relational mapping 
 
HQL(Hibernate Query Language) / Criteria Query : we query the class 
SQL: select * from employee : we query on DB tables 
HQL: select e from Employee e : We query on Model class
*/