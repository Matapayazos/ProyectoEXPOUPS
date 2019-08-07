package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad  Aspirante 
 * @author Cancer31
 *
 */
@Stateless
public class UniversidadDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param universidad
	 */
	public void insert(Universidad universidad) {
		em.persist(universidad);

	}

	/**
	 * 
	 * @param universidad
	 */
	public void update(Universidad universidad) {
		em.merge(universidad);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * listar universidad por id
	 * @param id id de la universidad 
	 * @return retorna una universidad
	 */
	public Universidad read(int id) {
		Universidad universidad = em.find(Universidad.class, id);
		return universidad;
	}

	/**
	 * lista de universidades
	 * @return retorna una lista de universidades
	 */
	public List<Universidad> getUniversidads() {

		String jpql = "SELECT c FROM Universidad c";
		Query query = em.createQuery(jpql, Universidad.class);
		@SuppressWarnings("unchecked")
		List<Universidad> listado = query.getResultList();
		return listado;
	}
}
