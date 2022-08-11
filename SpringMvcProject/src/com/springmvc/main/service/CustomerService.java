package com.springmvc.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.main.model.Customer;
import com.springmvc.main.persistence.CustomerDB;

@Service
public class CustomerService {

	@Autowired
	private CustomerDB customerDB;
	public void insertCustomer(Customer customer) {
		//reach out to persistence class: DB 
		
		customerDB.insertCustomer(customer);
	}
	
}
