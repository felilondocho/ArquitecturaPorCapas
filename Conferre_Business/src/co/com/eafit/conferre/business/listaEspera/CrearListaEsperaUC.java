package co.com.eafit.conferre.business.listaEspera;

import java.util.UUID;

import co.com.eafit.conferre.business.conferencias.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.ListaEsperaDAO;
import co.com.eafit.conferre.conferencias.data.to.ListaEsperaTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;
import co.com.eafit.conferre.soporte.ExcepcionValidacion;

public class CrearListaEsperaUC implements UnitOfWork{

	@Override
	public ObjetoTO ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork {
		ListaEsperaTO le = (ListaEsperaTO) parametros;
		ListaEsperaTO res = null;
		try {
			validarDatosListaEspera(le);
			ListaEsperaDAO leDAO = FabricaDAO.createListaEsperaDAO();
			UUID id = UUID.randomUUID();
			le.setId(id.toString());
			res = (ListaEsperaTO) leDAO.crear(le);
		} catch (ExcepcionValidacion e) {
			e.printStackTrace();
		}
		return res;
	}
	
	private void validarDatosListaEspera(ListaEsperaTO listaDeEspera) throws ExcepcionValidacion{
		if(listaDeEspera.getConferenciaId()==null || listaDeEspera.getNamae() == null || 
				listaDeEspera.getEmail() == null){
			throw new ExcepcionValidacion("Conferencia no valida");
		}
	}

}
