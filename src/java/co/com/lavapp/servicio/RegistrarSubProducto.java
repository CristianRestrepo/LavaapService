/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.SubProducto_TO;

/**
 *
 * @author SISTEMAS
 */
public interface RegistrarSubProducto {
    public SubProducto_TO registrarSubProducto(String nombre , String descripcion , int idProducto, String rutaImagen) throws Exception;
}
