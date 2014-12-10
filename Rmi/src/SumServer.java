

import java.net.MalformedURLException;
import java.rmi.*;


public class SumServer {
	
	public static void main(String args[])
	{
		try {
			SumServerImpl sumimpl=new SumServerImpl();
			Naming.rebind("SumServer", sumimpl);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
