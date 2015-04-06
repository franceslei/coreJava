package coreJavaDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


//operate file of images, use byte stream: super classes: InputStream for read; OutputStream for write
public class IoDemo4 {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo= new FileOutputStream("read.txt");
		
		fo.write("aaaaa".getBytes());   //don't need flush because no buffer used here.
		
		fo.close();
		
		FileInputStream fi = new FileInputStream("read.txt");
		
		//way one:  read one byte a time
		int ch=0;
		while((fi.read())!=-1){
			System.out.println((char)ch);
		}
		fi.close();
		
		//way two:  read to byte[]
		byte[] buff= new byte[1024];
		int len=0;
		while((len=fi.read(buff))!=-1){
			System.out.println(new String(buff,0,len));
		}
		fi.close();
		
		//way three:  special for byte stream to read: available(); if data is too big, use way two
		int num=fi.available();
		byte[]  buffer= new byte[num];
		fi.read(buffer);
		System.out.println(new String(buffer));
	}

}

// copy an image
class CopyImage{
	public static void main(String[] args){
		FileOutputStream fo= null;
		FileInputStream fi = null;
		
		try{
			fo=new FileOutputStream("c:\\1_copy.jmp");
			fi=new FileInputStream("c:\\1.jmp");
			
			byte[] buff= new byte[1024];
			
			int len=0;
			while((len=fi.read())!=-1){
				fo.write(buff,0,len);
			}
		}
		catch(IOException e){
			throw new RuntimeException("copy file failed");
		}
		finally{
			try{
				if(fi!=null)
					fi.close();
			} catch(IOException e){
				throw new RuntimeException("close fi failed");
			}
			try{
				if(fo!=null)
					fo.close();
			} catch(IOException e){
				throw new RuntimeException("close fo failed");
			}
		}
	}
}

//copy mp3, use buffer:  BufferedOutputStream, BufferedInputStream, remember to flush after write
class copyMp3{
	public static void main(String[] args) throws IOException{  //should try catch
		
	long start=System.currentTimeMillis();
	
	BufferedOutputStream buffero= new BufferedOutputStream(new FileOutputStream("c:\\0_copy.mp3"));
	BufferedInputStream bufferi = new BufferedInputStream(new FileInputStream("c:\\0.mp3"));
	
	int len=0;
	while((len=bufferi.read())!=-1){
		buffero.write(len);
	}
	buffero.close();
	bufferi.close();
	
	long end=System.currentTimeMillis();
	System.out.println((end-start)+"mSec");
	
	}
}


//define  a class MyBufferedInputStream a decorator of InputStream
class MyBufferedInputStream{
	private InputStream in;
	private byte[] buff= new byte[1024];
	private int pos=0, count=0;
	MyBufferedInputStream(InputStream in){
		this.in=in;
	}
	public int myRead() throws IOException{
		if(count==0){
		count=in.read(buff);
		pos=0;
		byte b=buff[pos];
		count--;
		pos++;
		return b&255;    //&255 or &0xff to avoid read byte -1, return int -1, the loop will break, copy will failed.
		} else if(count>0){
			byte b=buff[pos];
			count--;
			pos++;
			return b&255;
		}
		return -1;
	}
	public void myClose() throws IOException{
		in.close();
	}
}
