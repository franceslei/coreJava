package coreJavaDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

public class NetDemo {

	public static void main(String[] args) throws Exception {
	/*	URL url= new URL("https://www.google.com");
		URLConnection u= url.openConnection();
		OutputStream out= u.getOutputStream();
		//?????out.write()
		*/
		
		DatagramSocket ds= new DatagramSocket(8888);
		byte[] data="UDP connection ".getBytes();
		DatagramPacket dp=new DatagramPacket(data,data.length,InetAddress.getByName("localhost"),10000);
		ds.send(dp);
		ds.close();
		//data lost because no receipt 
		
		/*
		 //insert the following code into another class with main(), to receive data and process data for UDP
		  DatagramSocket ds = new DatagramSocket(10000);  //this line should be outside while loop, otherwise will throw BindException
		  while(true){
		  byte[] buff=new byte[1024];
		  DatagramPacket dp=new DatagramPacket(buff,buff.length);
		  ds.receive(dp);
		  String ip=dp.getAddress().getHostAdress();
		  int port = dp.getPort();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+"::"+data+"::"+port)
			}
			//ds.close();
		  
		 */
	}

}
