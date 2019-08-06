package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.InscripcionDAO;
import ec.edu.ups.dao.InscripcionDAO;
import ec.edu.ups.dao.InscripcionDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Inscripcion;


@Stateless
public class InscripcionBussiness {
	@Inject
	private InscripcionDAO dao;

	public boolean save(Inscripcion inscripcion) throws Exception {
		Inscripcion aux = dao.read(inscripcion.getId());
		if (aux != null)
			throw new Exception("Inscripcion ya Registrada");
		else
			dao.insert(inscripcion);

		return true;
	}

	public List<Inscripcion> getInscripcions() {

		return dao.getInscripcions();
	}

	public void delete(int id) throws Exception {
		Inscripcion aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Inscripcion inscripcion) throws Exception {
		Inscripcion aux = dao.read(inscripcion.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(inscripcion);

		return true;
	}

	public Inscripcion getInscripcion(int id) throws Exception {
		Inscripcion aux = dao.read(id);
		if (aux == null)
			throw new Exception("Inscripcion no existe");
		else
			return aux;
	}

}
