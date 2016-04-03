/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.modelos;

import java.sql.ResultSet;

/**
 *
 * @author JR
 */
public class Empleado {
    private String id;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String contrasena;

    public Empleado(String id, String nombre, String apellidoPaterno, String apellidoMaterno, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.contrasena = contrasena;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    @Override
    public String toString() {
        return "idEmpleado: " + id + ", nombre: " + nombre + ", apellidoMaterno: " 
                + apellidoMaterno + ", apellidoPaterno: " + apellidoPaterno;
    }
    
    
    
}
