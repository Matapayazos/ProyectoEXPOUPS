package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;
spirante aspirante) {
		em.merge(aspirante);

	}

	/**
	 * 
	 * @param cedula
	 */
	public void remove(String cedula) {
		em.remove(this.read(cedula));

	}

	/**
	 * lasita aspirante por cedula
	 * @param cedula cedula del aspirante
	 * @return retoena un aspirante 
	 */
	public Aspirante read(String cedula) {
		Aspirante aspirante = em.find(Aspirante.class, cedula);
		return aspirante;
	}
	/**
	 * Logue de los aspirantes
	 * @param email correo electronico del aspirante
	 * @param password contrasenia del aspirante
	 * @return
	 */
	public Aspirante Login(String email,String password) {

		String jpql = "SELECT c FROM Aspirante c Where c.email= :email AND c.contrasenia= :password ";
		Query query = em.createQuery(jpql, Aspirante.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		@SuppressWarnings("unchecked")
		
		Aspirante l = (Aspirante)query.getSingleResult();
		return l;
	}

	/**
	 * lista de aspirantes
	 * @return retonea una lista de aspirantes
	 */
	public List<Aspirante> getAspirantes() {

		String jpql = "SELECT c FROM Aspirante c";
		Query query = em.createQuery(jpql, Aspirante.class);
		@SuppressWarnings("unchecked")
		List<Aspirante> listado = query.getResultList();
		return listado;
	}
}
