package com.main;

public class K {
	public static void main(String[] args) {
		String s1="abc"; //pool : 10X: abc
		 
		String s2=new String("abc"); //heap : 100X: abc 
		s2=s2.intern(); //10X
		System.out.println(s1 == s2); // 10X -- true 
		
		
		/*
		 * Trim
		 */
		String s = " java duke ";
		s = s.trim();
		System.out.println(s.length());
	}
}
