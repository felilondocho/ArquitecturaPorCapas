package co.com.eafit.conferre.conferencias.data.dac;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.base.DAOGenerico;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;
import co.com.eafit.conferre.conferencias.data.to.asistenteTO;

public class asistenteDAO implements DAOGenerico {
	
	Connection conn;
	
	public asistenteDAO(Connection conn2){
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		asistenteTO as = null;
		
		try {
			as = (asistenteTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO asistentes values(?,?,?,?)");
			
			prep.setString(2, as.getNamae());
			prep.setString(3, as.getCc());
			prep.setString(4, as.getEmail());
			
			do{
				UUID id = UUID.randomUUID();
				as.setId(id.toString());
				prep.setString(1, as.getId());
			} while (prep.executeUpdate() == 0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return as;
	}

	@Override
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros) {

		asistenteTO as = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			as = (asistenteTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM asistentes WHERE id = ? OR namae = ? OR cc =? OR email = ?");
			prep.setString(1, as.getId());
			prep.setString(2, as.getNamae());
			prep.setString(3, as.getCc());
			prep.setString(4, as.getEmail());
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				asistenteTO fila = new asistenteTO();
				fila.setId(res2.getString("id"));
				fila.setNamae(res2.getString("namae"));
				fila.setCc(res2.getString("cc"));
				fila.setEmail(res2.getString("email"));
				res.add(fila);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) {

		asistenteTO as = null;
		try{
			as = (asistenteTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE asistentes SET namae = ?, cc = ?, email = ?");
			prep.setString(1, as.getNamae());
			prep.setString(2, as.getCc());
			prep.setString(3, as.getEmail());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return as;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		asistenteTO as = null;
		int r = 0;
		try{
			as = (asistenteTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM asistentes WHERE id = ?");
			prep.setString(1, as.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
