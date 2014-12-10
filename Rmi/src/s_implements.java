package rmi;

import java.rmi.*;
import java.rmi.server.*;

public class s_implements extends UnicastRemoteObject implements sinterface
{

	public s_implements() throws RemoteException {
		//super();
		// TODO Auto-generated constructor stub
	}

	public double add(double n1, double n2) throws RemoteException
	{
		System.out.println("Addition of "+ n1 + "and " + n2 + "is "+ (n1+n2));
		return n1+n2;
	}
	public double sub(double n1, double n2) throws RemoteException
	{
		System.out.println("Subtracting "+ n2 + "from " + n1 + "we get "+ (n1-n2));
		return n1+n2;
	}
	public double mul(double n1, double n2) throws RemoteException
	{
		System.out.println("Multiplication of "+ n1 + "and " + n2 + "is "+ (n1*n2));
		return n1+n2;
	}
	public double div(double n1, double n2) throws RemoteException
	{
		System.out.println("Dividing "+ n1 + "by " + n2 + "we get "+ (n1/n2));
		return n1+n2;
	}
}
