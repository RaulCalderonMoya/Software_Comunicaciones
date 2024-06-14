package cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import CalculadoraGUI.ICalculadora;
import entidades.BotonesCalculadora;
import entidades.Resultado;

/**
 * Esta clase sirve para adaptar la interfaz de la clase
 * calculadora.OperacionesCalculadora a la interfaz de
 * CalculadoraGUI.ICalculadora. Se peude utilizar un adaptador de clase o de
 * objeto.
 */
public class AdaptadorOperacionesCalculadoraGUI implements ICalculadora {

	// private ServicioCalculadora.Iface stubCliente; //Clases creadas con el thrift

	public WebTarget target;
	private Cookie sessionId;

	public AdaptadorOperacionesCalculadoraGUI() {
		final ClientConfig config = new ClientConfig();
		final Client client = ClientBuilder.newClient(config);
		sessionId = null;
		target = client.target("http://localhost:8080/p4-servidor/rest/calculadora/");
	}

	// Escribir los métodos.

	public double sumar(double operando1, double operando2) {
		Builder peticion = target.path("sumar")
				.queryParam("operando1", operando1)
				.queryParam("operando2", operando2)
				.request()
				.accept(MediaType.APPLICATION_XML);
		
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		Resultado resultado = response.readEntity(Resultado.class);
		return resultado.getResultado();
	}

	public double restar(double operando1, double operando2) {
		Builder peticion = target.path("restar")
				.queryParam("operando1", operando1)
				.queryParam("operando2", operando2)
				.request()
				.accept(MediaType.APPLICATION_XML);

		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		Resultado resultado = response.readEntity(Resultado.class);
		return resultado.getResultado();
	}

	public double multiplicar(double operando1, double operando2) {
		Builder peticion = target.path("multiplicar")
				.queryParam("operando1", operando1)
				.queryParam("operando2", operando2)
				.request()
				.accept(MediaType.APPLICATION_XML);
		
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		Resultado resultado = response.readEntity(Resultado.class);
		return resultado.getResultado();
	}

	public double dividir(double dividendo, double divisor) throws Exception {
		Builder peticion = target.path("dividir")
				.queryParam("dividendo", dividendo)
				.queryParam("divisor", divisor)
				.request()
				.accept(MediaType.APPLICATION_XML)
				.accept(MediaType.TEXT_PLAIN);
		
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			Resultado resultado = response.readEntity(Resultado.class);
			return resultado.getResultado();
		} else if (response.getStatus() == Response.Status.PRECONDITION_FAILED.getStatusCode()) {
			throw new Exception(response.readEntity(String.class));
		} else {
			throw new Exception("Formato de respuesta desconocido");
		}
        
	}

	public double obtenerUltimoResultado() {
		Builder peticion = target.path("ur")
				.request()
				.accept(MediaType.APPLICATION_XML);

		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;
		Resultado resultado = response.readEntity(Resultado.class);
		return resultado.getResultado();
	}

	public void memoriaLimpiar() {
		Builder peticion = target.path("memoria")
				.request();
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.delete();//OJO!! AQUI DELETE porque lo pone en la API REST
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;
	}

	public void memoriaAniadir() {
		Builder peticion = target.path("memoria").request();
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.head();// Tal y como dice el enunciado este es HEAD
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;
	}

	public double memoriaObtener() {
		Builder peticion = target.path("memoria")// Al no tener parámetros directamente se eliminan
				.request()// las lineas queryParam al no hacer falta para nada
				.accept(MediaType.APPLICATION_XML);

		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		Resultado resultado = response.readEntity(Resultado.class);
		return resultado.getResultado();
	}

	public double operar(int numeroDeOperacion, double operando) throws Exception {
		Builder peticion = target.path("operar")
				.queryParam("operacion", numeroDeOperacion)
				.queryParam("operando", operando)
				.request()
				.accept(MediaType.APPLICATION_XML)
				.accept(MediaType.TEXT_PLAIN);
		
		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;
		
		
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			Resultado resultado = response.readEntity(Resultado.class);
			return resultado.getResultado();
		} else if (response.getStatus() == Response.Status.PRECONDITION_FAILED.getStatusCode()) {
			throw new Exception(response.readEntity(String.class));
		} else {
			throw new Exception("Formato de respuesta desconocido");
		}
		
		/*		String contentType = response.getMediaType().toString();
		if (contentType.equals("application/xml")) {
			Resultado resultado = response.readEntity(Resultado.class);
			return resultado.getResultado();
		} else if (contentType.equals("text/plain")) {
			throw new Exception(response.readEntity(String.class));
		} else {
			throw new Exception("Formato de respuesta desconocido: " + contentType);
		}*/
		
	}

	public String[] getOperaciones(int numeroBotonesDisponibles) {
		Builder peticion = target.path("operaciones")
				.queryParam("numeroOperaciones", numeroBotonesDisponibles)
				.request()
				.accept(MediaType.APPLICATION_XML);

		if (sessionId != null)
			peticion = peticion.cookie(sessionId);
		Response response = peticion.get();
		final Cookie thisSessionId = response.getCookies().get("JSESSIONID");
		if (sessionId == null)
			sessionId = thisSessionId;

		BotonesCalculadora res = response.readEntity(BotonesCalculadora.class);
		return res.getListaOperaciones();
	}

}
