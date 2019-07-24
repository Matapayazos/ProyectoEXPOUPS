package ec.edu.ups.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.bussiness.CarroBussiness;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.RegistroApp;

@Path("/carros")
public class CarroServicesRest {
	
	@Inject
	private CarroBussiness cBussiness;

	@Path("/list")
	@GET
	@Produces("application/json")
	public List<Carro> getCarros() {
		return cBussiness.getCarros();
	}
	
	@Path("/getcomentarios")
	@GET
	@Produces("application/json")
	public List<RegistroApp> getComentarios() {
		return cBussiness.getComentarios();
	}
	
	@POST
    @Path("/logcarro")
	@Produces("application/json")
	public Response registrarLogCarro(@QueryParam("idCarro") String idCarro, @QueryParam("idCliente") String idCliente) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			cBussiness.registrarLogCarro(idCarro, idCliente);
			data.put("code", "1");
			data.put("message", "OK");
			builder=Response.status(Response.Status.OK).entity(data);			
		} catch (Exception e) {
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder=Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}
	
	@POST
    @Path("/savecomentario")
	@Produces("application/json")
	public Response registrarComentario(@QueryParam("idCarro") String idCarro, @QueryParam("idCliente") String idCliente, @QueryParam("comentario") String comentario) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			cBussiness.registrarComentario(idCarro, idCliente, comentario);
			data.put("code", "1");
			data.put("message", "OK");
			builder=Response.status(Response.Status.OK).entity(data);			
		} catch (Exception e) {
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder=Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}
	
 
	
}
