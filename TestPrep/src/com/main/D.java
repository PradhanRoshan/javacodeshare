package com.main;

import java.util.HashSet;
import java.util.Set;

public class D {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("a");
		set.add("b"); //[a,b]
		
		set.add("a"); 
		set.add("b");
		
		System.out.println(set.size());
		
		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(1);
		
		System.out.println(set1.size());
		
		Set set3 = new HashSet(); 
		One one = new One();
		one.name="abc";
		Two two = new Two();
		two.name="abc";
		
		set3.add(one);
		set3.add(two);
		
		System.out.println(set3.size());
		
		Set<One> set4 = new HashSet<>(); 
		One obj1=new One(); //100X
		One obj2=new One(); //200X
		
		obj1.name="";
		obj2.name="";
		
		set4.add(obj1);
		set4.add(obj2);
		
		System.out.println(set4.size()); //1
		
	}
}
/*
equals- String: compares values 

Integer, Float, Long, Double, Boolean, Short, Byte, Character

*/

class One{
	String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		One other = (One) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	} 
	
	
}

class Two{
	String name; 
}