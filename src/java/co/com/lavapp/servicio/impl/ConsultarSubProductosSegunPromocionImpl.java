/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Promocion_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;
import co.com.lavapp.persistencia.dao.PromocionSubproductoDAO;
import co.com.lavapp.persistencia.dao.impl.PromocionSubproductoDAOImpl;
import co.com.lavapp.servicio.ConsultarSubProductosSegunPromocion;
import java.util.List;
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
@Path("/consultarSubProductosSegunPromocion")
public class ConsultarSubProductosSegunPromocionImpl implements ConsultarSubProductosSegunPromocion{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<SubProducto_TO> consultarSubProductosSegunPromocion(@QueryParam("idPromocion")int idPromocion) throws Exception {
        Promocion_TO promocion = new Promocion_TO(idPromocion);
        PromocionSubproductoDAO promocionSubproductoDAO = new PromocionSubproductoDAOImpl();
        return promocionSubproductoDAO.consultarSubProductosSegunPromocion(promocion);
    }
        
    
}
