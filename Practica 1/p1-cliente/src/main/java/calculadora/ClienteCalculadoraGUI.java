package calculadora;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import CalculadoraGUI.CalculadoraGUI;
import CalculadoraGUI.ICalculadora;
import thriftStubs.CalculadoraException;
import thriftStubs.ServicioCalculadora;

public class ClienteCalculadoraGUI {
	
	public static void main(String[] args) {
		
		new CalculadoraGUI(new AdaptadorOperacionesCalculadoraGUI());
	}

}
