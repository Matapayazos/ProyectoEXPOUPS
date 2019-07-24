package ec.edu.ups.expoups.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Aspirante {

	@Id
	@Column(unique=true, nullable=false)
	private int ID;
	@Column(length=100)
	private String Nombre;
	@Column(length=100)
	private String Apellido;
	@Column(length=100)
	private String Direccion;
	@Column(length=10)
	private String Telefono;
	private int Edad;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nac")
	private Date Fecha_Nacimiento;

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
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
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public Date getFecha_Nacimiento() {
		return Fecha_Nacimiento;
	}
	public void setFecha_Nacimiento(Date fecha_Nacimiento) {
		Fecha_Nacimiento = fecha_Nacimiento;
	}
	@Override
	public String toString() {
		return "Aspirante [ID=" + ID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Direccion=" + Direccion
				+ ", Telefono=" + Telefono + ", Edad=" + Edad + ", Fecha_Nacimiento=" + Fecha_Nacimiento + "]";
	}


}
