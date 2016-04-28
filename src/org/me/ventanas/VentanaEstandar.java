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
import javax.swing.JScrollPane;

/**
 *
 * @author Adrián
 */
public class VentanaEstandar extends JFrame {
    
    private final JPanel panel;
    private int x;
    private int y;

    
    /**
     * Constructor de un frame con tamaño estándar
     * @param panel
     * @throws IOException 
     */
    public VentanaEstandar (JPanel panel) throws IOException {
        this(panel, 800, 600);
    }
    
    /**
     * Constructor de un frame con tamaño personalizado
     * @param panel
     * @param x el ancho del panel
     * @param y el alto del panel
     * @throws IOException 
     */
    public VentanaEstandar (JPanel panel, int x, int y) throws IOException {
        super("Administración");
        this.panel = panel;
        this.x = x;
        this.y = y;
        init();
    }
    
    /**
     * Inicializa los componentes de la ventana
     * @throws IOException 
     */
    private void init () throws IOException {
        Image image = ImageIO.read(this.getClass().getResource("/org/me/resources/exe.png"));
        this.setIconImage(image);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        JScrollPane desp = new JScrollPane(panel);
        this.setContentPane(desp);
        this.setResizable(true);
        this.setVisible(true);
    }
    
}
