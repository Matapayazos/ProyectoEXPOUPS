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

import ec.edu.ups.bussiness.ClienteBussiness;
import ec.edu.ups.model.Cliente;

@Path("/clientes")
public class ClienteServicesRest {

	@Inject
	private ClienteBussiness cBussiness;

	@Path("/list")
	@GET
	@Produces("application/json")
	public List<Cliente> getClientes() {
		return cBussiness.getClientes();
	}
	
	@Path("/getpropietario")
	@GET
	@Produces("application/json")
	public Cliente getPropietarioCarro(@QueryParam("idCarro") String idCarro) {
		return cBussiness.getPropietarioCarro(idCarro);
	}
	
	@Path("/login")
	@GET	
	@Produces("application/json")
	public Cliente getUserPassword(@QueryParam("cedula") String cedula) throws Exception
	{
		return cBussiness.getCredencialesLogin(cedula);
	}
	
	@POST
    @Path("/loglogin")
	@Produces("application/json")
	public Response registrarLogCliente(@QueryParam("id") String id) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			cBussiness.registrarLogCliente(id);
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
