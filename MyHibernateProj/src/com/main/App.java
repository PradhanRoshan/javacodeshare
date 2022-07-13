package com.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.model.Employee;
import com.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		/*
		 * EntityManagerFactory will help me reach out to persistence.xml 
		 */
		EntityManagerFactory entityManagerFactory=null;
		
		/*
		 * EntityManager will help us manage and perform operations on DB thru our models
		 */
		EntityManager entityManager = null;
		
		/*
		 * EntityTransaction will help us manage transaction states.
		 */
		EntityTransaction entityTransaction = null;
		
		entityManagerFactory = Persistence.createEntityManagerFactory("mycompanydb");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
		Scanner sc = new Scanner(System.in); 
		while(true) {
			if(entityTransaction.isActive())
						entityTransaction.begin();
			System.out.println("-----Employee Operations-------");
			System.out.println("1. Insert Employee");
			System.out.println("2. Fetch all Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("0. Exit");
			int input = sc.nextInt();		
			if(input == 0) {
				System.out.println("Exiting... Bye..");
				break; 
			}
			switch(input) {
			case 1: 
				Employee e = new Employee();
				System.out.println("Enter employee Name");
				e.setName(sc.next());
				System.out.println("Enter employee Salary");
				e.setSalary(sc.nextDouble());
				System.out.println("Enter employee City");
				e.setCity(sc.next());
				entityManager.persist(e);
				System.out.println("Employee added in DB...");
				entityTransaction.commit();
				break;
			case 2: 
				System.out.println("*******ALL Employee******");
				EmployeeService service = new EmployeeService();
				List<Employee> list = service.fetchAllEmployee(entityManager);
				for(Employee emp : list) {
					System.out.println(emp);
				}
				entityTransaction.commit();
				break;
			case 3: 
				System.out.println("Enter the employee ID");
				int eid = sc.nextInt();
				Employee employee = entityManager.find(Employee.class, eid); //id, name, salary, city
				if(employee == null) {
					System.out.println("Employee ID Invalid");
					entityTransaction.commit();
					break;
				}
				System.out.println("Current Record: ");
				System.out.println(employee);//id(old),name(old),salary(old),city(old)
				System.out.println("");
				System.out.println("Enter employee Name");
				employee.setName(sc.next()); //id(old),name(new),salary(old),city(old)
				System.out.println("Enter employee Salary");
				employee.setSalary(sc.nextDouble());//id(old),name(new),salary(new),city(old)
				System.out.println("Enter employee City");
				employee.setCity(sc.next());//id(old),name(new),salary(new),city(new)
				entityManager.persist(employee);
				System.out.println("Employee record updated..");
				entityTransaction.commit();
				break;
			case 4: 
				System.out.println("Enter the employee ID");
				eid = sc.nextInt();
				employee = entityManager.find(Employee.class, eid); //id, name, salary, city
				if(employee == null) {
					System.out.println("Employee ID Invalid");
					entityTransaction.commit();
					break;
				}
				entityManager.remove(employee);
				System.out.println("Employee deleted");
				entityTransaction.commit();
				break;
			default:
				System.out.println("Invalid Input, Try Again!!");
				entityTransaction.commit();
			}
		}
		
		
	}
}
