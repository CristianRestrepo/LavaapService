/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.persistencia.dao;

import co.com.lavapp.modelo.dto.Costo_TO;
import co.com.lavapp.modelo.dto.Pedido_TO;
import co.com.lavapp.modelo.dto.SubProducto_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface CostoDAO {

    public Costo_TO registrarCosto(Costo_TO costo) throws Exception;

    public Costo_TO modificarCosto(Costo_TO costo) throws Exception;

    public Costo_TO eliminarCosto(Costo_TO costo) throws Exception;

    public Costo_TO consultarCosto(Costo_TO costo) throws Exception;

    public double consultarCostoPedido(Pedido_TO pedido) throws Exception;

    public Costo_TO consultarCostoSubProducto(SubProducto_TO subproducto) throws Exception;
}
