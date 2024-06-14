package calculadora;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

//import javax.swing.plaf.synth.SynthStyleFactory;

import CalculadoraGUI.CalculadoraGUI;
import thriftStubs.ServicioCalculadora;
import thriftStubs.ServicioCalculadora.Iface;


/** Esta es la clase que contiene el método main() de la aplicación de la calculadora y de la aplicación cleinte de la calculadora.
 * 
 */
public class ServidorCalculadora {

	/** Este es el método inicial de la aplicación. En él basta con instanciar CalculadoraGUI
	 * pasándole una instancia nueva de una clase que implementa OperacionesCalculadoraGUI.
	 * @param args Argumentos del método main()
	 */
	public static void main(String[] args) {

		// Instanciar los objetos necesarios.
		//OperacionesCalculadora operaciones = new OperacionesCalculadora();
		//AdaptadorOperacionesCalculadoraGUI adaptador = new AdaptadorOperacionesCalculadoraGUI();
		//new CalculadoraGUI(new AdaptadorOperacionesCalculadora());
		
		try {
			TServerSocket serviceTransport = new TServerSocket(8585);
			ServicioCalculadora.Iface handler = new AdaptadorOperacionesCalculadora();
			TProcessor processor = new ServicioCalculadora.Processor<>(handler);
			TServer server = new TSimpleServer(new TSimpleServer.Args(serviceTransport).processor(processor));
			server.serve();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
