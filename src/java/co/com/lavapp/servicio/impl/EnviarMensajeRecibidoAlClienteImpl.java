/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.metodos.GenerarReportes;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.persistencia.dao.CorreoDAO;
import co.com.lavapp.persistencia.dao.impl.CorreoDAOImpl;
import co.com.lavapp.servicio.EnviarMensajeRecibidoAlCliente;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author VaioDevelopment
 */
@Stateless
@Path("/enviarMensajeRecibidoAlCliente")
public class EnviarMensajeRecibidoAlClienteImpl implements EnviarMensajeRecibidoAlCliente{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int enviarMensajeRecibidoAlCliente(@QueryParam("email") String email, @QueryParam("idPedido") int idPedido) throws Exception {      
        
        GenerarReportes gr = new GenerarReportes();
        gr.generarOrdenTrabajoEnContexto(new Pedido_TO(idPedido));
        CorreoDAO correoDao = new CorreoDAOImpl();
        return correoDao.enviarMensajeRecibidoAlCliente(email, idPedido, gr.rutaDocumento);
    }
    
}
