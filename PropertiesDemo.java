package coreJavaDemo;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		
		Properties prop= new Properties();
		prop.setProperty("keya", "valuea");
		prop.setProperty("keyb", "valueb");
		
		print(prop);
		
		print(prop.getProperty("keya"));
		
		Set<String> names=prop.stringPropertyNames();
		for(String s: names)
			print(s);
		
		//method one:  read a txt based configuration file  with key-value pairs
		BufferedReader buffr= new BufferedReader 
	}

}
