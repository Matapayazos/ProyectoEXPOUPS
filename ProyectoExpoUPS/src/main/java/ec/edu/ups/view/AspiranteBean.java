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

	private int id; // Parametro para edicion

	private boolean editing; // Se utiliza para determinar si se esta editando o creando un nuevo aspirante

	private List<Aspirante> aspirantes;

	@PostConstruct
	public void init() {
		newAspirante = new Aspirante();
		

		editing = false;
		aspirantes = reBussines.getAspirantes();
		id = 0;

	}

	////////////

	public void loadData() {
		// System.out.println("load data " + id);
		if (id == 0)
			return;

		try {
			newAspirante = reBussines.getAspirante(id);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String editar(Aspirante cli) {
		editing = true;
		return "Create-Aspirante?faces-redirect=true&id=" + cli.getId();
	}

	public String guardar() {



		try {
			if (editing) {
				reBussines.update(newAspirante);
				System.out.println("Registro Modificado");
			} else {
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

	public String borrar(int id) {

		try {
			reBussines.delete(id);
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
