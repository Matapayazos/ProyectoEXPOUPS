package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Carrera;

@Stateless
public class CarreraDAO {

	@Inject
	private EntityManager em;

	public void insert(Carrera carrera) {
		em.persist(carrera);

	}

	public void update(Carrera carrera) {
		em.merge(carrera);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Carrera read(int id) {
		Carrera carrera = em.find(Carrera.class, id);
		return carrera;
	}

	public List<Carrera> getCarreras() {
		String jpql = "SELECT c FROM Carrera c";
		Query query = em.createQuery(jpql, Carrera.class);
		@SuppressWarnings("unchecked")
		List<Carrera> listado = query.getResultList();
		return listado;
	}
	
}
