package com.springmvc.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springmvc.main.controller","com.springmvc.main.model",
		"com.springmvc.main.service","com.springmvc.main.persistence"})
public class ControllerConfig implements WebMvcConfigurer{

	@Bean   
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/jsps/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean
	public DataSource getDataSource() { //DataSource ds = new DriverManagerDataSource();
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/mavericks_boot_db");
		ds.setUsername("root");
		ds.setPassword(""); //for VDI: Password123
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds; 
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
