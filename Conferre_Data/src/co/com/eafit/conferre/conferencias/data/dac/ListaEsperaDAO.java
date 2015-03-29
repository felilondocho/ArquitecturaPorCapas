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
import co.com.eafit.conferre.conferencias.data.to.ListaEsperaTO;

public class ListaEsperaDAO implements DAOGenerico {
	
	java.sql.Connection conn;
	
	public ListaEsperaDAO(Connection conn2){
		this.conn = conn2;
	}

	@Override
	public ObjetoTO crear(ObjetoTO parametro) {
		ListaEsperaTO le = null;
		
		try{
			le = (ListaEsperaTO) parametro;
			PreparedStatement prep = conn.prepareStatement("INSERT INTO listaEspera values(?,?,?,?)");
			
			prep.setString(2, le.getConferenciaId());
			prep.setString(3, le.getNamae());
			prep.setString(3, le.getEmail());
			
			do{
				UUID id = UUID.randomUUID();
				le.setId(id.toString());
				prep.setString(1, le.getId());
			} while (prep.executeUpdate() == 0);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return le;
	}

	@Override
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros) {
		
		ListaEsperaTO le = null;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		PreparedStatement prep;
		try{
			le = (ListaEsperaTO) parametros;
			prep = conn.prepareStatement("SELECT * FROM listaEspera WHERE id = ? OR conferenciaId = ? OR namae = ? OR email = ?");
			prep.setString(1, le.getId());
			prep.setString(2, le.getConferenciaId());
			prep.setString(3, le.getNamae());
			prep.setString(4, le.getEmail());
			ResultSet res2 = prep.executeQuery();
			while(res2.next()){
				ListaEsperaTO fila = new ListaEsperaTO();
				fila.setId(res2.getString("id"));
				fila.setConferenciaId(res2.getString("conferenciaId"));
				fila.setNamae(res2.getString("namae"));
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
		
		ListaEsperaTO le = null;
		try{
			le = (ListaEsperaTO) nuevoObjeto;
			PreparedStatement prep = conn.prepareStatement("UPDATE listaEspera SET conferenciaId = ?, namae = ?, email = ?");
			prep.setString(1, le.getConferenciaId());
			prep.setString(2, le.getNamae());
			prep.setString(3, le.getEmail());
			int x = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return le;
	}

	@Override
	public int borrar(ObjetoTO objetoaBorrar) {
		ListaEsperaTO le = null;
		int r = 0;
		try{
			le = (ListaEsperaTO) objetoaBorrar;
			PreparedStatement prep = conn.prepareStatement("DELETE FROM listaEspera WHERE id = ?");
			prep.setString(1, le.getId());
			r = prep.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return r;
	}

}
