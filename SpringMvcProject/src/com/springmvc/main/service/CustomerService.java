package com.springmvc.main.service;

import java.util.List;

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
	public List<Customer> fetchAllCustomers() {
		 
		return customerDB.fetchAllCustomers();
	}
	public void deleteCustomer(Long id) {
		customerDB.deleteCustomer(id);
		
	}
	public Customer fetchCustomerById(Long id) {
		 
		return  customerDB.fetchCustomerById(id);
	}
	
}
