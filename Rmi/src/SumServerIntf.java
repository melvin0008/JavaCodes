import java.rmi.*;

public interface SumServerIntf extends Remote {
	int sum(int a,int b) throws RemoteException;
}
