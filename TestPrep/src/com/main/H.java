package com.main;

public class H {
	public static void main(String[] args) {

	}
}

interface Inter{
	//int x; <-- line 2 not initialized 
	
	int x=4; //final and static and public 
	
	void m1(); //public abstract 
}

________ class Sub implements Inter{} 
	
/*
a. final
b. public 
c. static
d. abstract  -- ANS
e. None of the above 
*/


class Sub1 implements Inter{
	/*
	 * HERE 
	 */
}

/*
a. void m1() {}
b. public void m1() {}
c. private void m1(){}
d. void m1(int x){ }
*/

/*
 * Git - 4, Agile-3, Maven -3, JUnit: 10, and Java: 30 (part-2) / part-1 
 */








