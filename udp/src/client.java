

import java.io.*;
import java.net.*;

public class client 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try{
			byte[] sendData = new byte[1024];   
			byte[] receiveData = new byte[1024];
			
			//Socket Creation and IP address
			DatagramSocket clientSocket = new DatagramSocket(); 
			InetAddress IPAddress = InetAddress.getByName("localhost");
			
			// Input to Client
			System.out.println("Please Enter Data: ");
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			String sentence = inFromUser.readLine();
			
			//Send to Server
			sendData = sentence.getBytes();    
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876); 
			clientSocket.send(sendPacket);  
			
			//Receive from Server
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);     
			String modifiedSentence = new String(receivePacket.getData());    
			System.out.println("FROM SERVER:" + modifiedSentence);
			clientSocket.close();
		}
		catch(Exception e){
		}
	}
}
