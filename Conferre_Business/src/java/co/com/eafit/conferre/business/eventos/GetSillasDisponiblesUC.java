package co.com.eafit.conferre.business.eventos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.ValidationException;

import co.com.eafit.conferre.business.conferencias.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.SillasDAO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.conferencias.data.to.SillasTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public class GetSillasDisponiblesUC{

	public Collection<ObjetoTO> ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork {
		EventoTO ev = (EventoTO) parametros;
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		SillasTO sill = null;
		try {
			validacion(ev);
			SillasDAO sillDAO = FabricaDAO.createSillasDAO();
			sill.setIdConf(ev.getIdConferencia());
			sill.setIdEv(ev.getId());
			sill.setOcupado(false);
			res = (List<ObjetoTO>) sillDAO.recuperar(sill);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private void validacion(EventoTO evento) throws ValidationException {
		if(evento.getId()==null){
			throw new ValidationException("evento invalido");
		}
		if(evento.getIdConferencia()==null){
			throw new ValidationException("conferencia invailda");
		}
	}

}
