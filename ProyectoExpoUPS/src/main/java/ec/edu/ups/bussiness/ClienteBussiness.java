package ec.edu.ups.bussiness;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.RegistroApp;


@Stateless
public class ClienteBussiness {

	@Inject
	private ClienteDAO dao;
	
	@Inject
	private RegistroAppBussiness registroAppBussiness;
	
	
	public Cliente getPropietarioCarro(String idCarro){
		List<Cliente> listCli=dao.getClientes();
		
		int id=0;
		for(Cliente cliente:listCli) {
			for(Carro carro:cliente.getListaCarro()) {
				if(carro.getId()==Integer.parseInt(idCarro)) {
					id=cliente.getId();
					break;
				}				
			}		
		}
		
		Cliente auxCliente = dao.read(id);
		
		if (auxCliente == null) {
			return null;
		}else {
			return auxCliente;
		}
	}
	

	public boolean save(Cliente cliente) throws Exception {
		Cliente aux = dao.read(cliente.getId());
		if (aux != null)
			throw new Exception("Cliente ya Registrada");
		else
			dao.insert(cliente);

		return true;
	}

	public List<Cliente> getClientes() {

		return dao.getClientes();
	}
	
	
	/*
	 * Metodo que recibe un numero de cedula de un cliente
	 * Responde con un objeto cliente en el caso de existir
	 * Agrega un registro de inicio de sesion a la tabla registroapp en DB
	 */
	public Cliente registrarLogCliente(String id) throws Exception {

		Cliente auxCliente = dao.read(Integer.parseInt(id));
		if (auxCliente == null) {
			return null;
		}else {
			RegistroApp reg=new RegistroApp();
			reg.setCliente(auxCliente);
			
			reg.setActividad("Inicio de Sesion");
			
		    DateFormat formatoFecha = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    Date today = Calendar.getInstance().getTime();
		    String fecha = formatoFecha.format(today);		    
		    reg.setFecha(fecha);
		    
		    reg.setComentario("");
		    
		    registroAppBussiness.save(reg);
			return auxCliente;
		}
	}
	
	
	public Cliente getCredencialesLogin(String cedula) throws Exception {
		List<Cliente> listCli=dao.getClientes();
		int id=0;
		for(Cliente c:listCli) {
			if(c.getNumeroIdentificacion().equalsIgnoreCase(cedula)) {
				id=c.getId();
				break;
			}		
		}
		
		Cliente auxCliente = dao.read(id);
		
		if (auxCliente == null) {
			return null;
		}else {
			return auxCliente;
		}
	}
	

	public void delete(int id) throws Exception {
		Cliente aux = dao.read(id);

		if (aux == null)
			throw new Exception("registro no existe");
		else
			dao.remove(id);
	}

	public boolean update(Cliente cliente) throws Exception {
		Cliente aux = dao.read(cliente.getId());
		if (aux == null)
			throw new Exception("Registro no existe en update");
		else
			dao.update(cliente);

		return true;
	}

	public Cliente getCliente(int id) throws Exception {
		Cliente aux = dao.read(id);
		if (aux == null)
			throw new Exception("Cliente no existe");
		else
			return aux;
	}

}
