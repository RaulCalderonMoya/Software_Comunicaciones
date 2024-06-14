package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import CalculadoraGUI.ICalculadora;
import calculadora.OperacionesCalculadora;
import rmiCalculadora.CalculadoraExcepcion;
import rmiCalculadora.ICalculadoraRMI;
import calculadora.*;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz de
 * CalculadoraGUI.ICalculadora. Se peude utilizar un adaptador de clase o de
 * objeto.
 */
public class AdaptadorOperacionesCalculadoraRMI extends OperacionesCalculadora implements ICalculadoraRMI {

	private ICalculadoraRMI remoteStub;
    //private ICalculadoraRMI operaciones;
	public AdaptadorOperacionesCalculadoraRMI() {
		// this.operaciones = calc;
		try {
			//operaciones = (ICalculadoraRMI) new AdaptadorOperacionesCalculadoraRMI();
			remoteStub = (ICalculadoraRMI) UnicastRemoteObject.exportObject(this, 0);
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculadora", remoteStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public double dividir(double dividendo, double divisor) throws CalculadoraExcepcion {
		return implementarDividir(dividendo, divisor);

	}

	@Override
	public double elevarAlCuadrado(double operando) {
		// TODO Auto-generated method stub
		return implementarElevarAlCuadrado(operando);
	}

	@Override
	public void memoriaAniadir() {
		// TODO Auto-generated method stub
		implementacionMA();
	}

	@Override
	public void memoriaLimpiar() {
		// TODO Auto-generated method stub
		implementacionML();
	}

	@Override
	public double memoriaObtener() {
		// TODO Auto-generated method stub
		return implementacionMO();
	}

	@Override
	public double multiplicar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarMultiplicar(operando1, operando2);
	}

	@Override
	public double restar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarRestar(operando1, operando2);
	}

	@Override
	public double sumar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarSumar(operando1, operando2);
	}

	@Override
	public double obtenerUltimoResultado() {
		// TODO Auto-generated method stub
		return implementacionUR();
	}

	// Escribir los métodos.

}
