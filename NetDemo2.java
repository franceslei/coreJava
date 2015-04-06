package coreJavaDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

class UdpSend {
	public static void main(String[] args) throws IOException{
		DatagramSocket ds=new DatagramSocket();
		BufferedReader buffr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=buffr.readLine())!=null){
			if("886".equals(line))
				break;
			byte[] buf=line.getBytes();
			DatagramPacket dp=new DatagramPacket(buf,buf.length,InetAddress.getByName("localhost"),10000);
			ds.send(dp);													//or use ip xxx.xxx.xxx.xxx, xxx.xxx.xxx.255 is broadcast ip, can be used for group chat
		}
		ds.close();
	}

}





class UdpReceiv{
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket(10000);
		while(true){
			byte[] buff= new byte[1024];
			DatagramPacket dp = new DatagramPacket(buff,buff.length);
			ds.receive(dp);
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+"::"+data);
		}
	}    //no close() in receive end
}