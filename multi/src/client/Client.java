package client;


import java.net.*;
import java.io.*;

// A client for our multithreaded EchoServer.
public class Client
{
    public static void main(String[] args)
    {
         String abc=" ";
	//	String ans=" ";
		String host="";
        
		// First parameter has to be machine name
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
			host=in.readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		/*if(args.length == 0)
        {
            System.out.println("Usage : EchoClient <serverName>");
            return;
        }*/
        
        Socket s = null;
        
        // Create the socket connection to the EchoServer.
        try
        {
            s = new Socket(host,9994);
        }        
        catch(UnknownHostException uhe)
        {
            // Host unreachable
            System.out.println("Unknown Host :" + args[0]);
            s = null;
        }
        catch(IOException ioe)
        {
            // Cannot connect to port on given host
            System.out.println("Cant connect to server at 12111. Make sure it is running.");
            s = null;
        }
        
        if(s == null)
            System.exit(-1);
        
        BufferedReader in1 = null;
        PrintWriter out = null;
        
        try
        {
            // Create the streams to send and receive information
            in1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
          //  int i=1;
            do
			{
			
			System.out.println("Enter the comment:");
			BufferedReader dis=new BufferedReader(new InputStreamReader(System.in));
			abc= dis.readLine();
			out.println(abc);
			out.flush();
            // receive a reply.
            System.out.println("Server Says : " + in1.readLine());
			//i++;		
			}
			while (!abc.equalsIgnoreCase("quit"));	
		   
           }
        catch(IOException ioe)
        {
            System.out.println("Exception during communication. Server probably closed connection.");
        }
        finally
        {
            try
            {
                // Close the streams
                out.close();
                in1.close();
                // Close the socket before quitting
                s.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }                
        }        
    }
} 
