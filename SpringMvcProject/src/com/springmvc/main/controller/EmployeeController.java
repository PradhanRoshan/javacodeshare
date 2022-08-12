package com.springmvc.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.springmvc.main.model.Employee;
import com.springmvc.main.utility.CredentialsUtility;

@Controller
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate; //100X
	
	@RequestMapping("/employee-list")
	public String showEmployees(Model model) {
		String getEmployeeAPi="http://localhost:8282/employee"; //GET - List<Employee>
		
		HttpEntity<String> entity = new HttpEntity<>(CredentialsUtility.getHeaders());
		
		ResponseEntity<List> response = restTemplate.exchange(getEmployeeAPi, 
				HttpMethod.GET,entity,List.class);
		List  list = response.getBody();
		 
		model.addAttribute("list", list);
		return "employee-list";
	}
}
