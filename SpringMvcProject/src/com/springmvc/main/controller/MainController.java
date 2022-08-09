package com.springmvc.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String sayHello() { 
		return "index"; //prefix: WEB-INF/jsps/       suffix: .jsp
	}
	
	@RequestMapping("/products")
	public String showProducts() {
		return "products";
	}
}
