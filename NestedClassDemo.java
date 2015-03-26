package coreJavaDemo;

public class NestedClassDemo {

	public static void main(String[] args) {
		new Outer().method();
		new Outer().new Inner().function();  //this is not common since nested classes are usually private and can't create an instance
		Outer.Inner in= new Outer().new Inner();
		in.function();

	}

}


class Outer{
	private int x=3;
	void method(){
		System.out.println(x);
		Inner in=new Inner();
		in.function();
	}
	
	//declare a nested class, the same way as regular class
	class Inner{
		int x=4;
		void function(){
			int x=6;
			System.out.println("Inner:"+x); //print x=6
			System.out.println("Inner:"+this.x); //print x=4
			System.out.println("Inner:"+Outer.this.x);  //print x=3, add code Outer.this. in front of x
		}
		
	}
}

class Outer2{
	int x=0;
	void method(){
		class Inner{ // this inner class is local, cann't be declared as static or private
			void function(){ //this function cann't be static because the Inner calss cann't be static
				
			}
		}
	}
}


// the following code demonstrate anonymous nested class

abstract class AbsDemo{
	abstract void show();
}

class Outer_3{
	int x=9;
	public void function(){
		new AbsDemo(){
			void show(){
				System.out.println(x);
			}
		//	void abc(){
		//		System.out.println('a');
		//	}
		}.show(); //.abc()      !!! can't invoke both show() and abc()
	}
}

//The following is for practice
interface Inter{
	void method();
}

class Test{
	static Inter function(){
		return new Inter(){
			public void method(){
				System.out.println('a');
			}
		};
	}
}

class InnerClassTest{
	public static void main(String[] args){
		// Test.function(), Test class has a static method called function; .method, the result of function() should be an object of class Inter
		//because method() can only be invoked by an object of Inter or its sub-class
		//Inter in= Test.function(); in.medthod();
		Test.function().method();   //based on this line, add code to class Test to complete the program
	
	show(new Inter(){
		public void method(){
			System.out.println('b');
		}
	});   // anonymous nested class as a parameter input in show(Inter in)
	
	new Object(){  //create instance of sub-class of Object
		public void function(){
			
		}
	}.function();
	}
	public static void show(Inter in){
		in.method();
	}
}