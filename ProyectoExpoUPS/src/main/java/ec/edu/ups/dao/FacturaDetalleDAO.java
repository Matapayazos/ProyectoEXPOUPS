package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.FacturaDetalle;

@Stateless
public class FacturaDetalleDAO {

	@Inject
	private EntityManager em;

	public void insert(FacturaDetalle facturaDetalle) {
		em.persist(facturaDetalle);

	}

	public void update(FacturaDetalle facturaDetalle) {
		em.merge(facturaDetalle);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public FacturaDetalle read(int id) {
		FacturaDetalle facturaDetalle = em.find(FacturaDetalle.class, id);
		return facturaDetalle;
	}

	public List<FacturaDetalle> getFacturaDetalles() {

		String jpql = "SELECT f FROM FacturaDetalle f";
		Query query = em.createQuery(jpql, FacturaDetalle.class);
		@SuppressWarnings("unchecked")
		List<FacturaDetalle> listado = query.getResultList();
		return listado;
	}

}
