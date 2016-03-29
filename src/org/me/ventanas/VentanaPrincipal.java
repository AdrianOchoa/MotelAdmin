/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ventanas;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.me.listeners.ListenerVentana;
import org.me.paneles.PanelPrincipal;
import org.me.vistas.Menu;

/**
 *
 * @author Adrián
 */
public class VentanaPrincipal extends JFrame {

    private final PanelPrincipal panelPrincipal;
    private final Menu menu;

    public VentanaPrincipal(PanelPrincipal panelPrincipal, Menu menu) throws IOException {
        super("Administración");
        this.panelPrincipal = panelPrincipal;
        this.menu = menu;
        init();
    }

    private void init() throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/org/images/exe.png"));
        this.setIconImage(image);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setJMenuBar(menu);
        this.add(panelPrincipal);
    }
    
    public void addListener (ListenerVentana listener) {
        addWindowListener(listener);
    }

}
