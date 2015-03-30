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
import co.com.eafit.conferre.conferencias.data.to.SillasTO;

public class SillasDAO implements DAOGenerico {
	
	Connection conn;
	
	public SillasDAO(Connection conn2){
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		SillasTO as = null;
		
		try {
			as = (SillasTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO asistentes values(?,?,?,?,?,?,?)");
			
			prep.setString(2, as.getIdConf());
			prep.setString(3, as.getIdEv());
			prep.setInt(4, as.getNumSilla());
			prep.setBoolean(5, as.isOcupado());
			prep.setString(6, as.getOcupante());
			prep.setString(7, as.getEmail());
			
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

		SillasTO as = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			as = (SillasTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM asistentes WHERE id = ? OR idConf = ? OR idEv =? OR "
					+ "numSilla = ? OR ocupado = ? OR ocupante = ? OR email = ?");
			prep.setString(1, as.getId());
			prep.setString(2, as.getIdConf());
			prep.setString(3, as.getIdEv());
			prep.setInt(4, as.getNumSilla());;
			prep.setBoolean(5, as.isOcupado());
			prep.setString(6, as.getOcupante());
			prep.setString(7, as.getEmail());
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				SillasTO fila = new SillasTO();
				fila.setId(res2.getString("id"));
				fila.setIdConf(res2.getString("idConf"));
				fila.setIdEv(res2.getString("idEv"));
				fila.setNumSilla(res2.getInt("numSilla"));
				fila.setOcupado(res2.getBoolean("ocupado"));
				fila.setOcupante(res2.getString("ocupante"));
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

		SillasTO as = null;
		try{
			as = (SillasTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE asistentes SET idConf = ?, idEv = ?, numSilla = ?, "
					+ "ocupado = ?, ocupante = ?, email = ?");
			prep.setString(1, as.getIdConf());
			prep.setString(2, as.getIdEv());
			prep.setInt(3, as.getNumSilla());
			prep.setBoolean(4, as.isOcupado());
			prep.setString(5, as.getOcupante());
			prep.setString(6, as.getEmail());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return as;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		SillasTO as = null;
		int r = 0;
		try{
			as = (SillasTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM asistentes WHERE id = ?");
			prep.setString(1, as.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
