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

import ec.edu.ups.bussiness.EventoBussiness;
import ec.edu.ups.bussiness.CarreraBussiness;
import ec.edu.ups.model.Evento;
import ec.edu.ups.model.Carrera;

@ManagedBean
@ViewScoped
public class EventoBean {

	@Inject
	private EventoBussiness carBussines;

	@Inject
	private FacesContext facesContext;

	@Inject
	private CarreraBussiness cliBussiness;

	private Evento newEvento;

	private List<Evento> listaEventos;

	private boolean edit;

	private int id; // Parametro para edicion

	private List<SelectItem> listaCarrerasCbx;

	private List<Carrera> listaCarreras;

	private int idCarrera = 0;

	// FOTO
	private String nombreFoto;

	@PostConstruct
	public void init() {
		newEvento = new Evento();
		listaEventos = carBussines.getEventos();
		edit = false;
		id = 0;
		listaCarreras = cliBussiness.getCarreras();
		listaCarrerasCbx = new ArrayList<SelectItem>();
		cargarCbx();
	}

	////////////

	public void loadData() {

		// System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newEvento = carBussines.getEvento(id);//
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
				carBussines.update(newEvento);
				System.out.println("Registro Modificado");
			} else {
				Carrera auxCarrera = cliBussiness.getCarrera(idCarrera);
				newEvento.setCarrera(auxCarrera);

				carBussines.save(newEvento);
				System.out.println("Registro Guardado");
			}
			return "Create-Evento?faces-redirect=true";
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
			return "Create-Evento?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Evento car) {
		edit = true;
		return "Create-Evento?faces-redirect=true&id=" + car.getId();
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

	public EventoBussiness getCarBussines() {
		return carBussines;
	}

	public void setCarBussines(EventoBussiness carBussines) {
		this.carBussines = carBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Evento getNewEvento() {
		return newEvento;
	}

	public void setNewEvento(Evento newEvento) {
		this.newEvento = newEvento;
	}

	public List<Evento> getEventos() {
		return listaEventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.listaEventos = eventos;
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

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
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

}
