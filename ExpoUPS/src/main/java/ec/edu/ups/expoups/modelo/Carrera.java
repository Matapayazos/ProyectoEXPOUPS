package ec.edu.ups.expoups.modelo;
@Entity
public class Carrera {
    @Id
    private int ID;
    @Column(length=100)
  	private String Nombre;
    @Column(length=100)
  	private String Titulo;
    @Column(length=500)
  	private String Descripcion;
    @Column(length=100)
  	private String Modalidad;
    @Column(length=100)
  	private String Sede;
    @Column(length=100)
  	private String Duraccion;


  	public Carreras() {

  	}
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
  	public String getTitulo() {
  		return Titulo;
  	}
  	public void setTitulo(String titulo) {
  		Titulo = titulo;
  	}
  	public String getDescripcion() {
  		return Descripcion;
  	}
  	public void setDescripcion(String descripcion) {
  		Descripcion = descripcion;
  	}
  	public String getModalidad() {
  		return Modalidad;
  	}
  	public void setModalidad(String modalidad) {
  		Modalidad = modalidad;
  	}
  	public String getSede() {
  		return Sede;
  	}
  	public void setSede(String sede) {
  		Sede = sede;
  	}
  	public String getDuraccion() {
  		return Duraccion;
  	}
  	public void setDuraccion(String duraccion) {
  		Duraccion = duraccion;
  	}
  	@Override
  	public String toString() {
  		return "Carreras [ID=" + ID + ", Nombre=" + Nombre + ", Titulo=" + Titulo + ", Descripcion=" + Descripcion
  				+ ", Modalidad=" + Modalidad + ", Sede=" + Sede + ", Duraccion=" + Duraccion + "]";
  	}
}
