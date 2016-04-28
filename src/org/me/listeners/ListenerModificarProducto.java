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
import org.me.paneles.PanelReabastecimientoInventario;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerModificarProducto implements ActionListener {
    
    private final PanelReabastecimientoInventario panel;
    private String dbUser;
    private String dbPass;
    
    public ListenerModificarProducto (PanelReabastecimientoInventario panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(panel.datosValidos()) {
            dbUser = panel.getDbUser();
            dbPass = panel.getDbPass();
            String [] arr = panel.getJcbNombreProducto().getSelectedItem().toString().split("[,]+");
            String id = arr[0];
            String nombreProducto = arr[1].replaceAll("Nombre:", "").trim();
            String marca = panel.getJtfMarca().getText();
            String existencias = panel.getJtfExistencias().getText();
            String precioUnitario = panel.getJtfPrecioUnitario().getText();
            String precioTotal = panel.getJtfPrecioTotal().getText();
            String tipo = panel.getJcbTipo().getSelectedItem().toString().toLowerCase();
            DataBaseHelper dbh = new DataBaseHelper(dbUser, dbPass);
            try {
                dbh.iniciarConexion();
                dbh.modificarInventario(id, marca, existencias, precioUnitario, precioTotal, tipo);
                dbh.cerrarConexion();
                Message.showInfoMessage("Producto modificado con éxito.");
                limpiarCampos();
            } catch (ClassNotFoundException | SQLException ex) {
                Message.showErrorMessage("Error al modificar el inventario.\n" + ex.getMessage());
            }
        }
    }
    
    private void limpiarCampos () {
        panel.getJtfExistencias().setText("");
        panel.getJtfMarca().setText("");
        panel.getJtfPrecioTotal().setText("");
        panel.getJtfPrecioUnitario().setText("");
    }
    
}
