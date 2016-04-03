/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.me.modelos.DataBaseHelper;
import org.me.modelos.Producto;
import org.me.paneles.PanelID;
import org.me.util.Message;

/**
 *
 * @author JR
 */
class ListenerBajaInventario implements ActionListener {
    
    private String user;
    private String pass;
    private PanelID panel;

    public ListenerBajaInventario() {
    }

    ListenerBajaInventario(String user, String pass, PanelID panel) {
         this.user= user;
         this.pass = pass;
         this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Baja en inventario2");
        DataBaseHelper dh = new DataBaseHelper(user, pass);
        try {
            dh.iniciarConexion();
            Producto producto = (Producto)panel.getElementos().getSelectedItem();
            dh.eliminarProducto(producto.getId());
            Message.showInfoMessage("Se eliminó un elemento");
            SwingUtilities.getWindowAncestor(panel).dispose();
            dh.cerrarConexion();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
