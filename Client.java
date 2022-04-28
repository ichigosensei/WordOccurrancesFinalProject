package DeploymentAssignment;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   
	public static void main(String[] args) {
        //Creating the scanner
		Scanner client = new Scanner(System.in);
       
		try {
			//Creating the socket connection
			Socket socketConn = new Socket("localhost", 8082);
			DataInputStream scanInput = new DataInputStream(socketConn.getInputStream());
			DataOutputStream scanOutput = new DataOutputStream(socketConn.getOutputStream());
			
			//Getting user input
			System.out.println("Welcome to the Prime Number Calculator!");
			System.out.print("\nPlease enter a number : ");
          
			int userInput = client.nextInt();

			//Calculates input's value if prime or not then prints out
			scanOutput.writeInt(userInput);
			String calculatedValue = (String)scanInput.readUTF();
			System.out.println("\nIs "+ userInput +
                               " a prime number? "+ calculatedValue);
			scanOutput.flush();
			scanOutput.close();
			socketConn.close();
}
       catch(Exception y) {
           
    	   System.out.println(y);
    	   
       }	client.close();
   }
}


