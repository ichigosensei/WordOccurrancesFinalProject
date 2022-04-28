package DeploymentAssignment;

import java.io.*;
import java.net.*;
public class Server {
	
   public static String isPrime(int userInput) {
	   
       if(userInput < 2) {
           
    	   return "No";
       }
       
       int calcVal = 2;
       
       while(calcVal < userInput) {
           
    	   if(userInput % calcVal == 0) {
               return "No";
               
           }  calcVal++;
           
       } return "Yes";      
   }
   
   public static void main(String[] args) {
       
	   try {
           
		   ServerSocket socketConn = new ServerSocket(8080);
           
           Socket serverSocket = socketConn.accept();
           DataInputStream serverInput = new DataInputStream(serverSocket.getInputStream());
           DataOutputStream serverOutput = new DataOutputStream(serverSocket.getOutputStream());

           int num = (int)serverInput.readInt();
         
           serverOutput.writeUTF(isPrime(num));
           serverOutput.flush();

           serverOutput.close();
           socketConn.close();
           
       } catch(Exception y) {
           
    	   System.out.println(y);
       }
   }
}
