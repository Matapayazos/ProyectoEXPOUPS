package ec.edu.ups.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Noticia;

@Stateless
public class NoticiaDAO {

	@Inject
	private EntityManager em;

	public void insert(Noticia noticia) {
		em.persist(noticia);

	}

	public void update(Noticia noticia) {
		em.merge(noticia);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Noticia read(int id) {
		Noticia noticia = em.find(Noticia.class, id);
		return noticia;
	}

	public List<Noticia> getNoticias() {

		String jpql = "SELECT c FROM Noticia c";
		Query query = em.createQuery(jpql, Noticia.class);
		@SuppressWarnings("unchecked")
		List<Noticia> listado = query.getResultList();
		return listado;
	}
}
