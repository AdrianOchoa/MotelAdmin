/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.ventanas;

import javax.swing.JFrame;

/**
 *
 * @author JR
 */
public class VentanaID extends JFrame{
    
    public VentanaID(String accion){
        super();
        init(accion);
    }

    private void init(String string) {
         this.setDefaultCloseOperation(2);
         this.setSize(300,140);
         this.setResizable(false);
         this.setTitle(string);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
    }
    
}
