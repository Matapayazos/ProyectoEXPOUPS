package ec.edu.ups.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.FacturaDetalleDAO;
import ec.edu.ups.model.FacturaDetalle;

@Stateless
public class FacturaDetalleBussiness {

	@Inject
	private FacturaDetalleDAO dao;

	public boolean save(FacturaDetalle facturaDetalle) throws Exception {
		FacturaDetalle aux = dao.read(facturaDetalle.getId());
		if (aux != null)
			throw new Exception("FacturaDetalle ya Registrada");
		else
			dao.insert(facturaDetalle);

		return true;
	}

	public List<FacturaDetalle> getFacturaDetalles() {

		return dao.getFacturaDetalles();
	}

	public void delete(int id) throws Exception {
		FacturaDetalle aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(FacturaDetalle facturaDetalle) throws Exception {
		FacturaDetalle aux = dao.read(facturaDetalle.getId());
		if (aux == null)
			throw new Exception("Registro ya existe");
		else
			dao.update(facturaDetalle);

		return true;
	}

}
