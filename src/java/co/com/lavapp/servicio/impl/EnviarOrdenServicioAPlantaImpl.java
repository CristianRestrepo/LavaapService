/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.metodos.GenerarReportes;
import co.com.lavapp.modelo.dto.*;
import co.com.lavapp.persistencia.dao.*;
import co.com.lavapp.persistencia.dao.impl.*;
import co.com.lavapp.servicio.EnviarOrdenServicioAPlanta;
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
@Path("/enviarOrdenServicioAPlanta")
public class EnviarOrdenServicioAPlantaImpl implements EnviarOrdenServicioAPlanta{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public int enviarOrdenServicioAPlanta(@QueryParam("email") String email, @QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        Usuario_TO usuario = new Usuario_TO();
        usuario.setEmail(email);
        
        GenerarReportes gr = new GenerarReportes();
        gr.generarOrdenTrabajoProveedorEnContexto(pedido);
        
        CorreoDAO cd = new CorreoDAOImpl();
        return cd.enviarOrdenServicioAPlanta(email, idPedido, gr.rutaDocumento);
    }
    
}
