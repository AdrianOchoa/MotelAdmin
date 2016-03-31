/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelAltaProducto;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerAltaProducto implements ActionListener {

    private final PanelAltaProducto panel;
    private DataBaseHelper dbh;
    private String dbUser;
    private String dbPass;

    private String nombreProducto;
    private String marca;
    private String existencias;
    private String precioU;
    private String precioT;
    private String tipo;

    /**
     * 
     * @param panel 
     */
    public ListenerAltaProducto(PanelAltaProducto panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panel.datosValidos()) {
            dbUser = panel.getDbUser();
            dbPass = panel.getDbPass();
            dbh = new DataBaseHelper(dbUser, dbPass);
            nombreProducto = panel.getJtfNombreProducto().getText();
            marca = panel.getJtfMarca().getText();
            existencias = panel.getJtfExistencias().getText();
            precioU = panel.getJtfPrecioUnitario().getText();
            precioT = panel.getJtfPrecioTotal().getText();
            tipo = panel.getJtfTipo().getText();
            try {
                dbh.iniciarConexion();
                dbh.altaProducto(nombreProducto, marca, existencias, precioU, precioT, tipo);
                dbh.cerrarConexion();
                Message.showInfoMessage("Producto dado de alta en la base de datos con exito.");
                limpiarCampos();
            } catch (SQLException | ClassNotFoundException ex) {
                Message.showErrorMessage("Error al dar de alta el producto.\n" + ex.getMessage());
            } 
        } 
    }
    
    /**
     * resetea los campos del panel
     */
    private void limpiarCampos () {
        panel.getJtfNombreProducto().setText("");
        panel.getJtfMarca().setText("");
        panel.getJtfExistencias().setText("");
        panel.getJtfPrecioUnitario().setText("");
        panel.getJtfPrecioTotal().setText("");
        panel.getJtfTipo().setText("");
    }

}
