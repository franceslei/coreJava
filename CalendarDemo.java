package coreJavaDemo;

import java.util.Calendar;

public class CalendarDemo {
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		print(c.get(Calendar.YEAR));
		
		c.set(2011,2,23);
		print(c.get(Calendar.YEAR));
		
		c.add(Calendar.YEAR, 6);
		print(c.get(Calendar.YEAR));
	}

}
