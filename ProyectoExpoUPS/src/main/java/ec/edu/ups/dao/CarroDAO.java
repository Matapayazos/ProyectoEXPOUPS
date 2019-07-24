package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Carro;

@Stateless
public class CarroDAO {

	@Inject
	private EntityManager em;

	public void insert(Carro carro) {
		em.persist(carro);

	}

	public void update(Carro carro) {
		em.merge(carro);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Carro read(int id) {
		Carro carro = em.find(Carro.class, id);
		return carro;
	}

	public List<Carro> getCarros() {
		String jpql = "SELECT c FROM Carro c";
		Query query = em.createQuery(jpql, Carro.class);
		@SuppressWarnings("unchecked")
		List<Carro> listado = query.getResultList();
		return listado;
	}

}
