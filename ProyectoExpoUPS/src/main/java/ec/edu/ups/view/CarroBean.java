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

import ec.edu.ups.bussiness.CarroBussiness;
import ec.edu.ups.bussiness.ClienteBussiness;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.Cliente;

@ManagedBean
@ViewScoped
public class CarroBean {

	@Inject
	private CarroBussiness carBussines;

	@Inject
	private FacesContext facesContext;

	@Inject
	private ClienteBussiness cliBussiness;

	private Carro newCarro;

	private List<Carro> listaCarros;

	private boolean edit;

	private int id; // Parametro para edicion

	private List<SelectItem> listaClientesCbx;

	private List<Cliente> listaClientes;

	private int idCliente = 0;

	// FOTO
	private String nombreFoto;

	@PostConstruct
	public void init() {
		newCarro = new Carro();
		listaCarros = carBussines.getCarros();
		edit = false;
		id = 0;
		listaClientes = cliBussiness.getClientes();
		listaClientesCbx = new ArrayList<SelectItem>();
		cargarCbx();
	}

	////////////

	public void loadData() {

		// System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newCarro = carBussines.getCarro(id);//
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String guardar() {
		try {

			if (edit) {
				carBussines.update(newCarro);
				System.out.println("Registro Modificado");
			} else {
				newCarro.setFacturado("no"); // Cuando un carro nuevo es agregado se guarda como pendiente de cobro por
												// publicidad
				// foto

				// fis = new FileInputStream(nombreFoto);
				// this.longitudBytes = (int) nombreFoto.length();

				System.out.println("path: " + this.nombreFoto);

				/// fin foto
				Cliente auxCliente = cliBussiness.getCliente(idCliente);
				newCarro.setCliente(auxCliente);

				carBussines.save(newCarro);
				System.out.println("Registro Guardado");
			}
			return "Create-Carro?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}

	public String borrar(int id) {

		try {
			carBussines.delete(id);
			System.out.println("eliminado");
			return "Create-Carro?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Carro car) {
		edit = true;
		return "Create-Carro?faces-redirect=true&id=" + car.getId();
	}

	public List<Carro> carrosPorFacturar() {
		List<Carro> listaCarrosAux = new ArrayList<Carro>();
		for (Carro i : carBussines.getCarros()) {
			if (i.getFacturado().equalsIgnoreCase("no")) {
				listaCarrosAux.add(i);
			}
		}
		return listaCarrosAux;
	}

	public String cargarCbx() {
		listaClientesCbx.clear();
		for (Cliente i : listaClientes) {
			listaClientesCbx.add(new SelectItem(i.getId(), i.getNombre() + " " + i.getApellido()));
		}
		return null;
	}

//
	/////////////

	public CarroBussiness getCarBussines() {
		return carBussines;
	}

	public void setCarBussines(CarroBussiness carBussines) {
		this.carBussines = carBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Carro getNewCarro() {
		return newCarro;
	}

	public void setNewCarro(Carro newCarro) {
		this.newCarro = newCarro;
	}

	public List<Carro> getCarros() {
		return listaCarros;
	}

	public void setCarros(List<Carro> carros) {
		this.listaCarros = carros;
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

	public List<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(List<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
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
