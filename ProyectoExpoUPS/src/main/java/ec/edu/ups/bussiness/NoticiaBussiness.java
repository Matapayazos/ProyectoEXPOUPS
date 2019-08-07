package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.NoticiaDAO;
import ec.edu.ups.dao.NoticiaDAO;
import ec.edu.ups.dao.NoticiaDAO;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Noticia;
import ec.edu.ups.model.Noticia;
import ec.edu.ups.model.Noticia;


/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Noticia
 * @author Cancer31
 *
 */
@Stateless
public class NoticiaBussiness {
	@Inject
	private NoticiaDAO dao;
	
	/**
	 * Método para guardar noticias
	 * @param noticia la nueva noticia a ser guardada
	 * @return Método para guardar 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */

	public boolean save(Noticia noticia) throws Exception {
		Noticia aux = dao.read(noticia.getId());
		if (aux != null)
			throw new Exception("Noticia ya Registrada");
		else
			dao.insert(noticia);

		return true;
	}

	/**
	 * lista de noticias
	 * @return retorna una lista de noticias
	 */
	public List<Noticia> getNoticias() {

		return dao.getNoticias();
	}

	/**
	 * Método para eliminar una noticia 
	 * @param id id de la noticia de tipo int
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public void delete(int id) throws Exception {
		Noticia aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar noticias
	 * @param noticia de tipo noticia
	 * @return retorna true si se ha actualizado corectamente
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Noticia noticia) throws Exception {
		Noticia aux = dao.read(noticia.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(noticia);

		return true;
	}

	/**
	 * Listar noticias
	 * @param id
	 * @return
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public Noticia getNoticia(int id) throws Exception {
		Noticia aux = dao.read(id);
		if (aux == null)
			throw new Exception("Noticia no existe");
		else
			return aux;
	}

}
