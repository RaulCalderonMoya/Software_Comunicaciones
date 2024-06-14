package cliente;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;

import CalculadoraGUI.ICalculadora;
import wsCalculadora.Exception_Exception;
import wsCalculadora.OperacionesCalculadora;
import wsCalculadora.OperacionesCalculadoraService;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz de
 * CalculadoraGUI.ICalculadora. Se peude utilizar un adaptador de clase o de
 * objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadora {

	// private ServicioCalculadora.Iface stubCliente; //Clases creadas con el thrift

	public OperacionesCalculadoraService ss;
	public OperacionesCalculadora port;

	public AdaptadorOperacionesCalculadoraGUI(OperacionesCalculadoraService ss, OperacionesCalculadora port) {
		this.ss = ss;
		this.port = port;

	}

	// Escribir los métodos.
	
	public double sumar(double operando1, double operando2) {
		System.out.println("Se va a invocar la suma");
		double _implementacionSumar_return = port.implementarSumar(operando1, operando2);
		return _implementacionSumar_return;
	}

	public double restar(double operando1, double operando2) {
		System.out.println("Se va a invocar la resta");
		double _implementacionRestar_return = port.implementarRestar(operando1, operando2);
		return _implementacionRestar_return;
	}

	public double multiplicar(double operando1, double operando2) {
		System.out.println("Se va a invocar la multiplicación");
		double _implementacionMultiplicar_return = port.implementarMultiplicar(operando1, operando2);
		return _implementacionMultiplicar_return;
	}

	public double dividir(double operando1, double operando2) throws Exception_Exception  {
		System.out.println("Se va a invocar la division");
		double _implementacionRestar_return;
		try {
			_implementacionRestar_return = port.implementarDividir(operando1, operando2);//CalculadoraExcepcion_Exception
		} catch (Exception_Exception e) {
			throw new Exception_Exception( e.getMessage());
		}
		return _implementacionRestar_return;
	}

	public double obtenerUltimoResultado() {
		System.out.println("Se va a invocar el ultimoResultado");
		double _implementacionUR__return = port.implementacionUR();
		return _implementacionUR__return;
	}

	public void memoriaLimpiar() {
		port.implementacionML();
	}

	public void memoriaAniadir() {
		port.implementacionMA();
	}

	public double memoriaObtener() {
		System.out.println("Se va a invocar memoriaObtener");
		double _implementacionMO__return = port.implementacionMO();
		return _implementacionMO__return;
	}


	public double operar(int numeroDeOperacion, double operando) throws Exception_Exception {
		double _operar__return;
		try {
			 _operar__return = port.operar(numeroDeOperacion, operando);
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			throw new Exception_Exception( e.getMessage());
		}
		return _operar__return;
	}

	public String[] getOperaciones(int numeroBotonesDisponibles) {
		java.util.List<java.lang.String> _getOperaciones__return = port.getOperaciones(numeroBotonesDisponibles);
		return _getOperaciones__return.toArray(new String[numeroBotonesDisponibles]);
		
	}

}
