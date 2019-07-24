package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;

@Stateless
public class UniversidadDAO {

	@Inject
	private EntityManager em;

	public void insert(Universidad universidad) {
		em.persist(universidad);

	}

	public void update(Universidad universidad) {
		em.merge(universidad);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Universidad read(int id) {
		Universidad universidad = em.find(Universidad.class, id);
		return universidad;
	}

	public List<Universidad> getUniversidads() {

		String jpql = "SELECT c FROM Universidad c";
		Query query = em.createQuery(jpql, Universidad.class);
		@SuppressWarnings("unchecked")
		List<Universidad> listado = query.getResultList();
		return listado;
	}
}
