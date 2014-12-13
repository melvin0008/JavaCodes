
import java.io.*;
import java.net.*;

public class server {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		try{
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			//Create Socket
			DatagramSocket serverSocket = new DatagramSocket(9876);
			//Receive from Client
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String( receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
			
			//Get Client Info
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			//Send To Client
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			System.out.println("Blah");
			serverSocket.close();
		}
		catch(Exception ex){
		}
	}
}
	
	
