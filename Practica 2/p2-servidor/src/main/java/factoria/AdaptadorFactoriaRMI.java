package factoria;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


import servidor.AdaptadorOperacionesCalculadoraRMI;


/** Esta clase sirve para adaptar la interfaz de la clase calculadora.OperacionesCalculadora a la interfaz
 * de CalculadoraGUI.ICalculadora.
 * Se peude utilizar un adaptador de clase o de objeto.
 */
public class AdaptadorFactoriaRMI implements IFactoria{
	
	// Escribir los métodos.
	private IFactoria factoria;
	private final static int PUERTO = 1099;
	public AdaptadorFactoriaRMI() throws RemoteException
	{
		try {	
			factoria = (IFactoria) UnicastRemoteObject.exportObject(this, 0);
			Registry registry = LocateRegistry.createRegistry(PUERTO);
			registry.rebind("Factory", factoria);
        } catch (RemoteException e) {
            e.printStackTrace();
        } 
	}

	@Override
	public rmiCalculadora.ICalculadoraRMI crearCalculadoraRMI() throws RemoteException {
		return new AdaptadorOperacionesCalculadoraRMI();
	}




}
