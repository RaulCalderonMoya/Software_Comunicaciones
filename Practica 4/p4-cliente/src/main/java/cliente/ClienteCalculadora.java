package cliente;

import CalculadoraGUI.CalculadoraGUI;

public class ClienteCalculadora {
	//private static final QName SERVICE_NAME = new QName("http://calculadora/", "OperacionesCalculadoraService");
	
	public static void main(String[] args) {
		new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
	}

}
