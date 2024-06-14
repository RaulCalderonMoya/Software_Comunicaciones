package factoria;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import CalculadoraGUI.CalculadoraGUI;
import CalculadoraGUI.ICalculadora;
import cliente.AdaptadorOperacionesCalculadoraGUI;
import rmiCalculadora.ICalculadoraRMI;

public class AdaptadorFactoriaGUI implements IFactoria {

	private IFactoria factoria;
	private final static int PUERTO = 1099;

	public AdaptadorFactoriaGUI() throws RemoteException {
		try {
			Registry factory = LocateRegistry.getRegistry("localhost", PUERTO);
			factoria = (IFactoria) factory.lookup("Factory");
			AdaptadorOperacionesCalculadoraGUI calculadora =  (AdaptadorOperacionesCalculadoraGUI) factoria.crearCalculadoraRMI();
			new CalculadoraGUI(calculadora);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ICalculadoraRMI crearCalculadoraRMI() throws RemoteException {
		return new AdaptadorOperacionesCalculadoraGUI();
	}

}
