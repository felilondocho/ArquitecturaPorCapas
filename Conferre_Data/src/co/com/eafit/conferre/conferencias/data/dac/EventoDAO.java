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
import co.com.eafit.conferre.conferencias.data.to.EventoTO;

public class EventoDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public EventoDAO(Connection conn2){
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		EventoTO ev = null;
		
		try{
			ev = (EventoTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO eventos values(?,?,?,?,?,?)");
			
			prep.setString(2, ev.getNamae());
			prep.setString(3, ev.getDescripcion());
			Date fecha = new Date(ev.getFecha().getTime());
			prep.setDate(4, fecha);
			prep.setInt(5, ev.getNumSillas());
			prep.setString(6, ev.getIdConferencia());
			
			do{
				UUID id = UUID.randomUUID();
				ev.setId(id.toString());
				prep.setString(1, ev.getId());
			}while(prep.executeUpdate() == 0);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ev;
	}

	@Override
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros) {
		
		EventoTO ev = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			ev = (EventoTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM eventos WHERE id = ? OR namae = ? OR descripcion = ? OR fecha = ? "
					+ "OR numSillas = ? OR idConferencia = ?");
			prep.setString(1, ev.getId());
			prep.setString(2, ev.getNamae());
			prep.setString(3, ev.getDescripcion());
			Date fecha = new Date(ev.getFecha().getTime());
			prep.setDate(4, fecha);
			prep.setInt(5, ev.getNumSillas());
			prep.setString(6, ev.getIdConferencia());
			
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				EventoTO fila = new EventoTO();
				fila.setId(res2.getString("id"));
				fila.setNamae(res2.getString("namae"));
				fila.setDescripcion(res2.getString("descripcion"));
				fila.setFecha(res2.getDate("fecha"));
				fila.setNumSillas(res2.getInt("numSillas"));
				fila.setIdConferencia(res2.getString("idConferencia"));
				res.add(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ObjetoTO update(ObjetoTO nuevoObjeto) {
		
		EventoTO ev = null;
		try{
			ev = (EventoTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE eventos SET namae = ?, descripcion = ?, fecha = ?, numSillas = ?, "
					+ "idConferencia = ?");
			prep.setString(1, ev.getNamae());
			prep.setString(2, ev.getDescripcion());
			Date fecha = new Date(ev.getFecha().getTime());
			prep.setDate(3, fecha);
			prep.setInt(4, ev.getNumSillas());
			prep.setString(5, ev.getIdConferencia());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ev;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		EventoTO ev = null;
		int r = 0;
		try{
			ev = (EventoTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM eventos WHERE id = ?");
			prep.setString(1, ev.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
