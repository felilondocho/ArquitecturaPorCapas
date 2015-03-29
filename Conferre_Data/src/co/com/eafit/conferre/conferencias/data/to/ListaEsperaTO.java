package co.com.eafit.conferre.conferencias.data.to;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class ListaEsperaTO implements ObjetoTO {
	
	public String id;
	public String ConferenciaId;
	public String namae;
	public String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getConferenciaId() {
		return ConferenciaId;
	}
	public void setConferenciaId(String conferenciaId) {
		ConferenciaId = conferenciaId;
	}
	public String getNamae() {
		return namae;
	}
	public void setNamae(String namae) {
		this.namae = namae;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
