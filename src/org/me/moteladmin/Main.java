/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.moteladmin;

import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;
import org.me.listeners.ListenerLogin;
import org.me.paneles.PanelLogin;
import org.me.ventanas.VentanaLogin;

/**
 *
 * @author jr
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws javax.swing.UnsupportedLookAndFeelException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws IOException,
            UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {

        PanelLogin panelLogin = new PanelLogin();
        ListenerLogin listenerLogin = new ListenerLogin(panelLogin);

        panelLogin.addListener(listenerLogin);

        VentanaLogin ventanaLogin = new VentanaLogin(panelLogin);

    }

}
