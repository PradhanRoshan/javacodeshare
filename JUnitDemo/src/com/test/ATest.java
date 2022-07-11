package com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.main.exception.MarksException;
import com.main.model.Employee;
import com.main.service.A;

public class ATest {
	A a;
	
	@Before
	public void init() {
		a=new A();
	}
	@Test
	public void sumTest(){
		 
		Assert.assertEquals(14, a.sum(5, 9));
		Assert.assertNotEquals(13, a.sum(5, 9));
		Assert.assertEquals(0, a.sum(0, 0));
		Assert.assertEquals(4, a.sum(-5, 9));
		Assert.assertEquals(-14, a.sum(-5, -9));
		 
	}
	
	@Test
	public void computePercentTest(){ //test case
		 
		assertEquals(48, Math.round(a.computePercent(145, 300))); //use case
		assertEquals(49, Math.round(a.computePercent(146, 300)));
		assertEquals(83, Math.round(a.computePercent(250, 300)));
	}
	
	@Test
	public void computeGradeTest() {
		 
		Assert.assertEquals("A", a.computeGrade(76));
		Assert.assertEquals("B", a.computeGrade(66));
		Assert.assertEquals("C", a.computeGrade(58));
		Assert.assertEquals("D", a.computeGrade(42));
		Assert.assertNotEquals("D", a.computeGrade(46));
	}
	
	@Test
	public void sortArrayTest(){
		 
		Integer[] arrActual = new Integer[]{4,1,2,5,3};
		Integer[] arrExpected = new Integer[]{1,2,3,4,5};
		
		Assert.assertArrayEquals(arrExpected,a.sortArray(arrActual, "ASC"));
		Assert.assertArrayEquals(arrExpected,a.sortArray(arrActual, "Asc"));
		
		arrExpected = new Integer[]{5,4,3,2,1};
		Assert.assertArrayEquals(arrExpected,a.sortArray(arrActual, "DESC"));
		
		Assert.assertArrayEquals(arrActual,a.sortArray(arrActual, "ASCENDING"));
	}
	
	@Test
	public void filterListTest() {
		 
		List<Integer> actualList = Arrays.asList(2,3,1,4,6,7,5,9);
		List<Integer> expectedList = Arrays.asList(2,4,6);
		
		Assert.assertEquals(expectedList, a.filterList(actualList, "EVEN"));
		Assert.assertEquals(3, a.filterList(actualList, "EVEN").size());
		expectedList = Arrays.asList(3,1,7,5,9);
		Assert.assertEquals(expectedList, a.filterList(actualList, "odd"));
		Assert.assertEquals(actualList, a.filterList(actualList, "EVEE"));
	}
	
	@Test
	public void filterEmployeeListTest(){
		 
		Employee e1 = new Employee(1,"harry",85000);
		Employee e2 = new Employee(2,"ronald",75000);
		Employee e3 = new Employee(3,"hermione",95000);
		
		List<Employee> actualList = Arrays.asList(e1,e2,e3);
		List<Employee> expectedList = Arrays.asList(e2);
		Assert.assertEquals(expectedList, a.filterEmployeeList(actualList, 80000, "less"));
		expectedList = Arrays.asList(e1,e3);
		Assert.assertEquals(expectedList, a.filterEmployeeList(actualList, 80000, "more"));
		Assert.assertEquals(actualList, a.filterEmployeeList(actualList, 80000, ""));

	}
	
	@Test 
	public void computePercentExceptionTest() {
		 
		try {
			Assert.assertEquals(65, Math.round(a.computePercentException(130, 200)));
		}
		catch(MarksException e) { }	
		try {
			Assert.assertEquals(75, Math.round(a.computePercentException(230, 200)));
		}
		catch(MarksException e) {
			Assert.assertEquals("Marks cannot be greater than total", e.getMessage());
		}	
		try {
			Assert.assertEquals(75, Math.round(a.computePercentException(-50, 200)));
		}
		catch(MarksException e) {
			Assert.assertEquals("Marks cannot be less than 0", e.getMessage());
		}	
		try {
			Assert.assertEquals(75, Math.round(a.computePercentException(0, 0)));
		}
		catch(ArithmeticException | MarksException e) {
			Assert.assertEquals("Divide by zero not allowed", e.getMessage());
		}
	}
	
	@Test
	public void doStuffTest() {

		int x = a.getX();  //0 
		int y = a.getY();  //0
		a.doStuff(5, 5);
		Assert.assertEquals(6 ,a.getX());
		Assert.assertEquals(6 ,a.getY());
		
	}
	
	@After
	public void after() {
		a=null;
	}
}
 









