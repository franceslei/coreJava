package coreJavaDemo;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Compare{
	boolean myCompare(int a, int b);
}

interface Compare1{
	int myCompare(int a, int b);
}

public class Lambda {
	
	
	public static void main(String[] args) {
		Compare compare= (a,b)->a>b;
		boolean result=compare.myCompare(6, 9);
		System.out.println(result);
		
		Compare1 compare1=(a,b)->a+b;
		System.out.println(compare1.myCompare(19, 20));

	}
	
	// Runnable r=()->System.out.println("lambda expression signed to runnable")
	
	// new Thread(()->System.out.println("an instance of Runnable")).start();
	
	List<Integer> list= Arrays.asList(4,6,7,9,45);
	list.forEach(n -> System.out.println(n));  //what error??
}
