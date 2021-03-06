/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Usuario_TO;
import co.com.lavapp.modelo.dto.Zona_TO;
import co.com.lavapp.persistencia.dao.UsuarioDAO;
import co.com.lavapp.persistencia.dao.impl.UsuarioDAOImpl;
import co.com.lavapp.servicio.ConsultarAsesorZona;
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
@Path("/consultarAsesorZona")
public class ConsultarAsesorZonaImpl implements ConsultarAsesorZona {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Usuario_TO consultarAsesorZona(@QueryParam("idZona") int idzona) throws Exception {
        Zona_TO zona = new Zona_TO(idzona);
        UsuarioDAO ud = new UsuarioDAOImpl();
        Usuario_TO asesor = ud.ConsultarAsesorZona(zona);
        return asesor;
    }

}
