package ec.edu.ups.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.bussiness.AspiranteBussiness;

import ec.edu.ups.model.Aspirante;

@Path("Aspiranteservicios")
public class AspirantesServicios {
	@Inject
	private AspiranteBussiness aBussiness;
	@POST
	@Path("/insert")
	@Produces("application/json")
	// Insertar aspirante desde la aplicacion, consumiendo el webservice de insertar aspirante
	public Response insertAspirante(Aspirante aspirante) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			System.out.println("entro alv ,,,,,,,,,,,,,,,,");
			aBussiness.save(aspirante);
			data.put("code", "1");
			data.put("message", "OK");
			builder=Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("no entro alv ,,,,,,,,,,,,,,,,");
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder=Response.status(Response.Status.OK).entity(data);
		}
		
		return builder.build();
	}

	@GET
	@Path("/Login")
	@Consumes("application/json")
	@Produces("application/json")
	// Logeo del aspirante desde la aplicacion, consumiendo el webservice de logeo
	public Boolean Login(@QueryParam("email")String email, @QueryParam("password")String password) {

		try {
			aBussiness.Login(email, password);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

	}
	
	
	@GET
	@Path("/Listar")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Aspirante> Listar() {
		try {
			return aBussiness.getAspirantes();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
