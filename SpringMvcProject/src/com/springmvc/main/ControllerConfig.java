package com.springmvc.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springmvc.main.controller","com.springmvc.main.model",
		"com.springmvc.main.service"})
public class ControllerConfig implements WebMvcConfigurer{

	@Bean   
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/jsps/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
