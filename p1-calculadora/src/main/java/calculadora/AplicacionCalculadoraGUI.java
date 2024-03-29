package calculadora;

//import javax.swing.plaf.synth.SynthStyleFactory;

import CalculadoraGUI.CalculadoraGUI;

/** Esta es la clase que contiene el método main() de la aplicación de la calculadora y de la aplicación cleinte de la calculadora.
 * 
 */
public class AplicacionCalculadoraGUI {

	/** Este es el método inicial de la aplicación. En él basta con instanciar CalculadoraGUI
	 * pasándole una instancia nueva de una clase que implementa OperacionesCalculadoraGUI.
	 * @param args Argumentos del método main()
	 */
	public static void main(String[] args) {

		// Instanciar los objetos necesarios.
		//OperacionesCalculadora operaciones = new OperacionesCalculadora();
		//AdaptadorOperacionesCalculadoraGUI adaptador = new AdaptadorOperacionesCalculadoraGUI();
		new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
	}

}
