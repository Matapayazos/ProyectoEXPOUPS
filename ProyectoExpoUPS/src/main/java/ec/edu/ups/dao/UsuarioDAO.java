package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Usuario;

@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;

	public void insert(Usuario usuario) {
		em.persist(usuario);

	}

	public void update(Usuario usuario) {
		em.merge(usuario);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Usuario read(int id) {
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}
	
	public List<Usuario> getUsuarios() {

		String jpql = "SELECT c FROM Usuario c";
		Query query = em.createQuery(jpql, Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> listado = query.getResultList();
		return listado;
	}

}
