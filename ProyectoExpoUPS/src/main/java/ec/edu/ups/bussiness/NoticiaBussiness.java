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


@Stateless
public class NoticiaBussiness {
	@Inject
	private NoticiaDAO dao;

	public boolean save(Noticia noticia) throws Exception {
		Noticia aux = dao.read(noticia.getId());
		if (aux != null)
			throw new Exception("Noticia ya Registrada");
		else
			dao.insert(noticia);

		return true;
	}

	public List<Noticia> getNoticias() {

		return dao.getNoticias();
	}

	public void delete(int id) throws Exception {
		Noticia aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Noticia noticia) throws Exception {
		Noticia aux = dao.read(noticia.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(noticia);

		return true;
	}

	public Noticia getNoticia(int id) throws Exception {
		Noticia aux = dao.read(id);
		if (aux == null)
			throw new Exception("Noticia no existe");
		else
			return aux;
	}

}
