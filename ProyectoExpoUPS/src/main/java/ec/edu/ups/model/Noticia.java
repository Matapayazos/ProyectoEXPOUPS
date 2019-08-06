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

@SuppressWarnings("serial")
@Entity
public class Noticia implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@NotEmpty
	private String titulo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date fechaNoticia;

	@NotNull
	@NotEmpty
	private String descripcion;

	@OneToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "fk_carrera")
	private Carrera carrera;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaNoticia() {
		return fechaNoticia;
	}

	public void setFechaNoticia(Date fechaNoticia) {
		this.fechaNoticia = fechaNoticia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
}