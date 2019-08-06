package ec.edu.ups.services;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.bussiness.CarreraBussiness;
import ec.edu.ups.model.Carrera;


@Path("Carreraservicios")
public class CarreraService {
	@Inject
	private CarreraBussiness cBussiness;
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Carrera> getCarreras(){
		return cBussiness.getCarreras();
	}
	

}
