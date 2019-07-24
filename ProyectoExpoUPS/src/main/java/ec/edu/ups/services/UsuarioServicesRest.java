package ec.edu.ups.services;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.bussiness.UsuarioBussiness;
import ec.edu.ups.model.Usuario;

@Path("/usuarios")
public class UsuarioServicesRest {
	
	@Inject
	private UsuarioBussiness uBussiness;
	
	@Path("/list")
	@GET
	@Produces("application/json")
	public List<Usuario> getUsuarios() {
		return uBussiness.getUsuarios();
	}
	


}
