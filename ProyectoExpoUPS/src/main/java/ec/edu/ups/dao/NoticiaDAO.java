package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Noticia;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad noticia
 * @author Cancer31
 *
 */
@Stateless
public class NoticiaDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param noticia
	 */
	public void insert(Noticia noticia) {
		em.persist(noticia);

	}

	/**
	 * 
	 * @param noticia
	 */
	public void update(Noticia noticia) {
		em.merge(noticia);

	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		em.remove(this.read(id));

	}

	/**
	 * listar noticia por id
	 * @param id id de la noticia
	 * @return retorna una noticia
	 */
	public Noticia read(int id) {
		Noticia noticia = em.find(Noticia.class, id);
		return noticia;
	}

	/**
	 * lista de noticias
	 * @return retorna una lista de noticias
	 */
	public List<Noticia> getNoticias() {

		String jpql = "SELECT c FROM Noticia c";
		Query query = em.createQuery(jpql, Noticia.class);
		@SuppressWarnings("unchecked")
		List<Noticia> listado = query.getResultList();
		return listado;
	}
}
