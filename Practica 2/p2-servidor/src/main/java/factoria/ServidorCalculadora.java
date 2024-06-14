package factoria;

import java.rmi.RemoteException;

public class ServidorCalculadora {
	public static void main(String[] args) {
		try {
			new AdaptadorFactoriaRMI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
