package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Usuario;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad Usuario
 * @author Cancer31
 *
 */
@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param usuario
	 */
	public void insert(Usuario usuario) {
		em.persist(usuario);

	}

	/**
	 * 
	 * @param usuario
	 */
	public void update(Usuario usuario) {
		em.merge(usuario);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * listar usuarios por id
	 * @param id id del usuario
	 * @return retorna un usuario
	 */
	public Usuario read(int id) {
		Usuario usuario = em.find(Usuario.class, id);
		return usuario;
	}
	/**
	 * lista de usuarios
	 * @return retorna una lista de usuarios
	 */
	
	public List<Usuario> getUsuarios() {

		String jpql = "SELECT c FROM Usuario c";
		Query query = em.createQuery(jpql, Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> listado = query.getResultList();
		return listado;
	}

}
