package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@NotEmpty
	private String tipoIdentificacion;

	@NotNull
	@NotEmpty
	private String numeroIdentificacion;

	@NotNull
	@NotEmpty
	private String nombre;

	@NotNull
	@NotEmpty
	private String apellido;

	@NotNull
	@NotEmpty
	private String telefono;

	@NotNull
	@NotEmpty
	private String direccion;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	private String password;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Carro> listaCarro;

	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<FacturaCabecera> listaFacCabecera;
	
	@OneToMany(mappedBy = "cliente", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	Set<RegistroApp> listaRegistroApp;
	//private List<RegistroApp> listaRegistroApp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Carro> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}

	public List<FacturaCabecera> getListaFacCabecera() {
		return listaFacCabecera;
	}

	public void setListaFacCabecera(List<FacturaCabecera> listaFacCabecera) {
		this.listaFacCabecera = listaFacCabecera;
	}

	public Set<RegistroApp> getListaRegistroApp() {
		return listaRegistroApp;
	}

	public void setListaRegistroApp(Set<RegistroApp> listaRegistroApp) {
		this.listaRegistroApp = listaRegistroApp;
	}

	
	

}
