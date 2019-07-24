package ec.edu.ups.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.model.Usuario;

@Stateless
public class UsuarioBussiness {

	@Inject
	private UsuarioDAO dao;

	public boolean save(Usuario usuario) throws Exception {
		Usuario aux = dao.read(usuario.getId());
		if (aux != null)
			throw new Exception("Usuario ya Registrada");
		else
			dao.insert(usuario);

		return true;
	}

	public List<Usuario> getUsuarios() {

		return dao.getUsuarios();
	}	

	public void delete(int id) throws Exception {
		Usuario aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Usuario usuario) throws Exception {
		Usuario aux = dao.read(usuario.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(usuario);

		return true;
	}

	public Usuario getUsuario(int id) throws Exception {
		Usuario aux = dao.read(id);
		if (aux == null)
			throw new Exception("Usuario no existe");
		else
			return aux;
	}

}
