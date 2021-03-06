/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio.impl;

import co.com.lavapp.modelo.dto.Departamento_TO;
import co.com.lavapp.persistencia.dao.DepartamentoDAO;
import co.com.lavapp.persistencia.dao.impl.DepartamentoDAOImpl;
import co.com.lavapp.servicio.ConsultarDepartamento;
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
@Path("/consultarDepartamento")
public class ConsultarDepartamentoImpl implements ConsultarDepartamento{

    @GET
    @Produces({"application/json"})
    @Override
    public Departamento_TO consultarDepartamento(@QueryParam("idDepartamento") int idDepartamento, @QueryParam("nombre") String nombre) throws Exception {
        Departamento_TO departamento = new Departamento_TO(idDepartamento);
        departamento.setNombre(nombre);
        DepartamentoDAO departamentoDao = new DepartamentoDAOImpl();
        return departamentoDao.consultarDepartamento(departamento);
    }    
}
