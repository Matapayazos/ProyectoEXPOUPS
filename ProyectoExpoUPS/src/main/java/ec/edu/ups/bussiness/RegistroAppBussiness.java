package ec.edu.ups.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.RegistroAppDAO;
import ec.edu.ups.model.RegistroApp;

@Stateless
public class RegistroAppBussiness {

	@Inject
	private RegistroAppDAO dao;
	
	
	public boolean save(RegistroApp registroApp) throws Exception {
		RegistroApp aux = dao.read(registroApp.getId());
		if (aux != null)
			throw new Exception("RegistroApp ya Registrada");
		else
			dao.insert(registroApp);

		return true;
	}
	
	

	public List<RegistroApp> getRegistroApps() {

		return dao.getRegistroApps();
	}	

	public void delete(int id) throws Exception {
		RegistroApp aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(RegistroApp registroApp) throws Exception {
		RegistroApp aux = dao.read(registroApp.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(registroApp);

		return true;
	}

	public RegistroApp getRegistroApp(int id) throws Exception {
		RegistroApp aux = dao.read(id);
		if (aux == null)
			throw new Exception("RegistroApp no existe");
		else
			return aux;
	}


}
