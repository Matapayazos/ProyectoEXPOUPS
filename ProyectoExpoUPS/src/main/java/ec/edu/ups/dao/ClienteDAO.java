package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.model.Cliente;

@Stateless
public class ClienteDAO {

	@Inject
	private EntityManager em;

	public void insert(Cliente cliente) {
		em.persist(cliente);

	}

	public void update(Cliente cliente) {
		em.merge(cliente);

	}

	public void remove(int id) {
		em.remove(this.read(id));

	}

	public Cliente read(int id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}

	public List<Cliente> getClientes() {

		String jpql = "SELECT c FROM Cliente c";
		Query query = em.createQuery(jpql, Cliente.class);
		@SuppressWarnings("unchecked")
		List<Cliente> listado = query.getResultList();
		return listado;
	}

}
