package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Inscripcion;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad Inscripcion
 * @author Cancer31
 *
 */
@Stateless
public class InscripcionDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param inscripcion
	 */
	public void insert(Inscripcion inscripcion) {
		em.persist(inscripcion);

	}

	/**
	 * 
	 * @param inscripcion
	 */
	public void update(Inscripcion inscripcion) {
		em.merge(inscripcion);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * listar inscripciones por id
	 * @param id id de la inscripcion
	 * @return retoena una inscripcion
	 */
	public Inscripcion read(int id) {
		Inscripcion inscripcion = em.find(Inscripcion.class, id);
		return inscripcion;
	}

	/**
	 * lista de incriciones 
	 * @return retorna una lista de inscripciones 
	 */
	public List<Inscripcion> getInscripcions() {

		String jpql = "SELECT c FROM Inscripcion c";
		Query query = em.createQuery(jpql, Inscripcion.class);
		@SuppressWarnings("unchecked")
		List<Inscripcion> listado = query.getResultList();
		return listado;
	}
}
