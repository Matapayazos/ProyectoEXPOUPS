package ec.edu.ups.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import ec.edu.ups.bussiness.ClienteBussiness;
import ec.edu.ups.bussiness.RegistroAppBussiness;
import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.RegistroApp;

@ManagedBean
@ViewScoped
public class RegistroAppBean {

	@Inject
	private RegistroAppBussiness registroAppBussiness;

	@Inject
	private FacesContext facesContext;

	@Inject
	private ClienteBussiness cliBussiness;

	private RegistroApp newRegistroApp;

	private List<RegistroApp> listaRegistrosApp;

	private boolean edit;

	private int id; // Parametro para edicion

	private List<SelectItem> listaClientesCbx;

	private List<Cliente> listaClientes;

	private int idCliente = 0;

	@PostConstruct
	public void init() {
		newRegistroApp = new RegistroApp();
		edit = false;
		id = 0;
		listaClientes = cliBussiness.getClientes();
		listaClientesCbx = new ArrayList<SelectItem>();
		cargarCbx();
		listaRegistrosApp = registroAppBussiness.getRegistroApps();

	}

	public String cargarRegistrosPorPersona() {
		listaRegistrosApp.clear();
		System.out.println("cuales el problema");
		return null;
	}

	public String cargarTodosRegistros() {
		listaRegistrosApp = registroAppBussiness.getRegistroApps();
		return null;
	}

	public String cargarCbx() {
		listaClientesCbx.clear();
		for (Cliente i : listaClientes) {
			listaClientesCbx.add(new SelectItem(i.getId(), i.getNombre() + " " + i.getApellido()));
		}
		return null;
	}

	public void loadData() {

		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newRegistroApp = registroAppBussiness.getRegistroApp(id);//
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public List<RegistroApp> listarRegistrosApp() {
		return registroAppBussiness.getRegistroApps();
	}

	public String guardar() {
		System.out.println(edit);
		try {
			System.out.println("Entra a update y el codigo vale " + newRegistroApp.getId());

			if (edit == true) {
				registroAppBussiness.update(newRegistroApp);
				System.out.println("Registro Modificado");
			} else {
				registroAppBussiness.save(newRegistroApp);
				System.out.println("Registro Guardado");
			}
			return "Create-RegistroApp?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}
		return null;
	}

	public String borrar(int id) {

		try {
			registroAppBussiness.delete(id);
			System.out.println("eliminado");
			return "Create-RegistroApp?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(RegistroApp car) {
		newRegistroApp = car;
		edit = true;
		return null;
	}

	public RegistroAppBussiness getRegistroAppBussiness() {
		return registroAppBussiness;
	}

	public void setRegistroAppBussiness(RegistroAppBussiness registroAppBussiness) {
		this.registroAppBussiness = registroAppBussiness;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public RegistroApp getNewRegistroApp() {
		return newRegistroApp;
	}

	public void setNewRegistroApp(RegistroApp newRegistroApp) {
		this.newRegistroApp = newRegistroApp;
	}

	public List<RegistroApp> getListaRegistrosApp() {
		return listaRegistrosApp;
	}

	public void setListaRegistrosApp(List<RegistroApp> listaRegistrosApp) {
		this.listaRegistrosApp = listaRegistrosApp;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClienteBussiness getCliBussiness() {
		return cliBussiness;
	}

	public void setCliBussiness(ClienteBussiness cliBussiness) {
		this.cliBussiness = cliBussiness;
	}

	public List<SelectItem> getListaClientesCbx() {
		return listaClientesCbx;
	}

	public void setListaClientesCbx(List<SelectItem> listaClientesCbx) {
		this.listaClientesCbx = listaClientesCbx;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}
