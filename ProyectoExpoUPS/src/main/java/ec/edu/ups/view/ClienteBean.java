package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.bussiness.ClienteBussiness;
import ec.edu.ups.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {

	@Inject
	private ClienteBussiness reBussines;

	@Inject
	private FacesContext facesContext;

	private Cliente newCliente;

	private int id; // Parametro para edicion

	private boolean editing; // Se utiliza para determinar si se esta editando o creando un nuevo cliente

	private List<Cliente> clientes;

	@PostConstruct
	public void init() {
		newCliente = new Cliente();
		newCliente.setTipoIdentificacion("cedula");

		editing = false;
		clientes = reBussines.getClientes();
		id = 0;

	}

	////////////

	public void loadData() {
		// System.out.println("load data " + id);
		if (id == 0)
			return;

		try {
			newCliente = reBussines.getCliente(id);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String editar(Cliente cli) {
		editing = true;
		return "Create-Cliente?faces-redirect=true&id=" + cli.getId();
	}

	public String guardar() {

		// Creando el password para el usuario:
		newCliente.setPassword(newCliente.getNumeroIdentificacion());

		try {
			if (editing) {
				reBussines.update(newCliente);
				System.out.println("Registro Modificado");
			} else {
				reBussines.save(newCliente);
				System.out.println("Registro Guardado");
			}
			return "Create-Cliente?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}

	public String borrar(int id) {

		try {
			reBussines.delete(id);
			System.out.println("eliminado");
			return "Create-Cliente?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

//

	/////////////

	public ClienteBussiness getReBussines() {
		return reBussines;
	}

	public void setReBussines(ClienteBussiness reBussines) {
		this.reBussines = reBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Cliente getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Cliente newCliente) {
		this.newCliente = newCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

}
