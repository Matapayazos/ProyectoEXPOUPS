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
import ec.edu.ups.model.RegistroApp;

@Stateless
public class UniversidadBussiness {
	@Inject
	private UniversidadDAO dao;
	
	@Inject
	private RegistroAppBussiness registroAppBussiness;
	
	
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
	

	public boolean save(Universidad universidad) throws Exception {
		Universidad aux = dao.read(universidad.getId());
		if (aux != null)
			throw new Exception("Universidad ya Registrada");
		else
			dao.insert(universidad);

		return true;
	}

	public List<Universidad> getUniversidads() {

		return dao.getUniversidads();
	}
	

	

	public void delete(int id) throws Exception {
		Universidad aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Universidad universidad) throws Exception {
		Universidad aux = dao.read(universidad.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(universidad);

		return true;
	}

	public Universidad getUniversidad(int id) throws Exception {
		Universidad aux = dao.read(id);
		if (aux == null)
			throw new Exception("Universidad no existe");
		else
			return aux;
	}

}
