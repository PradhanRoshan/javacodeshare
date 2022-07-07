package com.main;

import java.util.List;
import java.util.Scanner;

import com.main.db.DB;
import com.main.model.Employee;
import com.main.model.Product;

public class App {
	public static void main(String[] args){
		 DB db = new DB();
		 Employee employee = new Employee(); 
		 while(true) {
			 Scanner sc = new Scanner(System.in);
			 System.out.println("*****DB OPS*****");
			 System.out.println("1. Insert Employee");
			 System.out.println("2. Show all Employees");
			 System.out.println("3. Delete Employee");
			 System.out.println("4. Update Employee");
			 System.out.println("5. Fetch product with Vendor Details");
			 System.out.println("0. To Exit");
			 System.out.println("Enter your input");
			 int input = sc.nextInt();
			 if(input == 0) {
				 System.out.println("Exiting.. Bye!!");
				 break; 
			 }
			 switch(input) {
				 case 1: 
					 //Read the values from the User
					 System.out.println("Enter Employee Name");
					 sc.nextLine(); //skip this
					 String name = sc.nextLine();
					 System.out.println("Enter Employee Salary");
					 double salary = sc.nextDouble();
					 System.out.println("Enter Employee City");
					 String city = sc.next();
					 System.out.println("Enter Department Name");
					 String departmentName= sc.next();
					 
					 //Attach these values to Employee Object
					 employee.setName(name);
					 employee.setSalary(salary);
					 employee.setCity(city);
					 employee.setDepartmentName(departmentName);
					 db.insertEmployee(employee);
					 System.out.println("Employee added to DB..");
					 break;
				 case 2: 
					 List<Employee> list = db.fetchEmployees();
					 for(Employee e: list) {
						 System.out.println(e);
					 }
					 break; 
				 case 3: 
					 System.out.println("Enter Employee ID");
					 int id = sc.nextInt();
					 boolean isValid = EmployeeUtility.validateId(db.fetchEmployees(),id);
					 if(!isValid) {
						 System.out.println("Invalid ID, Try Again!");
						 break; 
					 }
					 db.deleteEmployee(id);
					 System.out.println("Employee Deleted from DB..");
					 break; 
				 case 4: 
					 System.out.println("Enter Employee ID");
					 id = sc.nextInt();
					 isValid = EmployeeUtility.validateId(db.fetchEmployees(),id);
					 if(!isValid) {
						 System.out.println("Invalid ID, Try Again!");
						 break; 
					 }
					 Employee emp = db.fetchEmployee(id); 
					 System.out.println("Existing Record for ID: "+id);
					 System.out.println(emp);
					 System.out.println("Enter Employee Name to Update");
					 sc.nextLine(); //skip this
					 name = sc.nextLine();
					 System.out.println("Enter Employee Salary");
					 salary = sc.nextDouble();
					 System.out.println("Enter Employee City");
					 city = sc.next();
					 System.out.println("Enter Department Name");
					 departmentName= sc.next();
					 employee.setId(id);
					 employee.setName(name);
					 employee.setSalary(salary);
					 employee.setCity(city);
					 employee.setDepartmentName(departmentName);
					 db.updateEmployee(employee);
					 System.out.println("Employee Record Updated!!");
					 break; 
				 case 5:
					 List<Product> plist = db.fetchAllProductsWithVendor();
					 for(Product p : plist) {
						 System.out.println(p);
					 }
					 break; 
				 default: 
					 break; 
			 }
		 }
		 
	}
}  
 
