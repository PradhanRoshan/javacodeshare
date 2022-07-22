package com.main;

public class F {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {1,2,3,4,5};
		
		//Integer[] arr1 = new Integer[-4]; //NegativeArraySizeException
		
		//System.out.println(arr[100]);//ArrayIndexOutOfBoundsException
		
		/*
		 * How many objects(How many locations) are used by JVM/Compiler/Program to 
		 * store array arr.  
		 */
		 
		String[] str = new String[5]; //100X : 200X(a): 300X(b): 400X : 500X: 600X(e)
		str[0] = "a"; 
		str[1] = "b"; 
		str[2] = "c"; 
		str[3] = "d"; 
		str[4] = "e"; 
		 
		str=new String[3]; 
		
		System.out.println(str[1]); //null
	}
}
/*
 * a. 5
 * b. 1
 * c. 6 (yes)
 * d. 0
 */
