/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Jornada_TO;
import co.com.lavapp.persistencia.dao.JornadaDAO;
import co.com.lavapp.persistencia.dao.impl.JornadaDAOImpl;
import co.com.lavapp.servicio.RegistrarJornada;
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
@Path("/registrarJornada")
public class RegistrarJornadaImpl implements RegistrarJornada{

    @GET
    @Produces({"application/json"})
    @Override
    public Jornada_TO registrarJornada(@QueryParam("nombre") String nombre) throws Exception {
        Jornada_TO jornada = new Jornada_TO();
        jornada.setNombre(nombre);
        JornadaDAO jornadaDao = new JornadaDAOImpl();
        return jornadaDao.registraJornada(jornada);
    }
    
}