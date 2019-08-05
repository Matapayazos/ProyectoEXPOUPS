package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.bussiness.UniversidadBussiness;
import ec.edu.ups.bussiness.UniversidadBussiness;
import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Universidad;
import ec.edu.ups.model.Usuario;

@ManagedBean
@ViewScoped
public class UniversidadBean {

	@Inject
	private UniversidadBussiness reBussines;

	@Inject
	private FacesContext facesContext;

	private Universidad newUniversidad;

	private int id; // Parametro para edicion

	private boolean editing; // Se utiliza para determinar si se esta editando o creando un nuevo universidad

	private List<Universidad> universidads;

	@PostConstruct
	public void init() {
		newUniversidad = new Universidad();
		editing = false;
		universidads = reBussines.getUniversidads();
		id = 0;

		Universidad uniPP = new Universidad();
		uniPP.setNombre("Universidad Politécnica Salesiana");
		uniPP.setSede("Cuenca");
		uniPP.setDireccion("Calle Vieja 12-30 y Elia Liut");
		uniPP.setTelefono("(+593) 74135250");
		try {
			if (universidads.size() == 0) {
				reBussines.save(uniPP);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	////////////

	public void loadData() {
		// System.out.println("load data " + id);
		if (id == 0)
			return;

		try {
			newUniversidad = reBussines.getUniversidad(id);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String editar(Universidad cli) {
		editing = true;
		return "Create-Universidad?faces-redirect=true&id=" + cli.getId();
	}

	public String guardar() {

		try {
			if (editing) {
				reBussines.update(newUniversidad);
				System.out.println("Registro Modificado");
			} else {
				reBussines.save(newUniversidad);
				System.out.println("Registro Guardado");
			}
			return "Create-Universidad?faces-redirect=true";
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
			return "Create-Universidad?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

//

	/////////////

	public UniversidadBussiness getReBussines() {
		return reBussines;
	}

	public void setReBussines(UniversidadBussiness reBussines) {
		this.reBussines = reBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Universidad getNewUniversidad() {
		return newUniversidad;
	}

	public void setNewUniversidad(Universidad newUniversidad) {
		this.newUniversidad = newUniversidad;
	}

	public List<Universidad> getUniversidads() {
		return universidads;
	}

	public void setUniversidads(List<Universidad> universidads) {
		this.universidads = universidads;
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
