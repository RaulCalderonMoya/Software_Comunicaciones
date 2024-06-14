package calculadora;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import rmiCalculadora.CalculadoraExcepcion;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz CalculadoraGUI.ICalculadora.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
public class OperacionesCalculadora {
	 private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	// Escribir los métodos.
	  private double memoria;
	    private double res;//Valor de la ultima operacion realizada en la calculadora

	    public OperacionesCalculadora() {
	        memoria = 0;
	    }

	    public  double  implementarDividir(double dividendo, double divisor) throws CalculadoraExcepcion {
	    	lock.readLock().lock();
	        // TODO Auto-generated method stub
	    	if(dividendo == 0 && divisor == 0) throw new CalculadoraExcepcion("Indeterminación");
	    	if(divisor == 0) throw new CalculadoraExcepcion("Infinito");
	        res = dividendo/divisor;
	        lock.readLock().unlock();
	        return res;
	    }

	    public  double implementarElevarAlCuadrado(double operando) {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        res = operando*operando;
	        lock.readLock().unlock();
	        return res;
	    }

	    public   void implementacionMA() {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        memoria = res;
	        lock.readLock().unlock();
	    }

	    public  void implementacionML() {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        memoria = 0;
	        lock.readLock().unlock();
	    }

	    public  double implementacionMO() {
	        // TODO Auto-generated method stub
	        try {
	            lock.readLock().lock();
	            return memoria;
	        } finally {
	            lock.readLock().unlock();
	        }
	    	
	       // return memoria;
	    }

	    public  double implementarMultiplicar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        res = valor1*valor2;
	        lock.readLock().unlock();
	        return res;
	    }

	    public  double implementacionUR() {
	        // TODO Auto-generated method stub
	        try {
	            lock.readLock().lock();
	            return res;
	        } finally {
	            lock.readLock().unlock();
	        }
	     //  return res;
	    }

	    public  double implementarRestar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        res = valor1-valor2;
	        lock.readLock().unlock();
	        return res;
	    }

	    public  double implementarSumar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	    	lock.readLock().lock();
	        res = valor1+valor2;
	        lock.readLock().unlock();
	        return res;
	    }
	

}
