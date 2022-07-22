package com.main;

import java.util.Set;
import java.util.TreeSet;

public class B {
	public static void main(String[] args) {
		
		Set set = new TreeSet(); 
		set.add(1);
		set.add("john");
		set.add(4F); 
		set.add(null);
		/*
		 *  sorted: 1 "" 4F  
		 */
		System.out.println(set);
	}
}
/*
a. java.lang.ClassCastException
b. 1 john 4.0 
c. 1 john 4 
*/
 