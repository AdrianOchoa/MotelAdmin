/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelLiberarHabitacion;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerLiberarHabitaciones implements ActionListener {

    private final PanelLiberarHabitacion panel;

    public ListenerLiberarHabitaciones(PanelLiberarHabitacion panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String user = panel.getDbUser();
            String pass = panel.getDbPassword();
            int idHabitacion = Integer.parseInt(panel.getJcbHabitaciones().getSelectedItem()
                    .toString().split("[,]+")[0]);
            DataBaseHelper dbh = new DataBaseHelper(user, pass);
            dbh.iniciarConexion();
            dbh.liberarHabitacion(idHabitacion);
            dbh.cerrarConexion();
            Message.showInfoMessage("La habitación está lista para usarse.");
            SwingUtilities.windowForComponent(panel).dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

}
