package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CarroDAO;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.RegistroApp;

@Stateless
public class CarroBussiness {
	@Inject
	private CarroDAO dao;

	@Inject
	private ClienteBussiness bCliente;

	@Inject
	private RegistroAppBussiness registroAppBussiness;

	public boolean save(Carro carro) throws Exception {
		Carro aux = dao.read(carro.getId());
		if (aux != null)
			throw new Exception("Carro ya Registrada");
		else
			dao.insert(carro);
		return true;
	}

	public List<Carro> getCarros() {
		return dao.getCarros();
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

	public Carro registrarComentario(String idCarro, String idCliente, String comentario) throws Exception {
		Carro auxCarro = dao.read(Integer.parseInt(idCarro));
		Cliente auxCliente = bCliente.getCliente(Integer.parseInt(idCliente));

		RegistroApp reg = new RegistroApp();

		reg.setCarro(auxCarro);
		reg.setCliente(auxCliente);

		reg.setActividad("Comentario");

		DateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String fecha = formatoFecha.format(today);
		reg.setFecha(fecha);

		reg.setComentario(comentario);

		registroAppBussiness.save(reg);

		return auxCarro;
	}

	public Carro registrarLogCarro(String idCarro, String idCliente) throws Exception {
		Carro auxCarro = dao.read(Integer.parseInt(idCarro));
		Cliente auxCliente = bCliente.getCliente(Integer.parseInt(idCliente));

		RegistroApp reg = new RegistroApp();

		reg.setCarro(auxCarro);
		reg.setCliente(auxCliente);

		reg.setActividad("Carro Deseado");

		DateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String fecha = formatoFecha.format(today);
		reg.setFecha(fecha);

		reg.setComentario("");

		registroAppBussiness.save(reg);

		return auxCarro;
	}

	public void delete(int id) throws Exception {
		Carro aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Carro carro) throws Exception {
		Carro aux = dao.read(carro.getId());
		if (aux == null)
			throw new Exception("Registro no existe");
		else
			dao.update(carro);
		return true;
	}

	public Carro getCarro(int id) throws Exception {
		Carro aux = dao.read(id);
		if (aux == null)
			throw new Exception("Carro no existe");
		else
			return aux;
	}

}
