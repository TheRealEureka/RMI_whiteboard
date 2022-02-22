import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main (String[] args) throws RemoteException, NotBoundException {
        int port = 1099;
        try{
            port = Integer.parseInt(args[1]);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Registry reg = LocateRegistry.getRegistry(args[0],port);
        ServiceDistributeur dist = (ServiceDistributeur) reg.lookup("tableauBlanc");
        TableauBlanc tableau = new TableauBlanc(dist);
        dist.enregistrerClient((ServiceTableauBlanc) UnicastRemoteObject.exportObject(tableau, 0));
    }
}
