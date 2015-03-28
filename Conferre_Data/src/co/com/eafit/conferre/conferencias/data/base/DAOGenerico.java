package co.com.eafit.conferre.conferencias.data.base;

import java.util.Collection;

public interface DAOGenerico {
	
	public ObjetoTO crear(ObjetoTO parametro);
	public Collection<ObjetoTO> recuperar(ObjetoTO parametros);
	public ObjetoTO update(ObjetoTO nuevoObjeto);
	public int borrar(ObjetoTO objetoaBorrar);
	
}
