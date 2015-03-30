package co.com.eafit.conferre.business.listaEspera;

import co.com.eafit.conferre.conferencias.data.to.ListaEsperaTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public class ListaEsperaFacadeREST implements ListaEsperaFacade {

	@Override
	//cosas del REST
	public ListaEsperaTO crearListaEspera(ListaEsperaTO listaDeEspera) {
		CrearListaEsperaUC uc = new CrearListaEsperaUC();
		ListaEsperaTO res = null;
		try {
			res = (ListaEsperaTO) uc.ejecutar(listaDeEspera);
		} catch (ExcepcionUnitOfWork e) {
			e.printStackTrace();
		}
		return res;
	}

}
