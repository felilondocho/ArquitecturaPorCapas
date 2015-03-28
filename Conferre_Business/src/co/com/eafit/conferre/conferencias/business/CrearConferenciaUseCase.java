package co.com.eafit.conferre.conferencias.business;

import java.util.UUID;

import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ConferenciaDAO;
import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class CrearConferenciaUseCase implements UnitOfWork {

	@Override
	public ObjetoTO ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork {
		ConferenciaTO conferenciaTO = (ConferenciaTO) parametros;
		ConferenciaTO resultado = null;
		try {
			
			validarDatosConferencia(conferenciaTO);
			ConferenciaDAO conferenciaDAO = FabricaDAO.createConferenciaDAO();
			UUID id = UUID.randomUUID();
			conferenciaTO.setId(id.toString());
			resultado = (ConferenciaTO) conferenciaDAO.crear(conferenciaTO);
			
		} catch (ExcepcionValidacion e) {
			throw new ExcepcionUnitOfWork(e);
		}
		
		return resultado;
	}

	private void validarDatosConferencia(ConferenciaTO conferenciaTO) throws ExcepcionValidacion{
		if(conferenciaTO.getNombre() == null){
			throw new ExcepcionValidacion("El nombre de la conferencia no puede ser nulo");
		}
		
	}

}
