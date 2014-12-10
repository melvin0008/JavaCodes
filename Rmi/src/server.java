package rmi;

import java.rmi.Naming;

public class server 
{
	public static void main(String[] args)
	{
		try
		{
			s_implements sim=new s_implements();
			Naming.rebind("Addserver", sim);
		}
		
		catch(Exception e)
		{
			System.out.println("Exception..");
		}
	}
		
}
