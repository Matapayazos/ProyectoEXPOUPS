package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.FacturaCabecera;

@Stateless
public class FacturaCabeceraDAO {

	@Inject
	private EntityManager em;

	public void insert(FacturaCabecera facturaCabecera) {
		em.persist(facturaCabecera);

	}

	public void update(FacturaCabecera facturaCabecera) {
		em.merge(facturaCabecera);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public FacturaCabecera read(int id) {
		FacturaCabecera facturaCabecera = em.find(FacturaCabecera.class, id);
		return facturaCabecera;
	}

	public List<FacturaCabecera> getFacturaCabeceras() {

		String jpql = "SELECT f FROM FacturaCabecera f";
		Query query = em.createQuery(jpql, FacturaCabecera.class);
		@SuppressWarnings("unchecked")
		List<FacturaCabecera> listado = query.getResultList();
		return listado;
	}

}
