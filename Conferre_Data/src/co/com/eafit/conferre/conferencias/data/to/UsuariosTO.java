package co.com.eafit.conferre.conferencias.data.to;

import java.util.Date;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;

public class UsuariosTO implements ObjetoTO {
	
	public String id;
	public String usuario;
	public String password;
	public String email;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
