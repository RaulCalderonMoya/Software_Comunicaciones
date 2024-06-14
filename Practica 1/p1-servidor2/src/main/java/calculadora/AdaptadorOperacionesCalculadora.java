package calculadora;

import org.apache.thrift.TException;

import CalculadoraGUI.ICalculadora;
import thriftStubs.CalculadoraException;
import thriftStubs.ServicioCalculadora.Iface;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz de
 * CalculadoraGUI.ICalculadora. Se peude utilizar un adaptador de clase o de
 * objeto.
 */
public class AdaptadorOperacionesCalculadora extends OperacionesCalculadora implements ICalculadora, Iface {

	// private OperacionesCalculadora operaciones;

	public AdaptadorOperacionesCalculadora() {
		// this.operaciones = calc;
		super();
	}

	@Override
	public  double dividir(double dividendo, double divisor) throws CalculadoraException {
		return implementarDividir(dividendo, divisor);

	}

	@Override
	public  double elevarAlCuadrado(double operando) {
		// TODO Auto-generated method stub
		return implementarElevarAlCuadrado(operando);
	}

	@Override
	public  void memoriaAniadir() {
		// TODO Auto-generated method stub
		implementarMemoriaAniadir();
	}

	@Override
	public  void memoriaLimpiar() {
		// TODO Auto-generated method stub
		implementarMemoriaLimpiar();
	}

	@Override
	public  double memoriaObtener() {
		// TODO Auto-generated method stub
		return implementarMemoriaObtener();
	}

	@Override
	public  double multiplicar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarMultiplicar(operando1, operando2);
	}

	@Override
	public  double restar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarRestar(operando1, operando2);
	}

	@Override
	public  double sumar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarSumar(operando1, operando2);
	}

	@Override
	public  double ultimoResultado() throws TException {
		// TODO Auto-generated method stub
		return implementarObtenerUltimoResultado();
	}

	// Escribir los métodos.

}
