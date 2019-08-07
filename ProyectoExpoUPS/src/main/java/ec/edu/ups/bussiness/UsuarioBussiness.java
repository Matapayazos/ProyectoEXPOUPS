package ec.edu.ups.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.model.Usuario;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Usuario
 * @author Cancer31
 *
 */
@Stateless
public class UsuarioBussiness {

	@Inject
	private UsuarioDAO dao;

	/**
	 * Método para guardar Usuarios
	 * @param usuario nuevo usuario de tipo usuario
	 * @returnretorna true si se ha agregado corectamente un aspirante
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean save(Usuario usuario) throws Exception {
		Usuario aux = dao.read(usuario.getId());
		if (aux != null)
			throw new Exception("Usuario ya Registrada");
		else
			dao.insert(usuario);

		return true;
	}

	/**
	 * lista de usuarios
	 * @return retorna una lista de usuarios
	 */
	public List<Usuario> getUsuarios() {

		return dao.getUsuarios();
	}	

	/**
	 * Método para eliminar un usuario
	 * @param id id del usuario de tipo int 
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public void delete(int id) throws Exception {
		Usuario aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	/**
	 * Método para actualizar usuarios
	 * @param usuario de tipo usuario
	 * @returnretorna true si se ha actualizado corectamente un aspirante
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public boolean update(Usuario usuario) throws Exception {
		Usuario aux = dao.read(usuario.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(usuario);

		return true;
	}

	/**
	 * listar usaurios
	 * @param id
	 * @return
	 * @throws Exception indica que este método es capaz de lanzar una
	 * Exception del tipo Exception (padre de todas las excepciones).
	 */
	public Usuario getUsuario(int id) throws Exception {
		Usuario aux = dao.read(id);
		if (aux == null)
			throw new Exception("Usuario no existe");
		else
			return aux;
	}

}
