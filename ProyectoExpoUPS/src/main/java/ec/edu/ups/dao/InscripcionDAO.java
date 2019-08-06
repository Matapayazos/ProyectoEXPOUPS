package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Inscripcion;

@Stateless
public class InscripcionDAO {

	@Inject
	private EntityManager em;

	public void insert(Inscripcion inscripcion) {
		em.persist(inscripcion);

	}

	public void update(Inscripcion inscripcion) {
		em.merge(inscripcion);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Inscripcion read(int id) {
		Inscripcion inscripcion = em.find(Inscripcion.class, id);
		return inscripcion;
	}

	public List<Inscripcion> getInscripcions() {

		String jpql = "SELECT c FROM Inscripcion c";
		Query query = em.createQuery(jpql, Inscripcion.class);
		@SuppressWarnings("unchecked")
		List<Inscripcion> listado = query.getResultList();
		return listado;
	}
}
