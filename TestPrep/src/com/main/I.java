package com.main;

public class I {
	public static void main(String[] args) {
		SuperClass sc = new SubClass(); 
		sc.m1(); 
	}
}


class SuperClass{
	static void m1() {
		System.out.println("A");
	}
}

class SubClass extends SuperClass{
	static void m1() {
		System.out.println("B");
	}
}
