package ec.edu.ups.expoups.modelo;
@Entity
public class Evento {
  @Id
  private String ID;
  @Column(length=30)
	private String Codigo;
  @Column(length=30)
	private String Nombre;
  @Column(length=30)
	private String Ubicacion;


}
