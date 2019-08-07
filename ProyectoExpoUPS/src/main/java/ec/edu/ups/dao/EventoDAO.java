package ec.edu.ups.dao;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Evento;
import ec.edu.ups.model.Evento;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad  Evento
 * @author Cancer31
 *
 */
@Stateless
public class EventoDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param evento
	 */
	public void insert(Evento evento) {
		em.persist(evento);

	}

	/**
	 * 
	 * @param evento
	 */
	public void update(Evento evento) {
		em.merge(evento);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * lsiata eventos por id
	 * @param id id del evento 
	 * @return retorna un evento 
	 */
	public Evento read(int id) {
		Evento evento = em.find(Evento.class, id);
		return evento;
	}

	/**
	 * lista de eventos
	 * @return retoena una lista de eventos
	 */
	public List<Evento> getEventos() {

		String jpql = "SELECT c FROM Evento c";
		Query query = em.createQuery(jpql, Evento.class);
		@SuppressWarnings("unchecked")
		List<Evento> listado = query.getResultList();
		return listado;
	}
	/**
	 * listar eventos por fecha
	 * @param fecha fecha para buscar
	 * @return retoena una lsita de eventos 
	 */
	public List<Evento> readxFecha(Date fecha) {

		String jpql = "SELECT c FROM Evento c WHERE c.fecha=:fecha";
		Query query = em.createQuery(jpql, Evento.class);
		query.setParameter("fecha", fecha);
		@SuppressWarnings("unchecked")
		List<Evento> listado = query.getResultList();
		return listado;
	}
}
