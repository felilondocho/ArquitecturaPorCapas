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

public class ConferenciaDAO implements DAOGenerico {

	java.sql.Connection  conn;
	
	public ConferenciaDAO(Connection conn2) {
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		ConferenciaTO conf = null;
		
		try {
			conf = (ConferenciaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO conferencias values(?,?,?,?,?,?,?)");
			
			prep.setString(2, conf.getNombre());
			prep.setString(3, conf.getNombreConferencista());
			prep.setString(4, conf.getTipo());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(5, fecha);
			prep.setString(6, conf.getLugar());
			prep.setInt(7, conf.getSillasDisponibles());
			
			do{
				UUID id = UUID.randomUUID();
				conf.setId(id.toString());
				prep.setString(1, conf.getId());
			} while (prep.executeUpdate() == 0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conf;
	}

	@Override
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros) {

		ConferenciaTO conf = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			conf = (ConferenciaTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM conferencias WHERE id = ? OR nombre = ? OR nombreConferencista =? OR tipo = ?"
					+ " OR fecha = ? OR lugar = ? OR silasDisponibles = ?");
			prep.setString(1, conf.getId());
			prep.setString(2, conf.getNombre());
			prep.setString(3, conf.getNombreConferencista());
			prep.setString(4, conf.getTipo());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(5, fecha);
			prep.setString(6, conf.getLugar());
			prep.setInt(7, conf.getSillasDisponibles());
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				ConferenciaTO fila = new ConferenciaTO();
				fila.setId(res2.getString("id"));
				fila.setNombre(res2.getString("nombre"));
				fila.setNombreConferencista(res2.getString("nombreConferencista"));
				fila.setTipo(res2.getString("tipo"));
				fila.setFecha(res2.getDate("fecha"));
				fila.setLugar(res2.getString("lugar"));
				fila.setSillasDisponibles(res2.getInt("sillasDisponibles"));
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

		ConferenciaTO conf = null;
		try{
			conf = (ConferenciaTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE conferencias SET nombre = ?, nombreConferencista = ?, tipo = ?, "
					+ "fecha = ?, lugar = ?, sillasDisponibles = ?");
			prep.setString(1, conf.getNombre());
			prep.setString(2, conf.getNombreConferencista());
			prep.setString(3, conf.getTipo());
			Date fecha = new Date(conf.getFecha().getTime());
			prep.setDate(4, fecha);
			prep.setString(5, conf.getLugar());
			prep.setInt(6, conf.getSillasDisponibles());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conf;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		ConferenciaTO conf = null;
		int r = 0;
		try{
			conf = (ConferenciaTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM conferencias WHERE id = ?");
			prep.setString(1, conf.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
