package cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiCalculadora.*;
import CalculadoraGUI.CalculadoraGUI;
import CalculadoraGUI.ICalculadora;

public class ClienteCalculadora {
	
	public static void main(String[] args) {
		new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
	}

}
