

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
	private int cnt;
    @Override
    public String sayHello() throws RemoteException {
		cnt++;
		System.out.println(cnt);
        return "Server says, 'Hey";
    }

    MyRemoteImpl() throws RemoteException {
		cnt = 0;
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
