package com.springboot.backend.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer;
import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.CustomerRepository;
import com.springboot.backend.repository.UserRepository;

@RestController
public class CustomerController {

	// Controller: (Entity) : FindAll, POST, FindById, DeleteById, Update 
	@Autowired
	private CustomerRepository customerRepository; 
	 
	@Autowired
	private UserRepository userRepository;
	@PutMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer, Principal principal) {
		String username = principal.getName();
		Customer c = customerRepository.getCustomerByUsername(username);
		c.setAge(customer.getAge());
		c.setCity(customer.getCity());
		return customerRepository.save(customer); 
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
}
