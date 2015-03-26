package coreJavaDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		//create an instance of HashMap
		Map<String, String> map = new HashMap<String,String>();
		
		//add elements
		System.out.println(map.put("01", "aaaaaaa")); // put() returns the value before value is added, for this one, no value before"aaaaaaa"added, so return null
		map.put("02", "bbbbb");
		map.put("03", "ccccccc");
		map.put(null, "ddddd");
		
		//does map contains a specific key
		System.out.println("containsKey: "+map.containsKey("02"));
		
		//remove elements and print map
		System.out.println("remove: "+map.remove("03"));
		System.out.println(map);
		
		//get a value associated with a key
		System.out.println("get: "+map.get("01"));
		
		//get all values in map, values()
		Collection<String> cl= map.values();
		System.out.println(cl);
		
		//get all keys in map, keySet(), store all keys in a set, set has iterator, can get all keys, then use get() get the value to every key
		Set<String> keyset = map.keySet();
		System.out.println(keyset);
		Iterator<String> it = keyset.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = map.get(key);
			System.out.println("Key: "+key+", Value: "+value);
		}
		
		//get the relationship in map, entrySet(), stores all relationship as Map.Entry type in a set, use iterator get each Map.Entry, then 
		//Map.Entry.getKey(), Map.Entry.getValue();
		 Set<Map.Entry<String, String>> entryset= map.entrySet();
		 Iterator<Map.Entry<String, String>> iten = entryset.iterator();
		 while(iten.hasNext()){
			 Map.Entry<String, String> me = iten.next();
			 String keyen = me.getKey();
			 String valueen=me.getValue();
			 System.out.println("Key is: "+keyen+", value is: "+valueen);
		 }
	    
	}

}



//The following is the application of map, exercise
//describe a class of student, with name and age. define map, to store student and his/her address
//students with same name and age are duplicates, make sure no duplicates in the map
//get the  elements in this map
class Student implements Comparable<Student>{  //describe student
	private String name;
	private int age;
	Student(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	public int compareTo(Student s){     //implements Comparable and overrides compareTo() when the data stored in map may be red-black tree
		//if it needs to sort key, the data should be stored as TreeMap
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	
	
	//overrides hashCode() and equals(), when the data stored in map is hashtable
	public int hashCode(){   //override hashCode() to make sure no duplicate students
		return name.hashCode()+age*34;  // what is this?????
	}
	public boolean equals(Object obj){  //override equals() to make sure the type of input data is Student
		if(!(obj instanceof Student))
			throw new ClassCastException("imcopatable data type");
		Student s =(Student)obj;
		return this.name.equals(s.name) && this.age==s.age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge(){
		return age;
	}
	public String toString(){
		return name+": "+age;
	}

}
