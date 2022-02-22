import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class LancerServeur {
    public static void main(String[] args) throws RemoteException {
        int port = 1099;
        try{
            port = Integer.parseInt(args[0]);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Distributeur d = new Distributeur();
        ServiceDistributeur serv = (ServiceDistributeur) UnicastRemoteObject.exportObject(d, 0);
        Registry reg = LocateRegistry.createRegistry(port);
        reg.rebind("tableauBlanc", serv);


    }
}
