package factoria;

import java.rmi.RemoteException;

public class ClienteFactoriaRMI {
	public static void main(String[] args) {

		try {
			new AdaptadorFactoriaGUI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
