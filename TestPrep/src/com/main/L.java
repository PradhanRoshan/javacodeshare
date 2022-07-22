package com.main;

public class L {
	public static void main(String[] args) {
		Outer.Inner i = new Outer.Inner(); 
		 i.m1();
	}
}


class Outer{ //outer class
	static int x=10; 
	
	void display() {
		System.out.println("display");
	}
	
	static class Inner{ //inner class
		void m1() {
			System.out.println(x);
		}
	}
}
/*  Static inner class can access only static variables of outer class
 *  Non static inner class can access both static and non-static variables of outer class. 
 *  A 
 *     static x
 *     
 *  new A().x 
 *  A.x  
 */
