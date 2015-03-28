package co.com.eafit.conferre.conferencia.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import co.com.eafit.conferre.conferencia.web.model.Espacio;
import co.com.eafit.conferre.conferencias.business.ConferenciasFacade;

@ManagedBean
public class VistaListaEspacios {
	private List<Espacio> espacios;
	private ConferenciasFacade confFacade;
	
	@PostConstruct
	public void init(){
		espacios = confFacade.obtenerEspacios();
	}
	
	
	public List<Espacio> getEspacios() {
		return espacios;
	}
	public void setEspacios(List<Espacio> espacios) {
		this.espacios = espacios;
	}
	public Espacio getEspacio() {
		return espacio;
	}
	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}
	private Espacio espacio;
	
}
