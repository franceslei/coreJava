package coreJavaDemo;

public class RuntimeDemo {

	public static void main(String[] args) throws Exception {
		Runtime r=Runtime.getRuntime();
		Process p=r.exec("notepad.exe SystemDemo.java");  // can run any program  and the program associated files
		
		Thread.sleep(4000);
		p.destroy();
	}

}
