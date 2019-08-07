package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.EventoDAO;
import ec.edu.ups.dao.EventoDAO;
import ec.edu.ups.dao.EventoDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Evento;
import ec.edu.ups.model.Evento;
import ec.edu.ups.model.Evento;


/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Eventos
 * @author Cancer31
 *
 */
@Stateless
public class EventoBussiness {
	@Inject
	private EventoDAO dao;
	
	/**
	 * Método para guarda eventos
	 * @param evento nuevo evento de tipo evento
	 * @return retorna true si se ha agregado corectamente
	 * @throws Exception Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean save(Evento evento) throws Exception {
		Evento aux = dao.read(evento.getId());
		if (aux != null)
			throw new Exception("Evento ya Registrada");
		else
			dao.insert(evento);

		return true;
	}

	/**
	 * Lista de eventos
	 * @return Retorna una lista de eventos
	 */
	public List<Evento> getEventos() {

		return dao.getEventos();
	}

	/**
	 * Método para eliminar un evento
	 * @param id id del evento de tipo int
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public void delete(int id) throws Exception {
		Evento aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar eventos
	 * @param evento evento para actualizar de tipo evento
	 * @return retorna true si se ha actualizado corectamente
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Evento evento) throws Exception {
		Evento aux = dao.read(evento.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(evento);

		return true;
	}

	/**
	 * Listar Eventos 
	 * @param id
	 * @return
	 * @throws Exception  indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones)
	 */
	public Evento getEvento(int id) throws Exception {
		Evento aux = dao.read(id);
		if (aux == null)
			throw new Exception("Evento no existe");
		else
			return aux;
	}
	/**
	 * Lista de eventos por fecha
	 * @param fecha
	 * @return retorna una lista de eventos
	 */
	public List<Evento> getEventosXFecha(Date fecha) {

		return dao.getEventoXFecha(fecha);
	}
	

}
