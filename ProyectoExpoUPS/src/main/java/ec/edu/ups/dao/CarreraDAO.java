package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Carrera;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad  Carrera
 * @author Cancer31
 *
 */
@Stateless
public class CarreraDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param carrera
	 */
	public void insert(Carrera carrera) {
		em.persist(carrera);

	}

	/**
	 * 
	 * @param carrera
	 */
	public void update(Carrera carrera) {
		em.merge(carrera);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * listar carrera por id 
	 * @param id id de la carrera
	 * @return retona una carrera
	 */
	public Carrera read(int id) {
		Carrera carrera = em.find(Carrera.class, id);
		return carrera;
	}

	/**
	 * listar carreras
	 * @return retorna una lista de carreras
	 */
	public List<Carrera> getCarreras() {
		String jpql = "SELECT c FROM Carrera c";
		Query query = em.createQuery(jpql, Carrera.class);
		@SuppressWarnings("unchecked")
		List<Carrera> listado = query.getResultList();
		return listado;
	}
	
}
