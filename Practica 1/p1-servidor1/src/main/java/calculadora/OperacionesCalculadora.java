package calculadora;

import thriftStubs.CalculadoraException;

/** Esta clase contiene la implementación final de cada operación disponible en la calculadora.
 * Debe contener un método público de instancia por cada método de la interfaz CalculadoraGUI.ICalculadora.
 * Para evitar confusiones, se recomienda que cada uno de los métodos citados anteponga 'implementacion' al
 * nombre del método de CalculadoraGUI.ICalculadora. Por ejemplo: si se desea crear el método que implementa
 * la suma, su nombre en esta clase será 'implementacionSumar'.
 */
public class OperacionesCalculadora {

	// Escribir los métodos.
	  private double memoria;
	    private double res;//Valor de la ultima operacion realizada en la calculadora

	    public OperacionesCalculadora() {
	        memoria = 0;
	    }

	    public double implementarDividir(double dividendo, double divisor) throws CalculadoraException {
	        // TODO Auto-generated method stub
	    	if(dividendo == 0 && divisor == 0) throw new CalculadoraException("Indeterminación");
	    	if(divisor == 0) throw new CalculadoraException("Infinito");
	        res = dividendo/divisor;
	        return res;
	    }

	    public double implementarElevarAlCuadrado(double operando) {
	        // TODO Auto-generated method stub
	        res = operando*operando;
	        return res;
	    }

	    public void implementarMemoriaAniadir() {
	        // TODO Auto-generated method stub
	        memoria = res;
	    }

	    public void implementarMemoriaLimpiar() {
	        // TODO Auto-generated method stub
	        memoria = 0;
	    }

	    public double implementarMemoriaObtener() {
	        // TODO Auto-generated method stub
	        return memoria;
	    }

	    public double implementarMultiplicar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	        res = valor1*valor2;
	        return res;
	    }

	    public double implementarObtenerUltimoResultado() {
	        // TODO Auto-generated method stub
	        return res;
	    }

	    public double implementarRestar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	        res = valor1-valor2;
	        return res;
	    }

	    public double implementarSumar(double valor1, double valor2) {
	        // TODO Auto-generated method stub
	        res = valor1+valor2;
	        return res;
	    }
	

}
