package co.com.eafit.conferre.conferencias.data.to;

import java.util.Date;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class EventoTO implements ObjetoTO {
	
	private String id;
	private String namae;
	private String descripcion;
	private Date fecha;
	private int numSillas;
	private String idConferencia;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNamae() {
		return namae;
	}
	public void setNamae(String namae) {
		this.namae = namae;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumSillas() {
		return numSillas;
	}
	public void setNumSillas(int numSillas) {
		this.numSillas = numSillas;
	}
	public String getIdConferencia() {
		return idConferencia;
	}
	public void setIdConferencia(String idConferencia) {
		this.idConferencia = idConferencia;
	}
}
