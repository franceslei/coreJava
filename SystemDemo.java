package coreJavaDemo;

import java.util.Properties;

//all members in class System are static


public class SystemDemo {

	public static void main(String[] args) {
		// set property fot the system
		System.setProperty("key","value");
		
		Properties prop=System.getProperties();
	//Properties is sub-clas of Hashtable, which is sub-class of Map
		for(Object obj : prop.keySet()){
			String value=(String)prop.get(obj);
			System.out.println(obj+"::"+value);
		}
		
	}
}
