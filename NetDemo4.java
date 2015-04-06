package coreJavaDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

//TCP transmission, client and server both can send and receive message at the same time
//client end object Socket; Server end object ServerSocket

class TcpClient{
	public static void main(String[] args) throws Exception, IOException {
		
		//create client end socket
		Socket s= new Socket("127.0.0.1",8866);
		
		//to send message to server, get output stream of socket
		OutputStream out = s.getOutputStream();
		out.write("tcp message send".getBytes());
		
		//to receive message from server, get Input stream of socket; this part is not necessary if client only send, but not to receive message
		InputStream in = s.getInputStream();
		byte[] buff= new byte[1024];
		int len=in.read(buff);
		System.out.println(new String(buff,0,len));
		
		//close client socket
		s.close();

	}
}

//create server end to receive message and print it to console
class TcpServer{
	public static void main(String[] args) throws Exception {
		// construct server end bind it to a port
		ServerSocket ss = new ServerSocket(8866);
		
		//get the client object through accept()
		Socket s = ss.accept();
		String ip=s.getInetAddress().getHostAddress();
		
		//get the message send by client, through the client object's getInputStream()
		InputStream in = s.getInputStream();
		
		byte[] buff = new byte[1024];
		int len = in. read(buff);
		System.out.println(new String(buff, 0, len));
		
		//get Output stream to send feedback to client, this part is not necessary if server doesn't send message to client
		OutputStream out= s.getOutputStream();
		Thread.sleep(5000); //after received message from client, server waits 5 sec, then send feedback to client
		out.write("message received".getBytes());
		
		s.close();  //close client end
		ss.close();// close server
	}
}
public class NetDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
