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
import org.me.modelos.Empleado;
import org.me.paneles.PanelID;
import org.me.util.Message;

/**
 *
 * @author JR
 */
class ListenerBajaEmpleado implements ActionListener {

    private String user;
    private String pass;
    private PanelID panel;

    public ListenerBajaEmpleado() {
    }

    ListenerBajaEmpleado(String user, String pass, PanelID panel) {
        this.user = user;
        this.pass = pass;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataBaseHelper dh = new DataBaseHelper(user, pass);
        try {
            dh.iniciarConexion();
            Empleado empleado = (Empleado) panel.getElementos().getSelectedItem();
            dh.eliminarEmpleado(empleado, user);
            Message.showInfoMessage("Se eliminó un elemento");
            SwingUtilities.getWindowAncestor(panel).dispose();
            dh.cerrarConexion();

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
            Message.showErrorMessage("Error al eliminar");
            ex.printStackTrace();
        }
    }

}
