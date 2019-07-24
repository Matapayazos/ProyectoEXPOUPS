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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class Carro implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@NotEmpty
	private String marca;

	@NotNull
	@NotEmpty
	private String modelo;

	@NotNull
	@NotEmpty
	private String placa;

	@NotNull(message = "Por favor ingrese el precio del vehiculo")
	private double precio;
	
	@NotNull
	@NotEmpty
	private String facturado;
	
	@NotNull
	@NotEmpty
	private String anio;
	
    @Column(name="foto")
    private byte[] foto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idDuenio")
	@JsonIgnore
	private Cliente cliente;

	@OneToMany(mappedBy = "carro", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<FacturaDetalle> listaFacCabecera;
	
	@OneToMany(mappedBy = "carro", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	Set<RegistroApp> listaRegistroApp;
	//private List<RegistroApp> listaRegistroApp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getListaFacCabecera() {
		return listaFacCabecera;
	}

	public void setListaFacCabecera(List<FacturaDetalle> listaFacCabecera) {
		this.listaFacCabecera = listaFacCabecera;
	}

	public String getFacturado() {
		return facturado;
	}

	public void setFacturado(String facturado) {
		this.facturado = facturado;
	}

	public Set<RegistroApp> getListaRegistroApp() {
		return listaRegistroApp;
	}

	public void setListaRegistroApp(Set<RegistroApp> listaRegistroApp) {
		this.listaRegistroApp = listaRegistroApp;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
	
	

}
