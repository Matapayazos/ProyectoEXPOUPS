package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.model.Estudiante;
import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.dao.AspiranteDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;
/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Aspirantes
 * @author Cancer31
 *
 */
@Stateless
public class AspiranteBussiness {
	@Inject
	private AspiranteDAO dao;
	
	/**
	 * Método para guarda Aspirantes 
	 * @param aspirante el nuevo aspirante a ser guardado 
	 * de tipo Aspirante
	 * @return retorna true si se ha agregado corectamente un aspirante
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean save(Aspirante aspirante) throws Exception {
		Aspirante aux = dao.read(aspirante.getCedula());
		if (aux != null)
			throw new Exception("Aspirante ya Registrada");
		else
			dao.insert(aspirante);

		return true;
	}
	
	/**
	 * Lista de Aspirantes
	 * @return Retorna una lista de Aspirantes
	 */

	public List<Aspirante> getAspirantes() {

		return dao.getAspirantes();
	}
	/**
	 * Método para eliminar un aspirante por medio de su cedula
	 * @param cedula cedula del aspirante de tipo String 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public void delete(String cedula) throws Exception {
		Aspirante aux = dao.read(cedula);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(cedula);
	}
	/**
	 * Método para actualizar los aspirantes
	 * @param aspirante aspirante de tipo aspirante
	 * @return retorna true si se ha actualizado corectamente un aspirante
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean update(Aspirante aspirante) throws Exception {
		Aspirante aux = dao.read(aspirante.getCedula());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(aspirante);

		return true;
	}
	/**
	 * Metodo para listar aspirantes 
	 * @param cedula
	 * @return
	 * @throws Exception
	 */

	public Aspirante getAspirante(String cedula) throws Exception {
		Aspirante aux = dao.read(cedula);
		if (aux == null)
			throw new Exception("Aspirante no existe");
		else
			return aux;
	}
	/**
	 * Metodo para logueo del aspirante 
	 * @param email correo electrónico correspondiente al aspirante  
	 * de tipo string
	 * @param password contrasenia del aspirnate de tipo string 
	 * @return retorna true si la contraselnia y correo son correctos 
	 * caso contrario retorna un false
	 */
	public Boolean Login(String email,String password )  {
		Aspirante aux = dao.Login(email, password);
		if (aux == null) {
			return false;
			
		}else {
			return true;
		}
			

	}
	
}
