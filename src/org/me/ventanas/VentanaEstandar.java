/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ventanas;

import java.awt.HeadlessException;
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
    private int x;
    private int y;

    
    public VentanaEstandar (JPanel panel) throws IOException {
        this(panel, 800, 600);
    }
    
    public VentanaEstandar (JPanel panel, int x, int y) throws IOException {
        super("Administración");
        this.panel = panel;
        this.x = x;
        this.y = y;
        init();
    }
    
    private void init () throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/org/images/exe.png"));
        this.setIconImage(image);
        this.setSize(x, y);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
