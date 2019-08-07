package ec.edu.ups.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *  Esta clase define la entidad Evento con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * @author Cancer31
 *
 */
@SuppressWarnings("serial")
@Entity
public class Evento implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@NotEmpty
	private String nombre;

	@NotNull
	@NotEmpty
	private String descripcion;

	@NotNull
	@NotEmpty
	private String ubicacion;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@NotNull
	@NotEmpty
	private String hora;

	@OneToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "fk_carrera")
	private Carrera carrera;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

}
