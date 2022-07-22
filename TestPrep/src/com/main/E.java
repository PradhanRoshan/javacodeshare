package com.main;

import java.util.ArrayList;
import java.util.TreeSet;

public class E {
	public static void main(String[] args) {
		ArrayList<String> list0 = new ArrayList<>();
		MyClass<String> list = new MyClass<>();
		MyClass<Integer> list1 = new MyClass<>();
		MyClass<Double> list2 = new MyClass<>();
		
		list0.add("harry");
		
		list.add("ron");
		System.out.println(list.get());
		list.add(4); 
		
		list1.add(3);
		System.out.println(list1.get());
		
		TreeSet set; 
		
		
	}
}

class MyClass<T>{ //<- type parameter class 
	T t; 
	
	void add(T t) {
		this.t = t; 
	}
	
	T get(){
		return t; 
	}
}
/*
 * SortedSet 
 * |
 * TreeSet 
 */

/*
 *  Vector 
 *  Hashtable
 *  TreeSet: comparable interface 
 *  
 *  class A implements Comparable {
 *  
 *  }
 *  TreeSet={a1,a2,a3}
 */
