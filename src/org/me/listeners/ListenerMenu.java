/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Adrián
 */
public class ListenerMenu implements ActionListener {
    
    private final String user;
    private final String pass;
    
    public ListenerMenu (String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
