package rmi;

import java.rmi.*;

public interface sinterface extends Remote
{
	double add(double n1, double n2) throws RemoteException;
	double sub(double n1, double n2) throws RemoteException;
	double mul(double n1, double n2) throws RemoteException;
	double div(double n1, double n2) throws RemoteException;
}
