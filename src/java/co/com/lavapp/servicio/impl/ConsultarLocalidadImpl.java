/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Localidad_TO;
import co.com.lavapp.persistencia.dao.LocalidadDAO;
import co.com.lavapp.persistencia.dao.impl.LocalidadDAOImpl;
import co.com.lavapp.servicio.ConsultarLocalidad;
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
@Path("/consultarLocalidad")
public class ConsultarLocalidadImpl implements ConsultarLocalidad{

    @GET
    @Produces({"application/json"})
    @Override
    public Localidad_TO consultarLocalidad(@QueryParam("idLocalidad") int idLocalidad, @QueryParam("nombre") String nombre) throws Exception {
        Localidad_TO localidad = new Localidad_TO(idLocalidad);
        localidad.setNombre(nombre);
        LocalidadDAO localidadDao = new LocalidadDAOImpl();
        return localidadDao.consultarLocalidad(localidad);
    }    
}
