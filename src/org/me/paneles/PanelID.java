/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author JR
 */
public class PanelID extends JPanel{
    private JComboBox elementos;
    private JButton aceptar;
    
    public PanelID(Object[] elementosA){
        super();
        init(elementosA);
    }
    
    private void init(Object[] elementosA){
        this.setLayout(new BorderLayout());
        elementos = new JComboBox(elementosA);
        aceptar = new JButton("Aceptar");
        JPanel panelCentro = new JPanel();
        panelCentro.add(elementos);
        JPanel panelSur = new JPanel();
        panelSur.add(aceptar);
        this.add(panelCentro, "Center");
        this.add(panelSur, "South");
        
    }
    
    public void addListener(ActionListener a){
        aceptar.addActionListener(a);
    }

    public JComboBox getElementos() {
        return elementos;
    }

    public void setElementos(JComboBox elementos) {
        this.elementos = elementos;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
    }
    
    
    
}
