package com.main;

import java.util.List;

import com.main.model.Employee;

public class EmployeeUtility {

	public static boolean validateId(List<Employee> list, int id) {
		boolean isPresent = false;
		 for(Employee e:list) {
			 if(e.getId() == id) {
				 isPresent = true;
				 break;
			 }		 
		 }
		return isPresent;
	}
}
