/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.CantTemp_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.ConsultarCantidadDescripcionPedido;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/consultarCantidadDescripcionPedido")
public class ConsultarCantidadDescripcionPedidoImpl implements ConsultarCantidadDescripcionPedido {

    @GET
    @Produces({"application/json"})
    @Override
    public CantTemp_TO consultarCantidadDescripcionPedido(@QueryParam("idPedido") int idPedido) throws Exception {
        Pedido_TO pedido = new Pedido_TO(idPedido);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        return descripcionDao.consultarCantidadDescripcionPedido(pedido);
    }
    

}
