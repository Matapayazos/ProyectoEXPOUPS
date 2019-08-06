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

import ec.edu.ups.bussiness.InscripcionBussiness;
import ec.edu.ups.bussiness.AspiranteBussiness;
import ec.edu.ups.bussiness.CarreraBussiness;
import ec.edu.ups.model.Inscripcion;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Carrera;

@ManagedBean
@ViewScoped
public class InscripcionBean {
	
	@Inject
	private InscripcionBussiness carBussines;

	@Inject
	private FacesContext facesContext;

	@Inject
	private CarreraBussiness cliBussiness;

	private Inscripcion newInscripcion;

	private List<Inscripcion> listaInscripcions;

	private boolean edit;

	private int id; // Parametro para edicion

	private List<SelectItem> listaCarrerasCbx;

	private List<Carrera> listaCarreras;

	private int idCarrera = 0;
	
	private String cedulaAspirante = "";
	
	@Inject
	private AspiranteBussiness aspiranteBussiness;
	
	private String encontrado;
	
	private Aspirante newAspiranteTemp;

	// FOTO
	private String nombreFoto;

	@PostConstruct
	public void init() {
		newInscripcion = new Inscripcion();
		listaInscripcions = carBussines.getInscripcions();
		edit = false;
		id = 0;
		
		newAspiranteTemp = new Aspirante();
		newAspiranteTemp.setCedula(" ");
		
		listaCarreras = cliBussiness.getCarreras();
		listaCarrerasCbx = new ArrayList<SelectItem>();
		cargarCbx();
	}
	
	public String loadAspirante(String cedula) {
		newAspiranteTemp = new Aspirante();
		try {
			if (aspiranteBussiness.getAspirante(cedula) == null) {
				encontrado = "Estudiante no encontrado verifique la Cédula";
			} else {
				newAspiranteTemp = aspiranteBussiness.getAspirante(cedula);
				encontrado = "Estudiante encontrado";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	////////////

	public void loadData() {

		// System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newInscripcion = carBussines.getInscripcion(id);//
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
				carBussines.update(newInscripcion);
				System.out.println("Registro Modificado");
			} else {
				Carrera auxCarrera = cliBussiness.getCarrera(idCarrera);
				newInscripcion.setCarrera(auxCarrera);
				newInscripcion.setAspirante(newAspiranteTemp);

				carBussines.save(newInscripcion);
				System.out.println("Registro Guardado");
			}
			return "Create-Inscripcion?faces-redirect=true";
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
			return "Create-Inscripcion?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Inscripcion car) {
		edit = true;
		return "Create-Inscripcion?faces-redirect=true&id=" + car.getId();
	}

	

	public String cargarCbx() {
		listaCarrerasCbx.clear();
		for (Carrera i : listaCarreras) {
			listaCarrerasCbx.add(new SelectItem(i.getId(), i.getNombre() + " "));
		}
		return null;
	}

//
	/////////////

	public InscripcionBussiness getCarBussines() {
		return carBussines;
	}

	public void setCarBussines(InscripcionBussiness carBussines) {
		this.carBussines = carBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Inscripcion getNewInscripcion() {
		return newInscripcion;
	}

	public void setNewInscripcion(Inscripcion newInscripcion) {
		this.newInscripcion = newInscripcion;
	}

	public List<Inscripcion> getInscripcions() {
		return listaInscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.listaInscripcions = inscripcions;
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

	public List<Inscripcion> getListaInscripcions() {
		return listaInscripcions;
	}

	public void setListaInscripcions(List<Inscripcion> listaInscripcions) {
		this.listaInscripcions = listaInscripcions;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public CarreraBussiness getCliBussiness() {
		return cliBussiness;
	}

	public void setCliBussiness(CarreraBussiness cliBussiness) {
		this.cliBussiness = cliBussiness;
	}

	public List<SelectItem> getListaCarrerasCbx() {
		return listaCarrerasCbx;
	}

	public void setListaCarrerasCbx(List<SelectItem> listaCarrerasCbx) {
		this.listaCarrerasCbx = listaCarrerasCbx;
	}

	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

	public int getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCedulaAspirante() {
		return cedulaAspirante;
	}

	public void setCedulaAspirante(String cedulaAspirante) {
		this.cedulaAspirante = cedulaAspirante;
	}

	public AspiranteBussiness getAspiranteBussiness() {
		return aspiranteBussiness;
	}

	public void setAspiranteBussiness(AspiranteBussiness aspiranteBussiness) {
		this.aspiranteBussiness = aspiranteBussiness;
	}

	public String getEncontrado() {
		return encontrado;
	}

	public void setEncontrado(String encontrado) {
		this.encontrado = encontrado;
	}

	public Aspirante getNewAspiranteTemp() {
		return newAspiranteTemp;
	}

	public void setNewAspiranteTemp(Aspirante newAspiranteTemp) {
		this.newAspiranteTemp = newAspiranteTemp;
	}
	
	

}
