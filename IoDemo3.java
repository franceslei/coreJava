package coreJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoDemo3 {

	public static void main(String[] args) throws IOException {
		// write with BufferedWriter
		FileWriter fw = new FileWriter("demo.txt");
		
		BufferedWriter buffw= new BufferedWriter(fw);
		
		buffw.write("aaaaaaaaa");
		buffw.newLine(); //start new line in windows as well as in linux, \r\n only work in windows  \n work in linux
		buffw.flush();
		buffw.close();//In fact, it closes filewriter.  so, don't have to add fw.close()
		
		
		//read with BufferedReader
		FileReader fr=new FileReader("demo.txt");
		
		BufferedReader buffr= new BufferedReader(fr);
		String line=null;
		while((line=buffr.readLine())!=null){
			System.out.println(line);
		}
		
		buffr.close();
		
	}

}
