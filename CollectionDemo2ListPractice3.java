package coreJavaDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//store self-defined object into ArrayList, remove duplicate elements
//step1: describe a class for this object
//step2:define a container
//step3:get element


class Dog{
	private String name;
	private int age;
	Dog(String name, int age){
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean equals(Object obj){   //this equals() is method for Person
		if(!(obj instanceof Dog))
			return false;
		Dog p= (Dog)obj; //use Person's name and age, so need to cast obj to Person
		return this.name.equals(p.name) && this.age==p.age;  //this equals() is String's method 
	}
}

public class CollectionDemo2ListPractice3 {
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static List singleElement(ArrayList al){
		//define a temp arraylist
		ArrayList temp = new ArrayList();
		for(Iterator it=al.iterator(); it.hasNext();){
			Object obj=it.next();
			if(!temp.contains(obj)){
				temp.add(obj);
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add(new Dog("Lucy",28));
		al.add(new Dog("Lisa",25));
		al.add(new Dog("Lucy",28));
		al.add(new Dog("Emily",28));

		print(al); //print the addr of object new Person
		print(singleElement(al));
	}

}
