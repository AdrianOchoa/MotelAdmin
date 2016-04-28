/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import org.me.listeners.ListenerLogin;

/**
 *
 * @author Adrián
 */
public class PanelLogin extends JPanel {

    private JLabel jlUsuario;
    private JLabel jlPass;

    private JTextField jtfUsuario;
    private JPasswordField jpfPass;

    private JButton login;

    private Image image;

    public PanelLogin() throws IOException {
        setBackground(new Color(120, 203, 253));
        setLayout(null);
        init();
    }

    private void init() throws IOException {
        image = ImageIO.read(getClass().getResource("/org/me/resources/user_1.png"));
        
        jlUsuario = new JLabel("Nombre de usuario:");
        jlUsuario.setHorizontalTextPosition(CENTER);
        jlPass = new JLabel("Contraseña:");
        jlPass.setHorizontalTextPosition(CENTER);
        setJtfUsuario(new JTextField(20));
        setJpfPass(new JPasswordField(20));
        login = new JButton("Entrar");
        
        add(jlUsuario);
        add(jtfUsuario);
        add(jlPass);
        add(jpfPass);
        add(login);
        
        Insets insets = this.getInsets();
        Dimension size = jlUsuario.getPreferredSize();
        jlUsuario.setBounds(insets.bottom + 100, insets.right + 320, size.width, size.height);

        size = getJtfUsuario().getPreferredSize();
        getJtfUsuario().setBounds(insets.bottom + 250, insets.right + 320, size.width, size.height);

        size = jlPass.getPreferredSize();
        jlPass.setBounds(insets.bottom + 100, insets.right + 360, size.width, size.height);

        size = getJpfPass().getPreferredSize();
        getJpfPass().setBounds(insets.bottom + 250, insets.right + 360, size.width, size.height);

        size = login.getPreferredSize();
        login.setBounds(insets.bottom + 250, insets.right + 400, size.width, size.height);
    }
    
    public boolean datosValidos () {
        return camposLlenos();
    }
    
    public boolean camposLlenos () {
        return !jtfUsuario.getText().equals("") && jpfPass.getPassword().length != 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 210, 0, null);
    }
    
    public void addListener(ListenerLogin listener) {
        login.addActionListener(listener);
    }

    /**
     * @return the jtfUsuario
     */
    public JTextField getJtfUsuario() {
        return jtfUsuario;
    }

    /**
     * @param jtfUsuario the jtfUsuario to set
     */
    public void setJtfUsuario(JTextField jtfUsuario) {
        this.jtfUsuario = jtfUsuario;
    }

    /**
     * @return the jpfPass
     */
    public JPasswordField getJpfPass() {
        return jpfPass;
    }

    /**
     * @param jpfPass the jpfPass to set
     */
    public void setJpfPass(JPasswordField jpfPass) {
        this.jpfPass = jpfPass;
    }

}
