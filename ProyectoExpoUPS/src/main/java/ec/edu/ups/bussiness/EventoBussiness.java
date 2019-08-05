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


@Stateless
public class EventoBussiness {
	@Inject
	private EventoDAO dao;

	public boolean save(Evento evento) throws Exception {
		Evento aux = dao.read(evento.getId());
		if (aux != null)
			throw new Exception("Evento ya Registrada");
		else
			dao.insert(evento);

		return true;
	}

	public List<Evento> getEventos() {

		return dao.getEventos();
	}

	public void delete(int id) throws Exception {
		Evento aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Evento evento) throws Exception {
		Evento aux = dao.read(evento.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(evento);

		return true;
	}

	public Evento getEvento(int id) throws Exception {
		Evento aux = dao.read(id);
		if (aux == null)
			throw new Exception("Evento no existe");
		else
			return aux;
	}

}
