/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Historico_TO;
import co.com.lavapp.persistencia.dao.HistoricoDAO;
import co.com.lavapp.persistencia.dao.impl.HistoricoDAOImpl;
import co.com.lavapp.servicio.EliminarHistorico;
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
@Path("eliminarHistorico")
public class EliminarHistoricoImpl implements EliminarHistorico{

    @GET
    @Produces({"application/json"})
    @Override
    public Historico_TO eliminarHistorico(@QueryParam("idHistorico") int idHistorico) throws Exception {
        Historico_TO historico = new Historico_TO(idHistorico);
        HistoricoDAO historicoDao = new HistoricoDAOImpl();
        return historicoDao.eliminarHistorico(historico);
    }
    
}
