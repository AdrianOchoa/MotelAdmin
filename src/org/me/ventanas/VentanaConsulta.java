/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ventanas;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.me.paneles.PanelConsultas;

/**
 *
 * @author Adrián
 */
public class VentanaConsulta extends JFrame {

    private final PanelConsultas panel;

    public VentanaConsulta(PanelConsultas panel) throws IOException {
        this.panel = panel;
        init();
    }

    private void init() throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/org/images/exe.png"));
        setIconImage(image);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Contenido de la tabla");
        setVisible(true);
        getContentPane().add(panel.getDesplazar(), BorderLayout.NORTH);
    }

}
