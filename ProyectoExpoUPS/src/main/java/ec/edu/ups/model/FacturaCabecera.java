package ec.edu.ups.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
public class FacturaCabecera implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@NotNull
	private double sumaSubtotales;

	@NotNull
	private double iva;

	@NotNull
	private double total;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	@JsonIgnore
	private Cliente cliente;

	@OneToMany(mappedBy = "facturaCabecera", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private List<FacturaDetalle> listaFacDetalles = new ArrayList<FacturaDetalle>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getSumaSubtotales() {
		return sumaSubtotales;
	}

	public void setSumaSubtotales(double sumaSubtotales) {
		this.sumaSubtotales = sumaSubtotales;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getListaFacDetalles() {
		return listaFacDetalles;
	}

	public void setListaFacDetalles(List<FacturaDetalle> listaFacDetalles) {
		this.listaFacDetalles = listaFacDetalles;
	}

}
