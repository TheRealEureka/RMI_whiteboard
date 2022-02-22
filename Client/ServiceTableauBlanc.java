
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceTableauBlanc extends Remote {
    void afficherMessage(Dessin var1) throws RemoteException;
}
