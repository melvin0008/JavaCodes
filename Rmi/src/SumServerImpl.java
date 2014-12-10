import java.rmi.*;
import java.rmi.server.*;


public class SumServerImpl extends UnicastRemoteObject implements SumServerIntf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SumServerImpl() throws RemoteException {
		
	}
	public int sum(int a,int b) throws RemoteException
	{
		int result;
		result=a+b;;
		return result;
	}
	
}
