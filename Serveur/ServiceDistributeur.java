import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceDistributeur extends Remote {
    void distribuerMessage(Dessin var1) throws RemoteException;

    void enregistrerClient(ServiceTableauBlanc var1) throws RemoteException;
}