import java.rmi.RemoteException;
import java.util.ArrayList;

public class Distributeur implements ServiceDistributeur{
    private ArrayList<ServiceTableauBlanc> tab;
    private ArrayList<Dessin> des;
    public Distributeur()
    {
        this.tab = new ArrayList<ServiceTableauBlanc>();
        this.des = new ArrayList<Dessin>();
    }

    public void distribuerMessage(Dessin var1) throws RemoteException {
        this.des.add(var1);
        for (ServiceTableauBlanc s: this.tab) {
            try {
                s.afficherMessage(var1);
            }catch (Exception e)
            {
                this.tab.remove(s);
            }
        }
    }

    public void enregistrerClient(ServiceTableauBlanc var1) throws RemoteException {
        for(Dessin s : des)
        {
            var1.afficherMessage(s);
        }
        this.tab.add(var1);

    }
}
