// Module 11 Glenney Tello 11/28/2022

// imports needed to run code, .net is needed for the server socket

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try{
// Must create socket for server connection			
			Socket server=new Socket("localhost",8080);
// Two data Streams to go between	
		DataInputStream one=new DataInputStream(server.getInputStream());
		DataOutputStream two=new DataOutputStream(server.getOutputStream());
// Ask user for input
		System.out.print("Number is: ");
		int number = scan.nextInt();
// crossing into server
//source:https://www.javatpoint.com/java-datainputstream-readutf-method
        two.writeInt(number);
        String input = (String)one.readUTF();
        System.out.println("Number "+number+" is prime: "+ input);
//Must close everything or error appears stating server is not closed		
					two.flush();
					two.close();
					server.close();
}
//Must catch exception
		catch(Exception e){
		System.out.println(e);
}
//Finally remember to close scan
		scan.close();
}
}
