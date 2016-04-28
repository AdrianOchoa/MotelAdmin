/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.modelos.Producto;
import org.me.paneles.PanelConsultas;
import org.me.paneles.PanelID;
import org.me.ventanas.VentanaConsulta;

/**
 *
 * @author JR
 */
class ListenerBusquedaInventario implements ActionListener {

    private String user;
    private String pass;
    private PanelID panel;

    public ListenerBusquedaInventario() {
    }

    ListenerBusquedaInventario(String user, String pass, PanelID panel) {
        this.user = user;
        this.pass = pass;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Producto producto = (Producto) panel.getElementos().getSelectedItem();
        PanelConsultas panel;
        try {
            panel = new PanelConsultas(user, pass, 4, producto.getId());
            VentanaConsulta ventanaC = new VentanaConsulta(panel);
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ListenerBusquedaInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

}
