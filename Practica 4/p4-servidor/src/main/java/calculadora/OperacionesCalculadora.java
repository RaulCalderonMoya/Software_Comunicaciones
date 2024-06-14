package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class OperacionesCalculadora {
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	// Escribir los métodos.
	private double memoria;
	private double res;// Valor de la ultima operacion realizada en la calculadora

	public OperacionesCalculadora() {
		memoria = 0;
	}

	
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
	
	public void implementacionMA() {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		memoria = res;
		lock.readLock().unlock();
	}

	
	public void implementacionML() {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		memoria = 0;
		lock.readLock().unlock();
	}

	
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

	
	public double implementarMultiplicar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 * valor2;
		lock.readLock().unlock();
		return res;
	}

	
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

	
	public double implementarRestar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 - valor2;
		lock.readLock().unlock();
		return res;
	}

	
	public double implementarSumar(double valor1, double valor2) {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		res = valor1 + valor2;
		lock.readLock().unlock();
		return res;
	}

	
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
