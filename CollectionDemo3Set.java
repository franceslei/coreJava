package coreJavaDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//self-define class Cat, store cat in HashSet, the same name and age means duplicate elements
class Cat{
	private String name;
	private int age;
	Cat(String name, int age){
		this.name=name;
		this.age=age;
	}
	public int hashCode(){    //this line executed, all objects get the hashcode 60, then equals() will be executed
	//	return 60;    //with the same hashcode, objects will compare more times
		//same name and age will return same hashcode value; other wise the value only be the same.
		return name.hashCode()+age*25;  //25 can be any number, but not to be too small or too big.
	}
	public boolean equals(Object obj){ //this won't be executed if hash code is not the same, because different hash  code means different object
		if(!(obj instanceof Cat))
			return false;
		Cat c= (Cat)obj;
		return this.name.equals(c.name) && this.age==c.age;
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
}

//self-defined class Employee, store in TreeSet;
class Employee{
	private String name;
	private int age;
	Employee(String name, int age){
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
}

public class CollectionDemo3Set {
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		print(hs.add("111"));     //add() returns boolean value, if element exists return false, other wise add the element and return true
		print(hs.add("111"));
		hs.add("2222");
		hs.add("3333");
		hs.add("4444");
		hs.add("3333");
		for(Iterator it=hs.iterator(); it.hasNext();){
			print(it.next());
		}	
		HashSet s = new HashSet();
		s.add(new Cat("lily",2));
		s.add(new Cat("lily",2));
		s.add(new Cat("lily",5));
		s.add(new Cat("luly",3));
		s.add(new Cat("lisa",3));
		s.add(new Cat("li",5));
		for(Iterator it=s.iterator(); it.hasNext();){
			Cat c=(Cat)it.next();
			print(c.getName()+"...."+c.getAge());	
		}
		print(s.contains(new Cat("lily",2)));
		print(s.remove(new Cat("lily",2)));
		
		
		//The following demonstrate TreeSet
		TreeSet ts= new TreeSet();
		ts.add("aa");
		ts.add("dd");
		ts.add("AA");
		ts.add("bb");
		ts.add("cc");
		for(Iterator it=ts.iterator(); it.hasNext();){
			print(it.next());     //TreeSet prints out in alphabetical order
		}
		
		//TreeSet store Employee, sort according to age
		TreeSet<Employee> t= new TreeSet<Employee>();
		t.add(new Employee("mike",25));
		t.add(new Employee("mary",28));        //when add the second element, since TreeSet has order, compareTo() will be executed, throw ClassCastException, if didn't declare TreeSet<Employee>
		t.add(new Employee("joe",32));        //or do not declare TreeSet<Employee>, but in class Employee, let Employee implements Comparable, override compareTo()
		t.add(new Employee("joe",25));
		for(Iterator<Employee> it=t.iterator(); it.hasNext();){
			print(it.next());
		}

	}

}
