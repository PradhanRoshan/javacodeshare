package com.springmvc.main.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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

	public List<Customer> fetchAllCustomers() {
		 
		String sql="select * from customerInfo";
		return jdbc.query(sql, new A());
	}

	public void deleteCustomer(Long id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		String sql="delete from customerInfo where id=:id";
		jdbc.update(sql, map);
	}

	public Customer fetchCustomerById(Long id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id",id);
		String sql="select * from customerInfo where id=:id"; 
		
		return jdbc.query(sql, map, new A()).get(0);
	}

	public void editCustomer(Customer customer) {
		String sql="update customerInfo SET name=:name,age=:age,city=:city where id=:id";
		Map<String,Object> map = new HashMap<>();
		map.put("id",customer.getId());
		map.put("name",customer.getName());
		map.put("age",customer.getAge());
		map.put("city",customer.getCity());		
		jdbc.update(sql, map);
	}
}

class A implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer(); 
		Long id =  rs.getLong("id");
		String name = rs.getString("name"); 
		int age = rs.getInt("age");
		String city = rs.getString("city");
		
		c.setId(id);
		c.setName(name);
		c.setCity(city);
		c.setAge(age);
		return c;
	}
	
}

/*
update() : insert, update, delete  
query() : select 
*/