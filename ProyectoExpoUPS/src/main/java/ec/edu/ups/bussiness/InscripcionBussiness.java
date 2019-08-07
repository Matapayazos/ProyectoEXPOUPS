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

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * @author Cancer31
 *
 */
@Stateless
public class InscripcionBussiness {
	@Inject
	private InscripcionDAO dao;

	/**
	 * Método para guardar inscripciones 
	 * @param inscripcion la nueva inscripcion de tipo inscripcion
	 * @return etorna true si se ha agregado corectamente
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean save(Inscripcion inscripcion) throws Exception {
		Inscripcion aux = dao.read(inscripcion.getId());
		if (aux != null)
			throw new Exception("Inscripcion ya Registrada");
		else
			dao.insert(inscripcion);

		return true;
	}
	/**
	 * lista de inscripciones 
	 * @return retorna una lista de inscripciones
	 */

	public List<Inscripcion> getInscripcions() {

		return dao.getInscripcions();
	}
	/**
	 * Método para eliminar una inscripcion 
	 * @param id id de la inscripcion de tipo int 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public void delete(int id) throws Exception {
		Inscripcion aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar inscripciones
	 * @param inscripcion inscripcion de tipo inscripcion
	 * @return retorna true si se ha actualizado corectamente 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Inscripcion inscripcion) throws Exception {
		Inscripcion aux = dao.read(inscripcion.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(inscripcion);

		return true;
	}

	/**
	 * Listar inscripciones
	 * @param id
	 * @return
	 * @throws Exception  indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public Inscripcion getInscripcion(int id) throws Exception {
		Inscripcion aux = dao.read(id);
		if (aux == null)
			throw new Exception("Inscripcion no existe");
		else
			return aux;
	}

}
