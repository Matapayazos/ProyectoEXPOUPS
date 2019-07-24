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
import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.RegistroApp;

@Stateless
public class CarreraBussiness {
	
	@Inject
	private CarreraDAO dao;

	@Inject
	private ClienteBussiness bCliente;

	@Inject
	private RegistroAppBussiness registroAppBussiness;

	public boolean save(Carrera carrera) throws Exception {
		Carrera aux = dao.read(carrera.getId());
		if (aux != null)
			throw new Exception("Carrera ya Registrada");
		else
			dao.insert(carrera);
		return true;
	}

	public List<Carrera> getCarreras() {
		return dao.getCarreras();
	}

	public List<RegistroApp> getComentarios() {
		List<RegistroApp> auxLista = new ArrayList<RegistroApp>();
		
		for (RegistroApp r : registroAppBussiness.getRegistroApps()) {
			if (r.getActividad().equalsIgnoreCase("comentario")) {
				auxLista.add(r);
			}
		}
		
		return auxLista;
	}

	public void delete(int id) throws Exception {
		Carrera aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Carrera carrera) throws Exception {
		Carrera aux = dao.read(carrera.getId());
		if (aux == null)
			throw new Exception("Registro no existe");
		else
			dao.update(carrera);
		return true;
	}

	public Carrera getCarrera(int id) throws Exception {
		Carrera aux = dao.read(id);
		if (aux == null)
			throw new Exception("Carrera no existe");
		else
			return aux;
	}

}
