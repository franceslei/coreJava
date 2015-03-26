package coreJavaDemo;

public class ObjectDemo {    //java.lang.Object  is the root of the class hierarchy, it defines functions that all object have

	public static void main(String[] args) {
		Demo d1= new Demo();
		Demo d2= new Demo();
		Demo d3=d1;
		System.out.println(d1.equals(d2));  //equals() compare the addrr value of the object
		System.out.println(d1.equals(d3));
		
		Demo1 dd1= new Demo1(5);
		Demo1 dd2= new Demo1(5);
		System.out.println(dd1.equals(dd2));
		
		System.out.println(dd1.equals(d1));  //since equals() has been override, this line can be compiled but when run throws ClassCastException 
	// so in the equals(), should add code::: if (!(obj instanceof Demo1)) return false; or throw an error message.
	
		System.out.println(d1.toString());
		System.out.println(d1.hashCode());
		System.out.println(Integer.toHexString(d1.hashCode()));
		
		//getClass()   Class is defined to describe all class files.
		Class c = d1.getClass();
		System.out.println(c.getName());
	
	}

}

class Demo{
	
}

//Object has equals(), override equals() 
class Demo1{
	private int num;
	Demo1(int num){
		this.num=num;
	}
	public boolean equals(Object obj){  //override equals(Object obj) provided by super class Object
		if (!(obj instanceof Demo1))
			return false;
		Demo1 d = (Demo1)obj;  //
		return this.num==d.num;
		
	}
	
}