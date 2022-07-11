package com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest {

	@BeforeClass //this executes only once before all test cases 
	public static void beforeClass() {
		System.out.println("before class..");
	}
	@Before //this executes before every test case. 
	public void init() {
		System.out.println("init");
	}
	@Test
	public void test1() {
		System.out.println("test-1");
	}
	@Test
	public void test2() {
		System.out.println("test-2");
	}
	@After //this executes after every test case.
	public void after() {
		System.out.println("after");
	}
	@AfterClass //this executes only once right at the end 
	public static void afterClass() {
		System.out.println("After class..");
	}
}
