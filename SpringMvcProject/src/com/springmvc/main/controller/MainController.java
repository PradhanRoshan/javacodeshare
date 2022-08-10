package com.springmvc.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.main.model.Vendor;

@Controller
public class MainController {
	 @Autowired
	private Vendor v; //instantiation - destroying v=null System.gc()
	
	@RequestMapping("/")
	public String viewIndex(Model model) {    //Dependency Injection (DI) in spring-mvc
		//IOC: Inversion of Control
		//pass the variable username to index.jsp page 
		model.addAttribute("username", "harry potter");
		return "index"; //prefix: WEB-INF/jsps/       suffix: .jsp
	}
	
	@RequestMapping("/products")
	public String showProducts(HttpServletRequest request) {
		//pass an array to products.jsp
		String[] names=new String[] {"micheal","keith","john"};
		request.setAttribute("namesArr", names);
		return "products";
	}
	
	@RequestMapping("/vendors")
	public ModelAndView showVendors(ModelAndView mav) {
		//pass an Object to jsp 
		v.setId(1L);
		v.setName("ABC Electronics");
		
		mav.addObject("vendorObj", v); 
		mav.setViewName("vendors");
		return mav;
	}
	
	
}


