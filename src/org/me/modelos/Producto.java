/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.modelos;


/**
 *
 * @author JR
 */
public class Producto {
    
    private String id;
    private String nombreProducto;

    public Producto(String id, String nombreProducto) {
        this.id = id;
        this.nombreProducto = nombreProducto;
    }

    public Producto() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public String toString() {
        return "idProducto: " + id + ", nombreProducto: " + nombreProducto;
    }
    
    
    
    
    
}
