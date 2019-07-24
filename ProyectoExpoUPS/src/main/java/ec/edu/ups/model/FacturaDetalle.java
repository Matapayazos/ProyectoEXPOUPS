package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class FacturaDetalle implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private int cantidad;

	@NotNull
	private double subtotal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfcabecera")
	@JsonIgnore
	private FacturaCabecera facturaCabecera;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCarro")
	@JsonIgnore
	private Carro carro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public FacturaCabecera getFacturaCabecera() {
		return facturaCabecera;
	}

	public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
		this.facturaCabecera = facturaCabecera;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

}
