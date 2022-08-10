package com.springmvc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.main.model.Customer;
import com.springmvc.main.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private Customer customer; 
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/add-customer")
	public String showAddCustomer() {
		return "add-customer";
	}
	
	@RequestMapping("/process-add-customer")
	public void processAddCustomer(@RequestParam("cname") String name,
								   @RequestParam("ccity") String city,
								   @RequestParam("cage") int age) {
		/*
		 * 1. Attach the values to customer object
		 * 2. Reach out to persistence layer via service and insert the object in DB  
		 */
		
		customer.setName(name);
		customer.setCity(city);
		customer.setAge(age);
		
		
	}
}
