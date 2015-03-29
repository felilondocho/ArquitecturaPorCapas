package co.com.eafit.conferre.conferencias.data.to;

import java.util.Date;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class ConferenciaTO implements ObjetoTO {
	
	private String id;
	private String nombre;
	private String nombreConferencista;
	private String tipo;
	private Date fecha;
	private String lugar;
	private int sillasDisponibles;
	
	public String getNombre() {
		return nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreConferencista() {
		return nombreConferencista;
	}
	public void setNombreConferencista(String nombreConferencista) {
		this.nombreConferencista = nombreConferencista;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getSillasDisponibles() {
		return sillasDisponibles;
	}
	public void setSillasDisponibles(int sillasDisponibles) {
		this.sillasDisponibles = sillasDisponibles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
