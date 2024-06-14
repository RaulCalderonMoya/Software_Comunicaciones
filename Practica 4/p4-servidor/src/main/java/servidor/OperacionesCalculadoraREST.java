package servidor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import calculadora.OperacionesCalculadora;
import entidades.*;

//Path -> http://localhost:8080/p4-servidor/rest/calculadora/

@Path("/calculadora")
public class OperacionesCalculadoraREST {
	// Nota: Nos dicen que debe haber un paquete entidades para poder realizar
	// la serialización XML.
	
	/*Codigo de Fase 3 o anteriores comentado*/
	
//	private OperacionesCalculadora operaciones;
	
//	//Nota: En la fase 2 no es posible almacenar el estado de las calculadoras
//	public OperacionesCalculadoraREST() {
//		operaciones = new OperacionesCalculadora();
//	}

	@Context
	private HttpServletRequest hsr;

	private OperacionesCalculadora getOperacionesCalculadora() {
		final String ATRIBUTOCALCULADORA = "operaciones";
		final HttpSession sesion = hsr.getSession();
		OperacionesCalculadora operaciones = (OperacionesCalculadora) sesion.getAttribute(ATRIBUTOCALCULADORA);
		if (operaciones == null) {
			operaciones = new OperacionesCalculadora();
			sesion.setAttribute(ATRIBUTOCALCULADORA, operaciones);
		}
		return operaciones;
	}

	// Solo atiende peticiones de tipo GET
	// @QueryParam("operando1") --> Mapea el valor a double operando1
	@GET
	@Path("sumar")
	@Produces({ MediaType.APPLICATION_XML })
	public Response getSumar(@QueryParam("operando1") double operando1, @QueryParam("operando2") double operando2) {
		ResponseBuilder response = Response.status(Response.Status.OK);
		Resultado res = new Resultado();
		double resultado = getOperacionesCalculadora().implementarSumar(operando1, operando2);
		res.setResultado(resultado);
		response = response.entity(res);
		System.out.println();
		return response.build();
	}

	@GET
	@Path("restar")
	@Produces({ MediaType.APPLICATION_XML })
	public Response getRestar(@QueryParam("operando1") double operando1, @QueryParam("operando2") double operando2) {
		ResponseBuilder response = Response.status(Response.Status.OK);
		Resultado res = new Resultado();
		double resultado = getOperacionesCalculadora().implementarRestar(operando1, operando2);
		res.setResultado(resultado);
		response = response.entity(res);
		System.out.println();
		return response.build();
	}

	@GET
	@Path("multiplicar")
	@Produces({ MediaType.APPLICATION_XML})
	public Response getMultiplicar(@QueryParam("operando1") double operando1,
			@QueryParam("operando2") double operando2) {
		ResponseBuilder response = Response.status(Response.Status.OK);
		Resultado res = new Resultado();

		double resultado = getOperacionesCalculadora().implementarMultiplicar(operando1, operando2);
		res.setResultado(resultado);
		response = response.entity(res);
		System.out.println();
		return response.build();
	}

	@GET
	@Path("dividir")
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
	public Response getDividir(@QueryParam("dividendo") double dividendo, @QueryParam("divisor") double divisor) {
		ResponseBuilder response;
		Resultado res = new Resultado();
		try {
			double resultado = getOperacionesCalculadora().implementarDividir(dividendo, divisor);
			response = Response.status(Response.Status.OK);
			res.setResultado(resultado); // Agregar resultado a clase serializadora/deserializadora
			response = response.entity(res);

		} catch (Exception e) {
			response = Response.status(Response.Status.PRECONDITION_FAILED).type(MediaType.TEXT_PLAIN);
			response = response.entity(e.getMessage());
		}
		System.out.println();
		return response.build();
	}

	@GET
	@Path("ur")
	@Produces({ MediaType.APPLICATION_XML })
	public Response getUltimoResultado() {
		ResponseBuilder response = Response.status(Response.Status.OK);
		Resultado res = new Resultado();
		double resultado = getOperacionesCalculadora().implementacionUR();
		res.setResultado(resultado);
		// response = response.entity(Double.toString(resultado));
		response = response.entity(res);
		System.out.println();
		return response.build();
	}

	@GET
	@Path("memoria")
	@Produces({ MediaType.APPLICATION_XML })
	public Response getMO() {
		ResponseBuilder response = Response.status(Response.Status.OK);
		Resultado res = new Resultado();

		double resultado = getOperacionesCalculadora().implementacionMO();
		// response = response.entity(Double.toString(resultado));
		res.setResultado(resultado);
		response = response.entity(res);
		System.out.println();
		return response.build();
	}

	@HEAD
	@Path("memoria")
	public Response memoriaAniadirRest() {
		ResponseBuilder response = Response.status(Response.Status.OK);
		getOperacionesCalculadora().implementacionMA();
		// response = response.entity(Double.toString(operaciones));
		System.out.println();
		return response.build();
	}

	@DELETE
	@Path("memoria")
	public Response memoriaLimpiar() {
		ResponseBuilder response = Response.status(Response.Status.OK);
		getOperacionesCalculadora().implementacionML();
		System.out.println();
		return response.build();
	}

	@GET
	@Path("operaciones")
	@Produces({ MediaType.APPLICATION_XML })
	public Response operaciones(@QueryParam("numeroOperaciones") int numeroOperaciones) {
		ResponseBuilder response = Response.status(Response.Status.OK);
		// Resultado res = new Resultado();//Creamos un objeto de la clase
		// serializadora/deserializadora
		BotonesCalculadora botones = new BotonesCalculadora();
		String[] resultado = getOperacionesCalculadora().getOperaciones(numeroOperaciones);
		// Una vez obtenido el String[] con el resultado se debe pasar a la clase que
		// serializa/deserializa
		botones.setListaOperaciones(resultado);

		response.entity(botones);
		System.out.println();
		return response.build();
	}

	@GET
	@Path("operar")
	@Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN }) 	
	public Response operar(@QueryParam("operacion") int operacion, @QueryParam("operando") double operando) {
		ResponseBuilder response;
		Resultado res = new Resultado();
		double resultado = 0;
		try {
			response = Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML);
			resultado = getOperacionesCalculadora().operar(operacion, operando);
			res.setResultado(resultado);
			response = response.entity(res);

		} catch (Exception e) {
			response = Response.status(Response.Status.PRECONDITION_FAILED).type(MediaType.TEXT_PLAIN);
			response = response.entity(e.getMessage());
		}
		System.out.println();
		return response.build();
	}

}
