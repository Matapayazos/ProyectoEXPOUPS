package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Evento;
import ec.edu.ups.model.Evento;

@Stateless
public class EventoDAO {

	@Inject
	private EntityManager em;

	public void insert(Evento evento) {
		em.persist(evento);

	}

	public void update(Evento evento) {
		em.merge(evento);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Evento read(int id) {
		Evento evento = em.find(Evento.class, id);
		return evento;
	}

	public List<Evento> getEventos() {

		String jpql = "SELECT c FROM Evento c";
		Query query = em.createQuery(jpql, Evento.class);
		@SuppressWarnings("unchecked")
		List<Evento> listado = query.getResultList();
		return listado;
	}
}
