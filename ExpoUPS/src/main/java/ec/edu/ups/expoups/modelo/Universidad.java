package ec.edu.ups.expoups.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Universidad {
	@Id
	private String Nombre;
	
	private String Direccion;
	private String Telefono;

	//@OneToMany(mappedBy="jola")
	//private List<Aspirante> aspirantes;
	@ManyToOne
	@JoinColumn(name="Uni_Asp")
	private List<Aspirante> aspirantes;
	
	public Universidad() {
		
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	

	
}
