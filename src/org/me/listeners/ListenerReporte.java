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
import javax.swing.SwingUtilities;
import org.me.modelos.Producto;
import org.me.paneles.PanelConsultas;
import org.me.paneles.PanelID;
import org.me.ventanas.VentanaConsulta;

/**
 *
 * @author JR
 */
public class ListenerReporte implements ActionListener {

    private String user, pass;
    private PanelID p1;

    public ListenerReporte(String user, String pass, PanelID p1) {
        this.user = user;
        this.pass = pass;
        this.p1 = p1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PanelConsultas panel;
        try {
            switch ((String) p1.getElementos().getSelectedItem()) {
                case "Reporte de reabastecimiento":
                    panel = new PanelConsultas(user, pass, 5);
                    VentanaConsulta ventanaC = new VentanaConsulta(panel);
                    break;
                case "Reporte de Renta":
                    panel = new PanelConsultas(user, pass, 6);
                    ventanaC = new VentanaConsulta(panel);
                    break;

            }
            SwingUtilities.getWindowAncestor(p1).dispose();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListenerBusquedaInventario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(ListenerBusquedaInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
