package com.main;

 
public class J {
	public static void main(String[] args) {
		try {
			int x = 5;
			int x1= 0;
			x1 /= x; //=> x1 = x1/x
			
			throw 5/0; //throw new DemoException(); <- Demo is not Ex. class
		}
		catch(Exception e) {
			throw new RuntimeException("I am catch ex."); 
		}
		finally {
			System.out.println("finally");
			//throw new RuntimeException("I am finally ex."); 
		}
	}
}
/*
 * 0/5 = 0 
 * 5/0 =AE
 */

class DemoException{
	String m1() {
		return "5/0";
	}
}
