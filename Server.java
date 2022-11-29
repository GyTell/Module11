//Module 11 Glenney 11/28/2022

import java.io.*;
import java.net.*;
public class Server {

	public static String prime(int number) {
//code to distinguish if number is prime with "if" and "while" commands 		
		if(number<2) {return "No";
			}
			int i=2;  
			while(i<number) {
				if(number%i==0) {return "No";
				}
				i++;
				}
			return "Yes";
}
//Main 	
	public static void main(String[] args){
		
		try{
//Socket needed for connection			
			ServerSocket server=new ServerSocket(8080);
			Socket sock= server.accept();
//Two data input streams needed
DataInputStream one=new DataInputStream(sock.getInputStream());
DataOutputStream two=new DataOutputStream(sock.getOutputStream());
// Number value read
//source:https://www.javatpoint.com/java-datainputstream-readutf-method
	int number = (int)one.readInt();

	two.writeUTF(prime(number));
// Close operations	
	two.flush();
	two.close();
	server.close();
}
//catch exception		
catch(Exception e){
System.out.println(e);
}
}
}