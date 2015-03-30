package co.com.eafit.conferre.business.eventos;

import java.util.UUID;

import javax.xml.bind.ValidationException;

import co.com.eafit.conferre.business.conferencias.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.EventoDAO;
import co.com.eafit.conferre.conferencias.data.dac.SillasDAO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.conferencias.data.to.SillasTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public class crearEventoUC implements UnitOfWork{
	

	@Override
	public ObjetoTO ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork {
		EventoTO ev = (EventoTO) parametros;
		EventoTO res = null;
		try {
			validarEvento(ev);
			EventoDAO evDAO = FabricaDAO.createEventoDAO();
			UUID id = UUID.randomUUID();
			ev.setId(id.toString());
			res = (EventoTO) evDAO.crear(ev);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	private void validarEvento(EventoTO evento) throws ValidationException {
		if (evento.getNamae() == null){
			throw new ValidationException("nombre de evento invalido (no puede ser nulo)");
		}
		if (evento.getIdConferencia() == null){
			throw new ValidationException("conferencia invalida");
		}
	}
	
	private void crearSillas(EventoTO evento){
		SillasTO as = null;
		SillasTO res = null;
		SillasDAO asDAO = FabricaDAO.createSillasDAO();
		
		for(int i = 1; i < evento.getNumSillas()+1; i++){
			as.setIdConf(evento.getIdConferencia());
			as.setIdEv(evento.getId());
			as.setNumSilla(i);
			as.setOcupado(false);
			as.setOcupante("vacio");
			as.setEmail("vacio");
			res = (SillasTO) asDAO.crear(as);
		}
	}
}
