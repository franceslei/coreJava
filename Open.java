package coreJavaDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Open {

	public static void main(String[] args) throws IOException {
		URL ur = new URL("http://www.google.com/");
	    HttpURLConnection yc =(HttpURLConnection) ur.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	    String inputLine;
	    while ((inputLine = in.readLine()) != null) 
	    System.out.println(inputLine);
	    in.close();
	}

}
