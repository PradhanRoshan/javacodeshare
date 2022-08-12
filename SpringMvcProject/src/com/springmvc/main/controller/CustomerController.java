package com.springmvc.main.controller;

import java.util.List;

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
	
	@RequestMapping("/view-customers")
	public String fetchAllCustomers(Model model) {
		//go to DB via service and fetch customers as List<Customer>
		List<Customer> list = customerService.fetchAllCustomers();
		model.addAttribute("customer_list",list);
		return "customers"; 
	}
	 
	@RequestMapping("/delete-customer")
	public String deleteCustomer(@RequestParam("id") Long id, Model model) {
		customerService.deleteCustomer(id);
		List<Customer> list = customerService.fetchAllCustomers();
		model.addAttribute("customer_list",list);
		return "customers";
	}
	
	@RequestMapping("/edit-customer")
	public void editCustomer(@RequestParam("id") Long id, Model model) {
		Customer customer = customerService.fetchCustomerById(id);
		System.out.println(customer);
		//display the form which is auto-filled with above customer Info
	}
}
