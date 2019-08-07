package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CarreraDAO;
import ec.edu.ups.dao.CarreraDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Carrera;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Carrera
 * @author Cancer31
 *
 */
@Stateless
public class CarreraBussiness {
	
	@Inject
	private CarreraDAO dao;
	
	/**
	 * Método para guardar carreras
	 * @param carrera la nueva carrera
	 * @return retorna true si se ha agregado corectamente un aspirante
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean save(Carrera carrera) throws Exception {
		Carrera aux = dao.read(carrera.getId());
		if (aux != null)
			throw new Exception("Carrera ya Registrada");
		else
			dao.insert(carrera);
		return true;
	}
	
	/**
	 * Lista de Aspirantes
	 * @return Retorna una lista de carreras
	 */

	public List<Carrera> getCarreras() {
		return dao.getCarreras();
	}

	/**
	 * Método para eliminar un carrera por medio de su id
	 * @param id de la carrera de tipo int
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public void delete(int id) throws Exception {
		Carrera aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar una carrera
	 * @param carrera de tipo carrera
	 * @return retorna true si se ha actualizado corectamente
	 * @throws Exception Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Carrera carrera) throws Exception {
		Carrera aux = dao.read(carrera.getId());
		if (aux == null)
			throw new Exception("Registro no existe");
		else
			dao.update(carrera);
		return true;
	}

	/**
	 * Metodo para listar carrera
	 * @param id
	 * @return
	 * @throws Exception Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public Carrera getCarrera(int id) throws Exception {
		Carrera aux = dao.read(id);
		if (aux == null)
			throw new Exception("Carrera no existe");
		else
			return aux;
	}

}
