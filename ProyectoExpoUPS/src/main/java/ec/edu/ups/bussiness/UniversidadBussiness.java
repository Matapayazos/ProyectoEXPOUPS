package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.UniversidadDAO;
import ec.edu.ups.dao.UniversidadDAO;
import ec.edu.ups.dao.UniversidadDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Universidad
 * @author Cancer31
 *
 */
@Stateless
public class UniversidadBussiness {
	@Inject
	private UniversidadDAO dao;
	
	/**
	 * Método para listar las universidades que tiene una carrera especifica
	 * @param idCarrera id de la carrera de tipo int 
	 * @return
	 */
	
	public Universidad getPropietarioCarrera(String idCarrera){
		List<Universidad> listCli=dao.getUniversidads();
		
		int id=0;
		for(Universidad universidad:listCli) {
			for(Carrera carrera:universidad.getListaCarrera()) {
				if(carrera.getId()==Integer.parseInt(idCarrera)) {
					id=universidad.getId();
					break;
				}				
			}		
		}
		
		Universidad auxUniversidad = dao.read(id);
		
		if (auxUniversidad == null) {
			return null;
		}else {
			return auxUniversidad;
		}
	}
	
	/**
	 * Método para guardar Universidades
	 * @param universidad del tipo universidad
	 * @return retorna true si se ha agregado corectamente
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean save(Universidad universidad) throws Exception {
		Universidad aux = dao.read(universidad.getId());
		if (aux != null)
			throw new Exception("Universidad ya Registrada");
		else
			dao.insert(universidad);

		return true;
	}

	/**
	 * lista de universidades
	 * @return retorna una lista de universidades
	 */
	public List<Universidad> getUniversidads() {

		return dao.getUniversidads();
	}
	

	/**
	 * Método para eliminar una universidad 
	 * @param id id de la universidad de tipo int 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public void delete(int id) throws Exception {
		Universidad aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar universidades
	 * @param universidad univerdiada a actualizar de tipo universidad
	 * @return retorna true si se ha actualizado corectamente
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Universidad universidad) throws Exception {
		Universidad aux = dao.read(universidad.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(universidad);

		return true;
	}

	/**
	 * listar universidades
	 * @param id
	 * @return
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public Universidad getUniversidad(int id) throws Exception {
		Universidad aux = dao.read(id);
		if (aux == null)
			throw new Exception("Universidad no existe");
		else
			return aux;
	}

}
