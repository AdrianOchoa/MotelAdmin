/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.paneles.PanelRentaHabitacion;
import org.me.ventanas.VentanaPrincipal;

/**
 *
 * @author Adrián
 */
public class ListenerMenu implements ActionListener {
    
    VentanaPrincipal ventana;
    ListenerMenu(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component source = (Component) e.getSource();
        switch (source.getName()) {

            case "listaEmpleados":

                System.out.println("1");
                break;

            case "busquedaEmpleados":
                System.out.println("2");

                break;

            case "altaEmpleados":
                System.out.println("3");
                JFrame f = new JFrame();
                f.setSize(620,600);
                f.setDefaultCloseOperation(2);
                
                PanelAltaEmpleado panel = new PanelAltaEmpleado();
                JScrollPane spPanel = new JScrollPane(panel);
                f.add(spPanel);
                f.setVisible(true);
                
                break;

            case "bajaEmpleados":
                System.out.println("4");

                break;

            case "listaObjetos":

                System.out.println("5");
                break;

            case "busquedaObjetos":
                System.out.println("6");

                break;

            case "altaInventario":

                f = new JFrame();
                f.setSize(550,301);
                f.setDefaultCloseOperation(2);
                
                PanelAltaProducto panel2 = new PanelAltaProducto();
                spPanel = new JScrollPane(panel2);
                f.add(spPanel);
                f.setVisible(true);

            case "bajaInventario":

                System.out.println("8");
                break;

            case "verReporte":

                System.out.println("9");
                break;

            case "exportarReporte":
                System.out.println("10");

                break;

            case "hacerRespaldo":
                System.out.println("11");

                break;

            case "restaurarRespaldo":
                System.out.println("12");

                break;

            case "manual":

                System.out.println("13");
                break;

            case "acerca":
                System.out.println("14");

                break;
            case "modificarInventario":
                System.out.println("15");

                break;
            case "reabastecerInventario":
                System.out.println("16");

                break;
            case "rentaHabitacion":
                f = new JFrame();
                f.setSize(550,549);
                f.setDefaultCloseOperation(2);
                
                PanelRentaHabitacion panel3 = new PanelRentaHabitacion();
                spPanel = new JScrollPane(panel3);
                f.add(spPanel);
                f.setVisible(true);
                break;

        }
    }

}
