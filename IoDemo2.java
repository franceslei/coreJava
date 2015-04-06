package coreJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//copy files 
public class IoDemo2 {

	public static void main(String[] args) throws IOException {
		copyMethod1();
		copyMethod2();
	}
	
	//read 1024, then write, fast, with standard exception handling process
	public static void copyMethod2(){
		FileWriter fw = null;
		FileReader fr = null;
		
		try{
			fw = new FileWriter("IoDemo_copy.java");
			fr = new FileReader("IoDemo.java");
		
			char[] ch = new char[1024];
			int len=0;
			while((len=fr.read(ch))!=-1){
			fw.write(ch, 0, len);
			}
		} catch(IOException e){
			throw new RuntimeException("read and write failed");
		} finally{
			if(fw!=null){
				try{
					fw.close();
				} catch(IOException e){
					
				}
			}
			if(fr!=null){
				try{
					fr.close();
				} catch(IOException e){
					
				}
			}
					
		}
	}
	
	//read one write one, very slow
	public static void copyMethod1() throws IOException{  //should use try catch 
		FileWriter fw = new FileWriter("IoDemo_copy.java");
		FileReader fr = new FileReader("IoDemo.java");
		
		int ch = 0;
		while((ch=fr.read())!=-1){
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
	
}


//copy file use BufferedReader and BufferedWriter
class CopyFile{
	public static void main(String[] args){
		BufferedReader buffr=null;
		BufferedWriter buffw=null;
		
		try{
			buffr=new BufferedReader(new FileReader("IoDemo.java"));
			buffw=new BufferedWriter(new FileWriter("IoDemo_copy.java"));
			
			String line = null;
			while((line=buffr.readLine())!=null){
				buffw.write(line);
				buffw.newLine();
				buffw.flush();
			}
		}
		catch(IOException e){
			throw new RuntimeException("read and write failed");
		}
		finally{
			try{
				if(buffr!=null)
					buffr.close();
			} catch(IOException e){
				throw new RuntimeException("read close failed");
			}
			try{
				if(buffw!=null)
					buffw.close();
			} catch(IOException e){
				throw new RuntimeException("write close failed");
			}
		}
	}
}