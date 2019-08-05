package ec.edu.ups.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import ec.edu.ups.bussiness.UsuarioBussiness;
import ec.edu.ups.model.Usuario;
import ec.edu.ups.util.SessionUtils;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	@Inject
	private UsuarioBussiness usuarioBussiness;

	@Inject
	private FacesContext facesContext;

	private Usuario newUsuario;

	private List<Usuario> usuarios;

	private boolean edit;

	private int id; // Parametro para edicion

	@PostConstruct
	public void init() {
		newUsuario = new Usuario();
		usuarios = usuarioBussiness.getUsuarios();
		edit = false;
		id = 0;

		Usuario usr = new Usuario();
		usr.setUsuario("admin");
		usr.setPassword("admin");
		try {
			usuarioBussiness.save(usr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index?faces-redirect=true";
	}

	public String verificarCredenciales() {
		boolean val = false;
		for (Usuario u : usuarioBussiness.getUsuarios()) {
			if (u.getUsuario().equals(newUsuario.getUsuario())) {
				if (u.getPassword().equals(newUsuario.getPassword())) {
					val = true;
					break;
				}
			}
		}

		if (val) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", newUsuario.getUsuario());
			return "Create-Carrera?faces-redirect=true";
		} else {
			return "Error?faces-redirect=true";
		}
	}

	public void loadData() {

		System.out.println("load data " + id);
		if (id == 0)
			return;
		try {
			newUsuario = usuarioBussiness.getUsuario(id);//
			edit = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public String guardar() {
		System.out.println(edit);
		try {
			System.out.println("Entra a update y el codigo vale " + newUsuario.getId());

			if (edit == true) {
				usuarioBussiness.update(newUsuario);
				System.out.println("Registro Modificado");
			} else {
				usuarioBussiness.save(newUsuario);
				System.out.println("Registro Guardado");
			}
			return "Create-Usuario?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}
		return null;
	}

	public String borrar(int id) {

		try {
			usuarioBussiness.delete(id);
			System.out.println("eliminado");
			return "Create-Usuario?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(Usuario car) {
		newUsuario = car;
		edit = true;
		return null;
	}

	public UsuarioBussiness getCarBussines() {
		return usuarioBussiness;
	}

	public void setCarBussines(UsuarioBussiness carBussines) {
		this.usuarioBussiness = carBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public Usuario getNewUsuario() {
		return newUsuario;
	}

	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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

}
