/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.SwingUtilities;
import org.me.paneles.PanelLogin;
import org.me.paneles.PanelPrincipal;
import org.me.util.Message;
import org.me.ventanas.VentanaPrincipal;
import org.me.vistas.Menu;

/**
 *
 * @author Adrián
 */
public class ListenerLogin implements ActionListener {
    
    private final PanelLogin panelLogin;
    
    public ListenerLogin (PanelLogin panelLogin) {
        this.panelLogin = panelLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hola chabo!!!");
        SwingUtilities.windowForComponent(panelLogin).dispose();
        PanelPrincipal panel = new PanelPrincipal();
        Menu menu = new Menu();
        
        
        try {
            VentanaPrincipal ventana = new VentanaPrincipal(panel, menu);
            ListenerVentana listenerVentana = new ListenerVentana();
            ventana.addListener(listenerVentana);
            ListenerMenu listenerMenu = new ListenerMenu(ventana);
            menu.addListener(listenerMenu);
        } catch (IOException ex) {
            Message.showErrorMessage(ex.getMessage());
        }
    }
    
}
