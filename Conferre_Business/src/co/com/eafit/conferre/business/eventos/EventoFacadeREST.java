package co.com.eafit.conferre.business.eventos;

import co.com.eafit.conferre.conferencias.data.to.EventoTO;

public class EventoFacadeREST implements EventoFacade {

	@Override
	//aca van las cosas del REST
	public EventoTO crearEvento(EventoTO evento) {
		crearEventoUC uc = new crearEventoUC();
		EventoTO evRes = null;
		try{
			evRes = (EventoTO) uc.ejecutar(evento);
		}catch(Exception e){
			e.printStackTrace();
		}
		return evRes;
	}

}
