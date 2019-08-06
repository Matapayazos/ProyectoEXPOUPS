package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.bussiness.AspiranteBussiness;
import ec.edu.ups.bussiness.AspiranteBussiness;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Aspirante;
import ec.edu.ups.model.Usuario;

@ManagedBean
@ViewScoped
public class AspiranteBean {

	@Inject
	private AspiranteBussiness reBussines;

	@Inject
	private FacesContext facesContext;

	private Aspirante newAspirante;

	private String cedula; // Parametro para edicion

	private boolean editing; // Se utiliza para determinar si se esta editando o creando un nuevo aspirante

	private List<Aspirante> aspirantes;

	@PostConstruct
	public void init() {
		newAspirante = new Aspirante();
		

		editing = false;
		aspirantes = reBussines.getAspirantes();
		cedula  = "";

	}

	////////////

	public void loadData() {
		// System.out.println("load data " + id);
		if (cedula.equals(""))
			return;

		try {
			newAspirante = reBussines.getAspirante(cedula);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String editar(Aspirante cli) {
		editing = true;
		return "Create-Aspirante?faces-redirect=true&id=" + cli.getCedula();
	}

	public String guardar() {



		try {
			if (editing) {
				reBussines.update(newAspirante);
				System.out.println("Registro Modificado");
			} else {
				System.out.println("_______________________");
				System.out.println("Llego al AspiranteBean > guardar > save > linea78");
				System.out.println("_______________________");
				reBussines.save(newAspirante);
				System.out.println("Registro Guardado");
			}
			return "Create-Aspirante?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}

	public String borrar(String cedula) {

		try {
			reBussines.delete(cedula);
			System.out.println("eliminado");
			return "Create-Aspirante?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

//

	/////////////

	public AspiranteBussiness getReBussines() {
		return reBussines;
	}

	public void setReBussines(AspiranteBussiness reBussines) {
		this.reBussines = reBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Aspirante getNewAspirante() {
		return newAspirante;
	}

	public void setNewAspirante(Aspirante newAspirante) {
		this.newAspirante = newAspirante;
	}

	public List<Aspirante> getAspirantes() {
		return aspirantes;
	}

	public void setAspirantes(List<Aspirante> aspirantes) {
		this.aspirantes = aspirantes;
	}

	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

}
