import java.net.*;
import java.rmi.*;

public class SumClient {
	public static void main(String args[])
	{
		
		try {
			String sURL="rmi://"+args[0]+"SumServer";
			SumServerIntf sumintf=(SumServerIntf) Naming.lookup(sURL);
			System.out.println("The first number is:" + args[1]);
			int m=Integer.valueOf(args[1]);
			System.out.println("The second number is:" + args[2]);
			int n=Integer.valueOf(args[2]);
			int sum1=sumintf.sum(m, n);
			System.out.println(sum1);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}