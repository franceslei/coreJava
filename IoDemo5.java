package coreJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class IoDemo5 {

	public static void main(String[] args) throws IOException {
		
		InputStream in= System.in;
		
	//	int input= in.read();
	//	System.out.println(input);
		
		
	/*	StringBuilder sb= new StringBuilder();
		while(true){   //program won't stop unless type in "over" or press Ctrl+c
			int ch=in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n'){
				String s = sb.toString();
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());
				sb.delete(0, sb.length());   //have clear sb after print out
			} else
				sb.append((char)ch);
		}             */
		
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader buff= new BufferedReader(isr);
		// BufferedReader buff= new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=buff.readLine())!=null){
			if("over".equals(line))
				break;
			System.out.println(line.toUpperCase());
		}
		
			
		
		OutputStream out = System.out;
		OutputStreamWriter ows= new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(ows); //in order to use newLine()
	//	BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String line1=null;
		while((line1=buff.readLine())!=null){
			if("over".equals(line1))
				break;
			bufw.write(line1.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		
		buff.close();
	}

}
