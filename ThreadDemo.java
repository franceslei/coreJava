package coreJavaDemo;

public class ThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Lf l1= new Lf("thread-1");
		Lf l2= new Lf("thread-2");
		l2.setPriority(10);
		l1.start();
		l2.start();
		System.out.println(l1.isAlive());


	}

}


class Fang implements Runnable{
	
	public void run(){
		System.out.println("Fang is running");
	}
	
}

class Lf extends Thread{
	private String name;
	
	Lf(String threadname){
		name=threadname;
	}
	
	public void run(){
		System.out.println("Currently running: "+name);
	}
	
}