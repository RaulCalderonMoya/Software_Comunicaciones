package servidor;

import rmiCalculadora.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



//import javax.swing.plaf.synth.SynthStyleFactory;





/** Esta es la clase que contiene el método main() de la aplicación de la calculadora y de la aplicación cleinte de la calculadora.
 * 
 */
public class ServidorCalculadora {

	/** Este es el método inicial de la aplicación. En él basta con instanciar CalculadoraGUI
	 * pasándole una instancia nueva de una clase que implementa OperacionesCalculadoraGUI.
	 * @param args Argumentos del método main()
	 */
	public static void main(String[] args) {

		// Instanciar los objetos necesarios.
		//OperacionesCalculadora operaciones = new OperacionesCalculadora();
		//AdaptadorOperacionesCalculadoraGUI adaptador = new AdaptadorOperacionesCalculadoraGUI();
		//new CalculadoraGUI(new AdaptadorOperacionesCalculadora());
		new AdaptadorOperacionesCalculadoraRMI();
		

//			try {
//			 	ICalculadoraRMI operaciones = (ICalculadoraRMI) new AdaptadorOperacionesCalculadoraRMI();
//				ICalculadoraRMI remoteStub = (ICalculadoraRMI) UnicastRemoteObject.exportObject(operaciones, 0);
//				Registry registry = LocateRegistry.createRegistry(1099);
//				registry.rebind("Calculadora", remoteStub);
//			} catch (RemoteException e) {
//				// TODO Auto-generated catch block
//				System.err.println(e.getMessage());
//				e.printStackTrace();
//			}
		
	}

}
