package coreJavaDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//methods in class Writer
public class IoDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("Demo.txt");  //Demo.txt will be created, if already exists will be replaced 
		//FileWriter fw = new FileWriter("Demo.txt", true);  continue writing
		
		fw.write("aaaaaaaa");    //data written into stream 
		fw.flush();
		
		fw.write("bbb\r\nbbbb");  //\r\n start a new line for windows
		fw.flush();
		
		fw.write("ccccc");
		fw.close();  //flush before close stream, can't write after steam closes.		
		
		
		FileReader fd = new FileReader("Demo.txt");
		
		int ch = 0;    //read character by character
		while((ch=fd.read())!=-1){
			System.out.println((char)ch);
		}
		
		char[] buff = new char[1024];  //another way of read
		int num = 0;
		while((num=fd.read(buff))!=-1);{
		System.out.println(new String(buff,0,num));
		}
		fd.close();
		
		//read a file and print to console
		FileReader fr = new FileReader("MapDemo.java");
		char[] buff1= new char[1024];
		int num1=0;
		while((num1=fr.read(buff1))!=-1){
			System.out.print(new String(buff1,0,num1));  //use print instead of println, otherwise, when the file>1024, it will start on a new line
		}
	}
}

//The standard way to handle IOException 
class DealException{
	public static void main(String[] args){
		FileWriter fw = null; 
		try{
			fw = new FileWriter("Exception.txt");
			fw.write("abcdefg");
		}
		catch(IOException e){
			System.out.println("Error: "+e.toString());
		}
		finally{
			try{
				if(fw!=null)
					fw.close();
			}
			catch(IOException e){
				System.out.println("Error close: "+e.toString());
			}
		}
		
	}
}