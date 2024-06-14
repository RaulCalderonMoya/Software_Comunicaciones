package factoria;

import java.rmi.Remote;
import java.rmi.RemoteException;

import CalculadoraGUI.ICalculadora;
import rmiCalculadora.ICalculadoraRMI;

public interface IFactoria extends Remote {
    ICalculadoraRMI crearCalculadoraRMI ()throws RemoteException;
}
