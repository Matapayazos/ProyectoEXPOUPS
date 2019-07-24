package ec.edu.ups.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import ec.edu.ups.bussiness.CarroBussiness;
import ec.edu.ups.bussiness.ClienteBussiness;
import ec.edu.ups.bussiness.FacturaCabeceraBussiness;
import ec.edu.ups.bussiness.FacturaDetalleBussiness;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.Cliente;
import ec.edu.ups.model.FacturaCabecera;
import ec.edu.ups.model.FacturaDetalle;

@ManagedBean
@ViewScoped
public class FacturaCabeceraBean {

	@Inject
	private FacturaCabeceraBussiness facCbussiness;

	@Inject
	private ClienteBussiness cliBussiness;

	@Inject
	private FacturaDetalleBussiness fDetalleBussiness;

	@Inject
	private CarroBussiness cBussiness;

	@Inject
	private FacesContext facesContext;

	private FacturaCabecera newFacturaCabecera;

	private FacturaDetalle newFactDetalle;

	private List<FacturaCabecera> listaFcabecera;

	private List<Cliente> listaClientes;

	private List<SelectItem> listaClientesCbx;

	private int idCliente = 0;

	@PostConstruct
	public void init() {
		newFacturaCabecera = new FacturaCabecera();
		listaFcabecera = facCbussiness.getFacturaCabeceras();
		listaClientes = cliBussiness.getClientes();
		listaClientesCbx = new ArrayList<SelectItem>();
		cargarCbx();
	}

	/*
	 * Metodo que permite agregar los carros a la lista de detalles
	 */
	public String addDetalle(Carro carro) throws Exception {
		newFactDetalle = new FacturaDetalle();
		newFactDetalle.setCantidad(1);
		newFactDetalle.setCarro(carro);
		newFactDetalle.setSubtotal(carro.getPrecio());
		newFactDetalle.setFacturaCabecera(newFacturaCabecera);
		newFacturaCabecera.getListaFacDetalles().add(newFactDetalle);

		// Se cambia el estado en el campo facturado para que ya no se muestre en la
		// tabla vehiculos
		// Pendientes de facturacion
		Carro c = cBussiness.getCarro(carro.getId());
		c.setFacturado("si");
		cBussiness.update(c);
		return null;
	}

	/*
	 * Metodo que permite crear una nueva Factura
	 */
	public String Facturar() {
		try {

			double sumaSubtotales = 0;
			for (FacturaDetalle f : newFacturaCabecera.getListaFacDetalles()) {
				sumaSubtotales += f.getSubtotal(); // Suma los subtotales de cada detalle
			}

			if (sumaSubtotales > 0) { // Valida que la factura no este vacia
				SimpleDateFormat formatoFecha = new SimpleDateFormat("d-M-yy");
				Date fecha = formatoFecha.parse("07-02-19");
				newFacturaCabecera.setFecha(fecha);

				Cliente auxCliente = cliBussiness.getCliente(idCliente);
				newFacturaCabecera.setCliente(auxCliente);

				newFacturaCabecera.setSumaSubtotales(sumaSubtotales);
				newFacturaCabecera.setIva(sumaSubtotales * 0.12);
				newFacturaCabecera.setTotal(sumaSubtotales + (sumaSubtotales * 0.12));

				facCbussiness.save(newFacturaCabecera); // Guarda la factura cabecera y todas los detalles

				return "Create-Factura?faces-redirect=true";
			} else {
				FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Factura con saldo", "0");
				facesContext.addMessage(null, m);
			}
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}
		return null;
	}

	public String borrar(int id) {
		try {
			facCbussiness.delete(id);
			System.out.println("eliminado");
			return "Create-Factura?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Metodo que permite cargar los cientes en el combo box de la pagina clientes
	 * debe ser invocado en el contructor
	 */
	public String cargarCbx() {
		listaClientesCbx.clear();
		for (Cliente i : listaClientes) {
			listaClientesCbx.add(new SelectItem(i.getId(), i.getNombre() + " " + i.getApellido()));
		}
		return null;
	}

	/////////////

	public FacturaCabeceraBussiness getFaccBussines() {
		return facCbussiness;
	}

	public void setFaccBussines(FacturaCabeceraBussiness faccBussines) {
		this.facCbussiness = faccBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public FacturaCabecera getNewFacturaCabecera() {
		return newFacturaCabecera;
	}

	public void setNewFacturaCabecera(FacturaCabecera newFacturaCabecera) {

		this.newFacturaCabecera = newFacturaCabecera;
	}

	public List<FacturaCabecera> getFacturasCabecera() {
		return listaFcabecera;
	}

	public void setFacturasCabecera(List<FacturaCabecera> facturasCabecera) {
		this.listaFcabecera = facturasCabecera;
	}

	public ClienteBussiness getCliBussines() {
		return cliBussiness;
	}

	public void setCliBussines(ClienteBussiness cliBussines) {
		this.cliBussiness = cliBussines;
	}

	public FacturaDetalleBussiness getfDetalleBussines() {
		return fDetalleBussiness;
	}

	public void setfDetalleBussines(FacturaDetalleBussiness fDetalleBussines) {
		this.fDetalleBussiness = fDetalleBussines;
	}

	public FacturaDetalle getNewFactDetalle() {
		return newFactDetalle;
	}

	public void setNewFactDetalle(FacturaDetalle newFactDetalle) {
		this.newFactDetalle = newFactDetalle;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public FacturaCabeceraBussiness getFacCbussiness() {
		return facCbussiness;
	}

	public void setFacCbussiness(FacturaCabeceraBussiness facCbussiness) {
		this.facCbussiness = facCbussiness;
	}

	public ClienteBussiness getCliBussiness() {
		return cliBussiness;
	}

	public void setCliBussiness(ClienteBussiness cliBussiness) {
		this.cliBussiness = cliBussiness;
	}

	public FacturaDetalleBussiness getfDetalleBussiness() {
		return fDetalleBussiness;
	}

	public void setfDetalleBussiness(FacturaDetalleBussiness fDetalleBussiness) {
		this.fDetalleBussiness = fDetalleBussiness;
	}

	public List<FacturaCabecera> getListaFcabecera() {
		return listaFcabecera;
	}

	public void setListaFcabecera(List<FacturaCabecera> listaFcabecera) {
		this.listaFcabecera = listaFcabecera;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<SelectItem> getListaClientesCbx() {
		return listaClientesCbx;
	}

	public void setListaClientesCbx(List<SelectItem> listaClientesCbx) {
		this.listaClientesCbx = listaClientesCbx;
	}

}
