package com.springmvc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String showAddCustomer(Model model) {
		model.addAttribute("msg", ""); 
		return "add-customer";
	}
	
	@RequestMapping("/process-add-customer")
	public String processAddCustomer(@RequestParam("cname") String name,
								   @RequestParam("ccity") String city,
								   @RequestParam("cage") int age, 
								   Model model) {
		/*
		 * 1. Attach the values to customer object
		 * 2. Reach out to persistence layer via service and insert the object in DB  
		 */
		customer.setName(name);
		customer.setCity(city);
		customer.setAge(age);
		
		customerService.insertCustomer(customer); 
		model.addAttribute("msg", "Customer added in DB"); 
		return "add-customer";
	}
}
