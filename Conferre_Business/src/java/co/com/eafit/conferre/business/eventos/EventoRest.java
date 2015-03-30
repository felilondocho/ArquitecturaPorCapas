/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.eafit.conferre.business.eventos;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author felipelondono
 */
@Path("MyPath")
public class EventoRest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MyPathResource
     */
    public EventoRest() {
    }

    /**
     * Retrieves representation of an instance of co.com.eafit.conferre.business.eventos.MyPathResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MyPathResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content,EventoTO ev) {
        ObjetoTO obj = new ObjetoTo();
        obj = (ObjetoTO)content;
        CrearEventoUC evento = new CrearEventoUC();
        evento.ejecutar(obj);
        evento.crearSillas(ev);
        
    }
}
