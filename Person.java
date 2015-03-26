package coreJavaDemo;

//Demonstrate the use of key word "this"

public class Person {
	  private String name;
	  private int age;
	  
	  Person(String name){
		  this.name=name;
	  }
	  
	  Person(String name, int age){
		//  this.name=name; //this line can be changed to this(name); the invoke between constructors
		  this(name);
		  this.age=age;
	  }
		
	  public void callName(){
    	System.out.println(name);
	  }
	  
	  public boolean compare(Person p){
		  return this.age==p.age;
	  }
    
}
    
class ThisDemo {
    	public static void main(String[] args) {
    		Person t = new Person("mmnnnn",79);
    		Person s= new Person("mmm", 79);
    		System.out.println(t.compare(s));
    		
    	}
    }
