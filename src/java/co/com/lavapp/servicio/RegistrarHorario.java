/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.servicio;

import co.com.lavapp.modelo.dto.Horario_TO;

/**
 *
 * @author Desarrollo_Planit
 */
public interface RegistrarHorario {
    
    public Horario_TO registrarHorario(String horainicio, String horafinal, int idjornada, String horario) throws Exception;
    
}
