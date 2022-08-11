package com.springmvc.main.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.springmvc.main.model.Customer;

@Component
public class CustomerDB {
 
	private DataSource dataSource; 
	
	private NamedParameterJdbcTemplate jdbc; 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		 jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
 
	public void insertCustomer(Customer customer) {
		Map<String,Object> map = new HashMap<>();
		map.put("name",customer.getName());
		map.put("age",customer.getAge());
		map.put("city",customer.getCity());
		
		String sql="insert into customerInfo(name,age,city) values (:name,:age,:city)";
		jdbc.update(sql, map);
	}
}
/*
update() : insert, update, delete  
query() : select 
*/