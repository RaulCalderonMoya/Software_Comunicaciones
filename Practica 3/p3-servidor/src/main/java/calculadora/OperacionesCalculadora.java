package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Esta clase contiene la implementación final de cada operación disponible en
 * la calculadora. Debe contener un método público de instancia por cada método
 * de la interfaz CalculadoraGUI.ICalculadora. Para evitar confusiones, se
 * recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea
 * crear el método que implementa la suma, su nombre en esta clase será
 * 'implementacionSumar'.
 */

@WebService(targetNamespace = "http://calculadora/", portName = "OperacionesCalculadoraPort", serviceName = "OperacionesCalculadoraService")
public class OperacionesCalculadora {
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	// Escribir los métodos.
	private double memoria;
	private double res;// Valor de la ultima operacion realizada en la calculadora

	public OperacionesCalculadora() {
		memoria = 0;
	}

	@WebMethod(operationName = "implementarDividir", action = "urn:ImplementarDividir")
	public double implementarDividir(double dividendo, double divisor) throws Exception {
		lock.readLock().lock();
		// TODO Auto-generated method stub
		if (dividendo == 0 && divisor == 0)
			throw new Exception("Indeterminación");
		if (divisor == 0)
			throw new Exception("Infinito");
		res = dividendo / divisor;
		lock.readLock().unlock();
		return res;
	}

//	public double implementarElevarAlCuadrado(double operando) {
//		// TODO Auto-generated method stub
//		lock.readLock().lock();
//		res = operando * operando;
//		lock.readLock().unlock();
//		return res;
//	}

	@WebMethod(operationName = "implementacionMA", action = "urn:ImplementacionMA")
	public void implementacionMA() {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		memoria = res;
		lock.readLock().unlock();
	}

	@WebMethod(operationName = "implementacionML", action = "urn:ImplementacionML")
	public void implementacionML() {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		memoria = 0;
		lock.readLock().unlock();
	}

	@WebMethod(operationName = "implementacionMO", action = "urn:ImplementacionMO")
	public double implementacionMO() {
		// TODO Auto-generated method stub
		try {
			lock.readLock().lock();
			return memoria;
		} finally {
			lock.readLock().unlock();
		}

		// return memoria;
	}

	@WebMethod(operationName = "implementarMultiplicar", action = "urn:ImplementarMultiplicar")
	public double implementarMultiplicar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 * valor2;
		lock.readLock().unlock();
		return res;
	}

	@WebMethod(operationName = "implementacionUR", action = "urn:ImplementacionUR")
	public double implementacionUR() {
		// TODO Auto-generated method stub
		try {
			lock.readLock().lock();
			return res;
		} finally {
			lock.readLock().unlock();
		}
		// return res;
	}

	@WebMethod(operationName = "implementarRestar", action = "urn:ImplementarRestar")
	public double implementarRestar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 - valor2;
		lock.readLock().unlock();
		return res;
	}

	@WebMethod(operationName = "implementarSumar", action = "urn:ImplementarSumar")
	public double implementarSumar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 + valor2;
		lock.readLock().unlock();
		return res;
	}

	@WebMethod(operationName = "getOperaciones", action = "urn:GetOperaciones")
	public String[] getOperaciones(int numeroDeBotones) {
		String[] operaciones = { "x^2", "sqrt(x)", "ln(x)", "tg(x)" };

		int i = 0;
		String[] stringAux = new String[numeroDeBotones];

		if (numeroDeBotones < 4) {
			stringAux[i] = operaciones[i];
			i++;
			if (i == numeroDeBotones) {
				return stringAux;
			}
		}

		return operaciones;
	}

	@WebMethod(operationName = "operar", action = "urn:Operar")
	public double operar(int operacion, double operando) throws Exception {
		// Faltarian gestionar las excepcoines (del logaritmo, tangente,etc) y tema de
		// concurrencia
		String valorOperacion = Integer.toString(operacion);
		switch (valorOperacion) {
		case "0":
			res = operando * operando;
			return res;
		case "1":
			if (operando >= 0) {
				res = Math.sqrt(operando);
			} else {
				throw new Exception("No se puede hacer la raiz cuadrada de un número negativo");
			}
			return res;
		case "2":
			// res = Math.log(operando);

			if (operando > 0) {
				res = Math.log(operando);
			} else {
				throw new Exception("No se puede hacer el logaritmo de un número negativo o 0");
			}
			return res;
		case "3":
			res = Math.tan(operando);
			return res;
		default:
			throw new Exception("Operacion Desconocida");

		}

	}
}
