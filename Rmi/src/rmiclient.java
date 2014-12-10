package rmi;

import java.rmi.Naming;
import java.lang.String;

class Divexception extends Exception
{
	Divexception(String msg)
	{
		super(msg);
	}
}

public class rmiclient {

	public static void main(String[] args)
	{
		try
		{
			String s_url="rmi://"+args[0]+"/Addserver";
			sinterface s_int=(sinterface)Naming.lookup(s_url);
			
			String op=args[2];
			
			System.out.println("Enter first number: "+args[1]);
			double n1=Double.valueOf(args[1]).doubleValue();
			
			System.out.println("Enter second number: "+args[3]);
			double n2=Double.valueOf(args[1]).doubleValue();
			
			if(op.equalsIgnoreCase("+"))
				System.out.println("Addition is : "+s_int.add(n1, n2));
			
			else if(op.equalsIgnoreCase("-"))
				System.out.println("Subtraction is : "+s_int.sub(n1, n2));
			
			else if(op.equalsIgnoreCase("*"))
				System.out.println("Multiplication is : "+s_int.mul(n1, n2));
			
			else if(op.equalsIgnoreCase("/"))
			{
				if(n2==0)
					{
						Divexception de=new Divexception("Cannot divide by zero");
						throw de;
					}
				else
					System.out.println("Division is : "+s_int.div(n1, n2));
			}
			
			else
				System.out.println("Invalid");
		}
		
		catch(Exception e)
		{
			System.out.println("Exception...");
		}
	}
}
