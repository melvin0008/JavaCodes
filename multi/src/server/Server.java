package server;

import java.io.*;
import java.net.*;

public class Server
{	
	ServerSocket ss;
	
	public Server()
	{	ServerSocket ss=null;
		try
		{
			ss=new ServerSocket(9999);
		}
		catch(IOException ex)
		{
			System.out.println("Could not create");
			System.exit(-1);
		}
		
		System.out.println("Listening...");
		
		int id=0;
		while(true)
		{
			try
			{
				Socket sock=ss.accept();
				
				//start service thread
				ClientServiceThread cst=new ClientServiceThread(sock,id++);
				cst.start();
			}
			
			catch(IOException exp)
			{
				System.out.println("Could not accept");
			}
		}
	}

	public static void main(String args[])
	{	
		new Server();
	}
	
	class ClientServiceThread extends Thread
	{
		Socket cs;
		int cs_id;
		boolean cs_run=true;
		
		ClientServiceThread(Socket s, int clientid)
		{
			cs=s;
			cs_id=clientid;
		}
		
		public void run()
		{
			BufferedReader br=null;
			PrintWriter pr=null;
			
			System.out.println("Client: " + cs_id+"\nAddress: " + cs.getInetAddress().getHostName());
			
			try
			{
				br=new BufferedReader(new InputStreamReader(cs.getInputStream()));
				pr=new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
				
				while(cs_run)
				{
					String msg=br.readLine();
					
					System.out.println("Client msg : " + msg);
					
					if(msg.equalsIgnoreCase("exit"))
					{
						System.out.println("End " +cs_id);
						cs_run=false;
					}
					else
					{
						pr.println(msg);
						pr.flush();
					}
				}
			}
			
			catch(Exception ex)
			{
				System.exit(-1);
			}
			
			finally
			{
				try
				{
					br.close();
					pr.close();
					cs.close();
					ss.close();
					System.out.println("Exit");
				}
				
				catch(IOException ioex)
				{
					System.out.println("Exception...");
				}
			}
			
		}
	}
}