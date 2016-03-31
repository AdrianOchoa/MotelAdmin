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
import javax.swing.UIManager;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import javax.swing.UnsupportedLookAndFeelException;
import org.me.paneles.PanelLogin;

/**
 *
 * @author Adrián
 */
public class VentanaLogin extends JFrame {
    
    private final PanelLogin panelLogin;
    
    /**
     * 
     * @param panelLogin
     * @throws IOException
     * @throws UnsupportedLookAndFeelException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public VentanaLogin (PanelLogin panelLogin) throws IOException, 
            UnsupportedLookAndFeelException, ClassNotFoundException, 
            InstantiationException, IllegalAccessException {
        super("Inicio de Sesión");
        this.panelLogin = panelLogin;
        initVentana();
    }
    
    /**
     * Inicializa los componentes de la ventana
     * @throws IOException
     * @throws UnsupportedLookAndFeelException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    private void initVentana () throws IOException, 
            UnsupportedLookAndFeelException, ClassNotFoundException, 
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        Image image = ImageIO.read(getClass().getResource("/org/images/exe.png"));
        setIconImage(image);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setContentPane(panelLogin);
        setVisible(true);
    }
    
}
