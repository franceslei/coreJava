package coreJavaDemo;

public class AnonymousClassDemo {
	int num;
	public static void main(String[] args) {
		new AnonymousClassDemo().num=5;  //value disappear after this line executed
		
		new AnonymousClassDemo().run();
		replaceCar(new Car());  //anonymous object input as parameter
	}
	
	public void run(){
		System.out.println("run");
	}
	
	
	//anonymous object as parameter
	public static void replaceCar(Car c){
		c.num=3;
		c.color="black";
		c.run();
	}

}

class Car{
	int num=4;
	String color;
	public void run(){
		
	}
	
}
