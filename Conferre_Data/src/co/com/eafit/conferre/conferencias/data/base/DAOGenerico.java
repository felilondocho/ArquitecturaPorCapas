package co.com.eafit.conferre.conferencias.data.base;

/*
*	En base a esta interfaz, se hacen las clases DAO, en donde 
*	se hacen las operaciones de CRUD de cada tabla de la base de datos
*/

import java.util.Collection;

public interface DAOGenerico {
	
	public ObjetoTO crear(ObjetoTO parametro);
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros);
	public ObjetoTO update(ObjetoTO nuevoObjeto);
	public int borrar(ObjetoTO objetoaBorrar);
	
}
