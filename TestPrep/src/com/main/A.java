package com.main;

import java.util.HashMap;
import java.util.Map;

public class A {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("harry", "potter");
		map.put("ron", "weasley");
		 
		/*
		 * get all keys: keySet()  
		 * get all values: values()
		 * Map.get(key) -- value 
		 * Map.Entry : data type of an entry in the map. 
		 */
		
		for(_________________ e: map.entrySet()) {  //<String,String>
			System.out.println(e.getKey() + "---" + e.getValue());
		}
		
	}
}
/*
 * Map.Entry<String, String>
 * Map.Entry
 * 
 */
