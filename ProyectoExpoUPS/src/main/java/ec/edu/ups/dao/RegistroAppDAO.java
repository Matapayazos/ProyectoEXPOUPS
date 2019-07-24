package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.RegistroApp;

@Stateless
public class RegistroAppDAO {

	@Inject
	private EntityManager em;

	public void insert(RegistroApp registroApp) {
		em.persist(registroApp);

	}

	public void update(RegistroApp registroApp) {
		em.merge(registroApp);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public RegistroApp read(int id) {
		RegistroApp registroApp = em.find(RegistroApp.class, id);
		return registroApp;
	}

	public List<RegistroApp> getRegistroApps() {

		String jpql = "SELECT c FROM RegistroApp c";
		Query query = em.createQuery(jpql, RegistroApp.class);
		@SuppressWarnings("unchecked")
		List<RegistroApp> listado = query.getResultList();
		return listado;
	}

}
