package co.com.eafit.conferre.business.eventos;

import javax.xml.bind.ValidationException;

import co.com.eafit.conferre.business.conferencias.UnitOfWork;
import co.com.eafit.conferre.conferencias.data.base.FabricaDAO;
import co.com.eafit.conferre.conferencias.data.base.ObjetoTO;
import co.com.eafit.conferre.conferencias.data.dac.SillasDAO;
import co.com.eafit.conferre.conferencias.data.to.EventoTO;
import co.com.eafit.conferre.conferencias.data.to.SillasTO;
import co.com.eafit.conferre.soporte.ExcepcionUnitOfWork;

public class VentaSillasUC implements UnitOfWork {
	
	public String ocupante;
	public String email;
	
	public VentaSillasUC(String oc, String em){
		this.ocupante = oc;
		this.email = em;
	}

	//Este metodo nos permite hacer un UPDATE en la tabla de sillas, para indicar
	//que la silla seleccionada ya no esta ocupada y tener los datos del que ocupa la silla
	@Override
	public ObjetoTO ejecutar(ObjetoTO parametros) throws ExcepcionUnitOfWork {
		SillasTO silla = (SillasTO) parametros;
		SillasTO res = null;
		SillasDAO sillaDAO = FabricaDAO.createSillasDAO();
		silla.setOcupado(true);
		silla.setOcupante(ocupante);
		silla.setEmail(email);
		res = (SillasTO) sillaDAO.update(silla);
		try {
			validacion(res);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//validaciones necesarias para la venta de sillas
	private void validacion(SillasTO silla) throws ValidationException {
		if(silla.isOcupado()==false){
			throw new ValidationException("error en la venta");
		}
		if(silla.getOcupante()==null){
			throw new ValidationException("nombre invalido");
		}
		if(silla.getEmail()==null){
			throw new ValidationException("email invalido");
		}
	}

}
