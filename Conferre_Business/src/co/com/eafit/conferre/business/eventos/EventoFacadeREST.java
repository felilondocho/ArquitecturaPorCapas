package co.com.eafit.conferre.business.eventos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import co.com.eafit.conferre.business.conferencias.ConferenciasFacade;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.conferencias.data.to.SillasTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public class EventoFacadeREST implements EventoFacade {

	@Override
	//aca van las cosas del REST
	public EventoTO crearEvento(EventoTO evento) {
		CrearEventoUC uc = new CrearEventoUC();
		EventoTO evRes = null;
		try{
			evRes = (EventoTO) uc.ejecutar(evento);
		}catch(Exception e){
			e.printStackTrace();
		}
		return evRes;
	}
	
	public SillasTO ventaSilla(SillasTO silla, String ocupante, String email){
		VentaSillasUC uc = new VentaSillasUC(ocupante, email);
		SillasTO sillaRes = null;
		try {
			sillaRes = (SillasTO) uc.ejecutar(silla);
		} catch (ExcepcionUnitOfWork e) {
			e.printStackTrace();
		}
		return sillaRes;
	}
	
	public Collection<ObjetoTO> getSillasDisponibles(EventoTO evento){
		GetSillasDisponiblesUC uc = new GetSillasDisponiblesUC();
		List<ObjetoTO> res = new ArrayList<ObjetoTO>();
		try {
			res = (List<ObjetoTO>) uc.ejecutar(evento);
		} catch (ExcepcionUnitOfWork e) {
			e.printStackTrace();
		}
		return res;
	}
	

}
