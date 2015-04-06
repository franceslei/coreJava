package coreJavaDemo;

public class MathDemo {
	
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		double d= Math.ceil(8.9);  //Returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument and is equal to a mathematical integer.
		print(d);
		
		double d1=Math.floor(12.8);
		print(d1);
		
		double d2=Math.round(14.56);
		print(d2);
		
		double d3=Math.random();  //equivalent to class java.util.Random
		print(d3);
	}
	
	public int lastTwoDigit(double d){
		int i=(int)d;
		Math.log10(d);
		return 0;
	}

}
