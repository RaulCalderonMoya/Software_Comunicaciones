package calculadora;

import CalculadoraGUI.ICalculadora;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz de
 * CalculadoraGUI.ICalculadora. Se peude utilizar un adaptador de clase o de
 * objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI extends OperacionesCalculadora implements ICalculadora {

	//private OperacionesCalculadora operaciones;

	public AdaptadorOperacionesCalculadoraGUI() {
		//this.operaciones = calc;
		super();
	}

	@Override
	public double dividir(double dividendo, double divisor) throws Exception {
		// TODO Auto-generated method stub
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
		implementarMemoriaAniadir();
	}

	@Override
	public void memoriaLimpiar() {
		// TODO Auto-generated method stub
		implementarMemoriaLimpiar();
	}

	@Override
	public double memoriaObtener() {
		// TODO Auto-generated method stub
		return implementarMemoriaObtener();
	}

	@Override
	public double multiplicar(double operando1, double operando2) {
		// TODO Auto-generated method stub
		return implementarMultiplicar(operando1, operando2);
	}

	@Override
	public double obtenerUltimoResultado() {
		// TODO Auto-generated method stub
		return implementarObtenerUltimoResultado();
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

	// Escribir los métodos.

}
