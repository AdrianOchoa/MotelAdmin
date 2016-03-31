/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.util.Message;
import org.me.ventanas.VentanaEstandar;

/**
 *
 * @author Adrián
 */
public class ListenerMenu implements ActionListener {

    private final String user;
    private final String pass;

    public ListenerMenu(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Alta de empleados":
                try {
                    PanelAltaEmpleado panelAltaEmpleado = new PanelAltaEmpleado(user, pass);
                    ListenerAltaEmpleado listener = new ListenerAltaEmpleado(panelAltaEmpleado);
                    panelAltaEmpleado.addListener(listener);
                    VentanaEstandar ventana = new VentanaEstandar(panelAltaEmpleado, 800, 700);
                } catch (IOException ex) {
                    Message.showErrorMessage(ex.getMessage());
                }
                break;
            case "Alta en el inventario":
                try {
                    PanelAltaProducto panelAltaProducto = new PanelAltaProducto(user, pass);
                    ListenerAltaProducto listener = new ListenerAltaProducto(panelAltaProducto);
                    panelAltaProducto.addListener(listener);
                    VentanaEstandar ventana = new VentanaEstandar(panelAltaProducto);
                } catch (IOException ex) {
                    Message.showErrorMessage(ex.getMessage());
                }
                break;
            default:
                System.out.println("Hellou shabot!");
                break;
        }
    }

}
