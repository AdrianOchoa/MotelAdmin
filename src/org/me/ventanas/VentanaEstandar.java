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
import javax.swing.JPanel;

/**
 *
 * @author Adrián
 */
public class VentanaEstandar extends JFrame {
    
    private final JPanel panel;
    
    public VentanaEstandar (JPanel panel) throws IOException {
        super("Administración");
        this.panel = panel;
        init();
    }
    
    private void init () throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/org/images/exe.png"));
        this.setIconImage(image);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setContentPane(panel);
    }
    
}
