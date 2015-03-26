package coreJavaDemo;

//This one is to learn the key word "static", when and how to use static

class People{
	String name;  // name is member variable, or instance variable
	static String country="cn";  // country is static member variable, or class variable 
	public void show(){   //this method uses non-static member "name", so it can't be static
		System.out.println(name+"::::"+country);
	}
	
	public static void showcountry(){ //this method doesn't use any non-static member, so it can be static, it can also be non-static
		System.out.println("haha");
		System.out.println(country);
	}
}

public class StaticDemo {

	public static void main(String[] args) {
		// invoke static method in class People
		People.showcountry();
		
		
		// create an object instance
		People p = new People();
		p.name="zhangshan";
		
		// create an object, then the object invoke static member-- country
		p.show();
		
		// use class name to invoke static member
		System.out.println(People.country);
		
		// find out what String[] did JVM input when it invokes main() method
		// it prints out "[Ljava.lang.String;@15db9742", which means JVM didn't input null (null doesn't have hash address) but input a instance String[]
		System.out.println(args);
		
		//find out the length of the String[] that JVM input when invoking main()
		//it prints out 0, which means what JVM input is new String[0] when invoking main()
		System.out.println(args.length);
		
		
		//to create an array, then invoke the main() in the class of MainDemo
		String[] arr = {"haha","hehe","heihei"};
		//since main() is static, so it can be invoked by its class name.
		MainDemo.main(arr);
		
		}
			
		
	
	// demonstrate main() method
	//this method overrides main(String[] args), it can exists, but JVM cann't recognize it as the entrance of program
	public static void main( int x){
		
	}
	
	//This method also overrides main(String[] args).
	public static void main(String[] args, int x){
		
	}
	
/*   // This is a valid main() that JVM recognize, args is the only place that can be changed
	public static void main(String[] x){
		
	}
*/
}

// This main() can be invoked by another main() in the class above (class StaticDemo)
class MainDemo{
	public static void main(String[] args){
		for(int x=0; x<args.length; x++){
			System.out.println(args[x]);
		}
	}
}



// The following code (class StaticBlock and class StaticBlockDemo) is to demonstrate the use of static block
class StaticBlock{
	static{
		System.out.println('a');
	}
	
	public static void show(){
		System.out.println("show run");
	}
}

class StaticBlockDemo{
	static{
		System.out.println('b');
	}
	public static void main(String[] args){
		StaticBlock.show(); //class invoke static method, the class is loaded, so static block will be executed
		new StaticBlock(); // when instance is created, the class will be loaded, so static block will be executed
		new StaticBlock();
		System.out.println("over");
		StaticBlock s=null;  // when s=null, the class StaticBlock will not be loaded into memory, so the static block will not be executed
	}
	static{
		System.out.println('c');
	}
}



//The following code demonstrate static block, constructor block, and constructor
class Code{
	int num=9;
	Code(){   //This is constructor without parameter, to initialize an object without parameter
		System.out.println("aaaa");
	}
	
	Code(int x){   //This is constructor with parameter int x, to initialize an object with int x parameter
		System.out.println("bbbbb");
	}
	
	static{  //This is static block, to initialize class
		System.out.println("cccccc");
	}
	
	{   //The is constructor block, to initialize an object
		System.out.println("ddddd"+num/* or this.num*/);
	}
}

class InvokeCode{
	public static void main(String[] args){
		new Code(5);
	}
}