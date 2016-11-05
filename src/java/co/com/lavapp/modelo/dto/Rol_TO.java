/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.lavapp.modelo.dto;
/**
 *
 * Objeto de negocios que modelo un Rol
 *
 * Tabla Relacionada Rol
 *
 * @author Planit
 */
public class Rol_TO {

    /**
     *
     * Columna idRol
     */
    private int idRol;

    /**
     *
     * Columna nombre
     */
    private String nombre;

    //Constructores
    public Rol_TO() {
    }

    //Constructor General
    public Rol_TO(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Rol_TO(int idRol) {
        this.idRol = idRol;
    }
    
    

    //Getter and Setter
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol_TO{" + "idRol=" + idRol + ", nombre=" + nombre + '}';
    }

}