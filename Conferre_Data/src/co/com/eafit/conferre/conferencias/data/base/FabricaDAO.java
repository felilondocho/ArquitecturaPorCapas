package co.com.eafit.conferre.conferencias.data.base;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.ListaEsperaDAO;
import co.com.eafit.conferre.conferencias.data.dac.UsuariosDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillasDAO;

public class FabricaDAO {
	
	public static ConferenciaDAO createConferenciaDAO(){
		Connection conn = crearConexion();
		return new ConferenciaDAO(conn);
	}
	
	public static EventoDAO createEventoDAO(){
		Connection conn = crearConexion();
		return new EventoDAO(conn);
	}
	
	public static ListaEsperaDAO createListaEsperaDAO(){
		Connection conn = crearConexion();
		return new ListaEsperaDAO(conn);
	}
	
	public static UsuariosDAO createUsuariosDAO(){
		Connection conn = crearConexion();
		return new UsuariosDAO(conn);
	}
	
	public static SillasDAO createSillasDAO(){
		Connection conn = crearConexion();
		return new SillasDAO(conn);
	}
	
	public static Connection crearConexion(){
		Driver driver;
		Connection conn = null;
		try {
			driver = DriverManager.getDriver("com.mysql.Driver");
			conn = driver.connect("mysql://localhost:3693", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

}
