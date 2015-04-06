package coreJavaDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy E hh:mm:ss");
		
		System.out.println(sdf.format(d));

	}

}
