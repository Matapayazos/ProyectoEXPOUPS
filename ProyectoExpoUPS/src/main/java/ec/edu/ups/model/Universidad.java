package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 *  Esta clase define la entidad Universidad con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * @author Cancer31
 *
 */
@SuppressWarnings("serial")
@Entity
public class Universidad implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[^0-9]*", message = "El nombre no debe contener numeros")
	private String nombre;

	@NotNull
	@NotEmpty
	private String sede;

	@NotNull
	@NotEmpty
	private String direccion;

	@NotNull
	@NotEmpty
	private String telefono;



	
	@OneToMany(mappedBy = "universidad", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Carrera> listaCarrera;

	/*
	@OneToMany(mappedBy = "universidad", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<Aspirante> listaAspirante;
	*/

	

	
	
	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	

	
	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

	/*
	public List<Aspirante> getListaAspirante() {
		return listaAspirante;
	}

	public void setListaAspirante(List<Aspirante> listaAspirante) {
		this.listaAspirante = listaAspirante;
	}
	*/

}
