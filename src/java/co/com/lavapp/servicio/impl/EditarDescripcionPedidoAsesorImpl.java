/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Color_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.modelo.dto.DescripcionPedido_TO;
import co.com.lavapp.modelo.dto.Estado_TO;
import co.com.lavapp.persistencia.dao.DescripcionPedidoDAO;
import co.com.lavapp.persistencia.dao.impl.DescripcionPedidoDAOImpl;
import co.com.lavapp.servicio.EditarDescripcionPedidoAsesor;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Desarrollo_Planit
 */
@Stateless
@Path("/editarDescripcionPedidoAsesor")
public class EditarDescripcionPedidoAsesorImpl implements EditarDescripcionPedidoAsesor {

    @PUT
//    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Override
    public String editarDescripcionPedidoAsesor(
            @FormParam("idDescripcionPedido") int idDescripcionPedido,
            @FormParam("idEstado") int idEstado,
            @FormParam("observacionAsesor") String observacionAsesor,
            @FormParam("idColor") int idColor,
            @FormParam("foto1") String foto1,
            @FormParam("foto2") String foto2,
            @FormParam("foto3") String foto3,
            @FormParam("codigo") String codigo,
            @FormParam("nombrefoto1") String nombrefoto1,
            @FormParam("nombrefoto2") String nombrefoto2,
            @FormParam("nombrefoto3") String nombrefoto3) throws Exception {
        
        System.out.println("prueba--------------------"+observacionAsesor);
        Estado_TO estado = new Estado_TO(idEstado);
        Color_TO color = new Color_TO(idColor);
        
        DescripcionPedido_TO descripcionPedido = new DescripcionPedido_TO(idDescripcionPedido, estado, observacionAsesor, foto1, foto2, foto3, color, codigo, nombrefoto1, nombrefoto2, nombrefoto3);
        DescripcionPedidoDAO descripcionDao = new DescripcionPedidoDAOImpl();
        descripcionDao.editarDescripcionAsesor(descripcionPedido);
        
        return "excelente";
    }

}
