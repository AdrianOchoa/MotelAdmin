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
import javax.swing.SwingUtilities;
import org.me.modelos.DataBaseHelper;
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
    private DataBaseHelper dbh;
    private String usuario;
    private String password;

    /**
     *
     * @param panelLogin
     */
    public ListenerLogin(PanelLogin panelLogin) {
        this.panelLogin = panelLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (panelLogin.datosValidos()) {
            usuario = panelLogin.getJtfUsuario().getText();
            password = new String(panelLogin.getJpfPass().getPassword());
            dbh = new DataBaseHelper(usuario, password);
            try {
                if (dbh.iniciarConexion()) {
                    SwingUtilities.windowForComponent(panelLogin).dispose();
                    PanelPrincipal panel = new PanelPrincipal();
                    Menu menu = new Menu();
                    ListenerMenu listenerMenu = new ListenerMenu(usuario, password);
                    menu.addListener(listenerMenu);
                    try {
                        VentanaPrincipal ventana = new VentanaPrincipal(panel, menu);
                        ListenerVentana listenerVentana = new ListenerVentana();
                        ventana.addListener(listenerVentana);
                    } catch (IOException ex) {
                        Message.showErrorMessage(ex.getMessage());
                    }
                } else {
                    Message.showErrorMessage("Error al conectarse a la base de datos.\nPosibles datos incorrectos.");
                    clear();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Message.showErrorMessage("Error al conectarse a la base de datos.\nPosibles datos incorrectos." + ex.getMessage());
                clear();
            }
        }
    }
    
    private void clear() {
        panelLogin.getJpfPass().setText("");
    }

}
