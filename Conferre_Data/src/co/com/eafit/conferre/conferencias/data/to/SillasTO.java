package co.com.eafit.conferre.conferencias.data.to;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class SillasTO implements ObjetoTO {
	
	private String id;
	private String idConf;
	private String idEv;
	private int numSilla;
	private boolean ocupado;
	private String ocupante;
	private String email;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdConf() {
		return idConf;
	}
	public void setIdConf(String idConf) {
		this.idConf = idConf;
	}
	public String getIdEv() {
		return idEv;
	}
	public void setIdEv(String idEv) {
		this.idEv = idEv;
	}
	public int getNumSilla() {
		return numSilla;
	}
	public void setNumSilla(int numSilla) {
		this.numSilla = numSilla;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public String getOcupante() {
		return ocupante;
	}
	public void setOcupante(String ocupante) {
		this.ocupante = ocupante;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	


}
