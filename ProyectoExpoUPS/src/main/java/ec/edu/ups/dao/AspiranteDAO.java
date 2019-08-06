package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;

@Stateless
public class AspiranteDAO {

	@Inject
	private EntityManager em;

	public void insert(Aspirante aspirante) {
		em.persist(aspirante);

	}

	public void update(Aspirante aspirante) {
		em.merge(aspirante);

	}

	public void remove(String cedula) {
		em.remove(this.read(cedula));

	}

	public Aspirante read(String cedula) {
		Aspirante aspirante = em.find(Aspirante.class, cedula);
		return aspirante;
	}
	public Aspirante Login(String email,String password) {

		String jpql = "SELECT c FROM Aspirante c Where c.email= :email AND c.contrasenia= :password ";
		Query query = em.createQuery(jpql, Aspirante.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		
		Aspirante l = (Aspirante)query.getSingleResult();
		return l;
	}

	public List<Aspirante> getAspirantes() {

		String jpql = "SELECT c FROM Aspirante c";
		Query query = em.createQuery(jpql, Aspirante.class);
		@SuppressWarnings("unchecked")
		List<Aspirante> listado = query.getResultList();
		return listado;
	}
}
