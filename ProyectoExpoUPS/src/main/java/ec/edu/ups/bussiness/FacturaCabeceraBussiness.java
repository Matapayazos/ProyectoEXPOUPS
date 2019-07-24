package ec.edu.ups.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.FacturaCabeceraDAO;
import ec.edu.ups.model.FacturaCabecera;

@Stateless
public class FacturaCabeceraBussiness {

	@Inject
	private FacturaCabeceraDAO dao;

	public boolean save(FacturaCabecera facturaCabecera) throws Exception {
		FacturaCabecera aux = dao.read(facturaCabecera.getId());
		if (aux != null)
			throw new Exception("FacturaCabecera ya Registrada");
		else
			dao.insert(facturaCabecera);

		return true;
	}

	public List<FacturaCabecera> getFacturaCabeceras() {

		return dao.getFacturaCabeceras();
	}

	public void delete(int id) throws Exception {
		FacturaCabecera aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(FacturaCabecera facturaCabecera) throws Exception {
		FacturaCabecera aux = dao.read(facturaCabecera.getId());
		if (aux == null)
			throw new Exception("Registro ya existe");
		else
			dao.update(facturaCabecera);

		return true;
	}

}
