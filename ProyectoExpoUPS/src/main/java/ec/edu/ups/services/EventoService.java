package ec.edu.ups.services;

import java.util.Date;
import java.util.List;


import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.bussiness.EventoBussiness;
import ec.edu.ups.model.Evento;


@Path("Eventoservicios")
public class EventoService {
	@Inject
	private EventoBussiness eBussiness;
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Evento> getEvento(){
		return eBussiness.getEventos();
	}
	@GET
	@Path("/ObtenerFecha")
	@Produces("application/json")
	public List<Evento> EliminacionEvento(@QueryParam("fecha")Date fecha) {
		String x= fecha.toString();
		System.out.println("el Valor de la fecha "+ x);
		try {
			return eBussiness.getEventosXFecha(fecha);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ALgo fallo");
			return null;
		}	
	}

}
