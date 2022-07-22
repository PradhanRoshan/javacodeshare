package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class App {
	public static void main(String[] args) {
		 
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);  //java.lang.UnsupportedOperationException
		List<Integer> list  = new ArrayList<>(); //java.util.ConcurrentModificationException
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(null);
		/*
		 * Iterator : iterator()
		 * ListIterator : listIterator() 
		 */
		
		ListIterator<Integer> itr = list.listIterator(); //itr -> [1,2,3,4,5]
		
		/*
		 * hasNext()
		 * next()
		 */
		
		while(itr.hasNext()) {
			int value = itr.next();
			System.out.print(value + " "); //1 2 3 4 5 
			
			if(value == 3)
				list.remove(value);
		}
	}
}
/*
 * removeAll() 
 * clear() : java 8 
 */
/*
 *  a. 1 2 3 4 5
 *  b. UnsupportedOperationException 
 *  c. ConcurrentModificationException
 */
