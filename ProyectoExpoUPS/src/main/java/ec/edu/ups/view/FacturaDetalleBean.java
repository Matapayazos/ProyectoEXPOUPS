package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.bussiness.FacturaDetalleBussiness;
import ec.edu.ups.model.Carro;
import ec.edu.ups.model.FacturaDetalle;

@ManagedBean
@ViewScoped
public class FacturaDetalleBean {

	@Inject
	private FacturaDetalleBussiness faccBussines;

	@Inject
	private FacesContext facesContext;

	private FacturaDetalle newFacturaDetalle;

	private List<FacturaDetalle> facturasDetalle;

	private boolean edit = false;

	private Carro newCarro;

	@PostConstruct
	public void init() {
		// newFacturaDetalle = new FacturaDetalle();
		facturasDetalle = faccBussines.getFacturaDetalles();
		// newFacturaDetalle.addFactDetalle(new FacturaDetalle());
	}

	////////////
	/*
	public String addDetalle(Carro car) {
		newFacturaDetalle = new FacturaDetalle();
		newFacturaDetalle.setCantidad(car.getCantidad());
		newFacturaDetalle.setCarro(car);
		newFacturaDetalle.setSubtotal(car.getCantidad() * car.getPrecio());
		guardar();
		return "Create-FacturaCabecera?faces-redirect=true";
	}
	*/

	public String guardar() {
		try {

			if (edit == true) {
				faccBussines.update(newFacturaDetalle);
				System.out.println("Registro Modificado");
			} else {
				faccBussines.save(newFacturaDetalle);
				System.out.println("Registro Guardado");
			}
			return "Create-FacturaCabecera?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}
		return null;
	}

	public String borrar(int id) {
		try {
			faccBussines.delete(id);
			System.out.println("eliminado");
			return "Create-FacturaDetalle?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);
			e.printStackTrace();
		}
		return null;
	}

	public String editar(FacturaDetalle cli) {
		newFacturaDetalle = cli;
		return "Create-FacturaCabecera?faces-redirect=true";
	}

//
	/////////////
	public FacturaDetalleBussiness getFaccBussines() {
		return faccBussines;
	}

	public void setFaccBussines(FacturaDetalleBussiness faccBussines) {
		this.faccBussines = faccBussines;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public FacturaDetalle getNewFacturaDetalle() {
		return newFacturaDetalle;
	}

	public void setNewFacturaDetalle(FacturaDetalle newFacturaDetalle) {
		this.newFacturaDetalle = newFacturaDetalle;
	}

	public List<FacturaDetalle> getFacturasDetalle() {
		return facturasDetalle;
	}

	public void setFacturasDetalle(List<FacturaDetalle> facturasDetalle) {
		this.facturasDetalle = facturasDetalle;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Carro getNewCarro() {
		return newCarro;
	}

	public void setNewCarro(Carro newCarro) {
		this.newCarro = newCarro;
	}

}
