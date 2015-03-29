package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.UsuariosTO;

public class UsuariosDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public UsuariosDAO(Connection conn2){
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		UsuariosTO usr = null;
		
		try{
			usr = (UsuariosTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO usuarios values(?,?,?,?)");
			
			prep.setString(2, usr.getUsuario());
			prep.setString(3, usr.getPassword());
			prep.setString(4, usr.getEmail());
			
			do{
				UUID id = UUID.randomUUID();
				usr.setId(id.toString());
				prep.setString(1, usr.getId());
			} while (prep.executeUpdate() == 0);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usr;
	}

	@Override
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros) {
		
		UsuariosTO usr = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			usr = (UsuariosTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM usuarios WHERE id = ? OR usuario = ? OR password = ? OR email = ?");
			prep.setString(1, usr.getId());
			prep.setString(2, usr.getUsuario());
			prep.setString(3, usr.getPassword());
			prep.setString(4, usr.getEmail());
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				UsuariosTO fila = new UsuariosTO();
				fila.setId(res2.getString("id"));
				fila.setUsuario(res2.getString("usuario"));
				fila.setPassword(res2.getString("password"));
				fila.setEmail(res2.getString("email"));
				res.add(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) {
		
		UsuariosTO usr = null;
		try{
			usr = (UsuariosTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE usuarios SET usuario = ?, password = ?, email = ?");
			prep.setString(1, usr.getUsuario());
			prep.setString(2, usr.getPassword());
			prep.setString(3, usr.getEmail());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usr;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		
		UsuariosTO usr = null;
		int r = 0;
		try{
			usr = (UsuariosTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?");
			prep.setString(1, usr.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
