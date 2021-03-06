package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
/**
 *  Esta clase define la entidad Usuario con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * @author Cancer31
 *
 */
@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String usuario;

	@NotNull
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
