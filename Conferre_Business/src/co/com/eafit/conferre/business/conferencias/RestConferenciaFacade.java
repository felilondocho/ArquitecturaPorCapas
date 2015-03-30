package co.com.eafit.conferre.business.conferencias;

import co.com.eafit.conferre.conferencias.data.to.ConferenciaTO;

//@Path("/conferencias")
public class RestConferenciaFacade implements ConferenciasFacade {

	@Override
//	@Path("/")
//	@POST
//	@Consumes("application/json")
//	@Produces("application/json")
	public ConferenciaTO crearConferencia(ConferenciaTO conferencia) {
		CrearConferenciaUseCase useCase = new CrearConferenciaUseCase();
		ConferenciaTO conferenciaResult = null;
		try {
			conferenciaResult = (ConferenciaTO) useCase.ejecutar(conferencia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conferenciaResult;
	}

}
