package coreJavaDemo;

import java.io.File;

public class RecursionDemo {
	public static void print(Object obj){
		System.out.println(obj);
	}
	public static void main(String[] args) {
		showA();
		
		print("Sum="+sum(10));
		
		toBin(6);
	}
	
	//Demo shows the order of code execution in recursion
	public static void showA(){
		showB();
		print("AA");
	}
	public static void showB(){
		showC();
		print("BB");
	}
	public static void showC(){
		print("CC");
	}
	
	//get the sum of numbers 1 to n using recursion
	public static int sum(int n){
		if(n==1)
			return 1;
		else
			return n+sum(n-1);
	}
	
	//revise the method of toBin using recursion
	public static void toBin(int n){
		if(n>0){
			toBin(n/2);
			System.out.print(n%2);
		}  
	}
	
	//delete files has content, Be CAREFUL to invoke this method, because this can't undo, and it won't go through garbage collection
	public static void deleteFiles(File dir){
		File[] files = dir.listFiles();
		for(int x=0; x<files.length; x++){
			if(files[x].isDirectory())
				deleteFiles(files[x]);
			else
				files[x].delete();
		}
		dir.delete();
	}
}
