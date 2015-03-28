package co.com.eafit.conferre.conferencias.business;

import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public interface UnitOfWork {
	public ObjetoTO ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork;
}
