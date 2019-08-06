package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;

@Stateless
public class AspiranteBussiness {
	@Inject
	private AspiranteDAO dao;

	public boolean save(Aspirante aspirante) throws Exception {
		Aspirante aux = dao.read(aspirante.getCedula());
		if (aux != null)
			throw new Exception("Aspirante ya Registrada");
		else
			dao.insert(aspirante);

		return true;
	}

	public List<Aspirante> getAspirantes() {

		return dao.getAspirantes();
	}

	public void delete(String cedula) throws Exception {
		Aspirante aux = dao.read(cedula);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(cedula);
	}

	public boolean update(Aspirante aspirante) throws Exception {
		Aspirante aux = dao.read(aspirante.getCedula());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(aspirante);

		return true;
	}

	public Aspirante getAspirante(String cedula) throws Exception {
		Aspirante aux = dao.read(cedula);
		if (aux == null)
			throw new Exception("Aspirante no existe");
		else
			return aux;
	}

}
