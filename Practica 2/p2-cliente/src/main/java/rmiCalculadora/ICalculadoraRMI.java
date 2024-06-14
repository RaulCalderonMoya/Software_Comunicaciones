
package rmiCalculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadoraRMI extends Remote {
	double sumar(double operando1, double operando2) throws RemoteException;
	double dividir(double dividendo, double divisor) throws RemoteException, CalculadoraExcepcion, Exception;
	double restar(double operando1, double operando2)throws RemoteException;
	double multiplicar(double operando1, double operando2)throws RemoteException;
	double obtenerUltimoResultado()throws RemoteException;
	void memoriaLimpiar()throws RemoteException;
	void memoriaAniadir()throws RemoteException;
	double memoriaObtener()throws RemoteException;
	double elevarAlCuadrado(double operando)throws RemoteException;
}
