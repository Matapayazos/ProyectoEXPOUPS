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

import ec.edu.ups.bussiness.CarreraBussiness;
import ec.edu.ups.bussiness.CarreraBussiness;
import ec.edu.ups.bussiness.UniversidadBussiness;
import ec.edu.ups.bussiness.UniversidadBussiness;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Carrera;
import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;

@ManagedBean
@ViewScoped
public class CarreraBean {

	@Inject
	private CarreraBussiness carBussines;

	@Inject
	private FacesContext facesContext;

	@Inject
	private UniversidadBussiness cliBussiness;

	private Carrera newCarrera;

	private List<Carrera> listaCarreras;

	private boolean edit;

	private int id; // Parametro para edicion

	private List<SelectItem> listaUniversidadsCbx;

	private List<Universidad> listaUniversidads;

	private int idUniversidad = 0;

	// FOTO
	private String nombreFoto;

	@PostConstruct
	public void init() {
		newCarrera = new Carrera();
		listaCarreras = carBussines.getCarreras();
		edit = false;
		id = 0;
		listaUniversidads = cliBussiness.getUniversidads();
		listaUniversidadsCbx = new ArrayList<SelectItem>();
		cargarCbx();
	}

	////////////

	public void loadData() {

		// System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newCarrera = carBussines.getCarrera(id);//
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
				carBussines.update(newCarrera);
				System.out.println("Registro Modificado");
			} else {
				Universidad auxUniversidad = cliBussiness.getUniversidad(idUniversidad);
				newCarrera.setUniversidad(auxUniversidad);

				carBussines.save(newCarrera);
				System.out.println("Registro Guardado");
			}
			return "Create-Carrera?faces-redirect=true";
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
			return "Create-Carrera?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Carrera car) {
		edit = true;
		return "Create-Carrera?faces-redirect=true&id=" + car.getId();
	}

	public String cargarCbx() {
		listaUniversidadsCbx.clear();
		for (Universidad i : listaUniversidads) {
			listaUniversidadsCbx.add(new SelectItem(i.getId(), i.getNombre() + " - " + i.getSede()));
		}
		return null;
	}

//
	/////////////

	public CarreraBussiness getCarBussines() {
		return carBussines;
	}

	public void setCarBussines(CarreraBussiness carBussines) {
		this.carBussines = carBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Carrera getNewCarrera() {
		return newCarrera;
	}

	public void setNewCarrera(Carrera newCarrera) {
		this.newCarrera = newCarrera;
	}

	public List<Carrera> getCarreras() {
		return listaCarreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.listaCarreras = carreras;
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

	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public UniversidadBussiness getCliBussiness() {
		return cliBussiness;
	}

	public void setCliBussiness(UniversidadBussiness cliBussiness) {
		this.cliBussiness = cliBussiness;
	}

	public List<SelectItem> getListaUniversidadsCbx() {
		return listaUniversidadsCbx;
	}

	public void setListaUniversidadsCbx(List<SelectItem> listaUniversidadsCbx) {
		this.listaUniversidadsCbx = listaUniversidadsCbx;
	}

	public List<Universidad> getListaUniversidads() {
		return listaUniversidads;
	}

	public void setListaUniversidads(List<Universidad> listaUniversidads) {
		this.listaUniversidads = listaUniversidads;
	}

	public int getIdUniversidad() {
		return idUniversidad;
	}

	public void setIdUniversidad(int idUniversidad) {
		this.idUniversidad = idUniversidad;
	}
}
