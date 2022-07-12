package com.service;

import java.util.HashMap;
import java.util.Map;

import com.model.User;
import com.persistence.DB;

public class UserService {

	DB db; 
	
	Map<String,String> map; 
	
	{
		map = new HashMap<>(); 
		map.put("harry","potter123");
		map.put("ronald","weasley123");
		
		db=new DB();
	}
	
	public boolean validateCredentials(String username, String password) {
		/*
		 * boolean isPresent=false; for(String key :map.keySet()) {
		 * if(key.equals(username)) { isPresent = true; break; } }
		 * 
		 * if(isPresent) { String pass = map.get(username); if(pass.equals(password))
		 * return true; } return false;
		 */
		return db.validateCredentials(username, password);
		
	}

	public void insertUser(User user) {
		db.insertUser(user);
		
	}

	
}
