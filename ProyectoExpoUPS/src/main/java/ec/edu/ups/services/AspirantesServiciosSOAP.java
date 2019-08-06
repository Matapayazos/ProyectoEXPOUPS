package ec.edu.ups.services;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.core.Response;

import ec.edu.ups.bussiness.AspiranteBussiness;
import ec.edu.ups.model.Aspirante;


@WebService
public class AspirantesServiciosSOAP {
	@Inject
	private AspiranteBussiness aBussiness;
	
	
	@WebMethod
	public Response InsertarAspirante(Aspirante a ) {
		
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			aBussiness.save(a);
			data.put("code", "2");
			data.put("message", "OK");
			builder=Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "100");
			data.put("message", e.getMessage());
			builder=Response.status(Response.Status.OK).entity(data);
		}
		
		return builder.build();
	}

	}


