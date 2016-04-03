/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.me.modelos.Backup;
import org.me.modelos.DataBaseHelper;
import org.me.modelos.Producto;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.paneles.PanelConsultas;
import org.me.util.Message;
import org.me.paneles.PanelID;
import org.me.ventanas.VentanaConsulta;
import org.me.ventanas.VentanaEstandar;
import org.me.ventanas.VentanaID;
import org.me.util.Utils;

/**
 *
 * @author Adrián
 */
public class ListenerMenu implements ActionListener {

    private final String user;
    private final String pass;

    /**
     *
     * @param user
     * @param pass
     */
    public ListenerMenu(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Alta de empleados":
                try {
                    PanelAltaEmpleado panelAltaEmpleado = new PanelAltaEmpleado(user, pass);
                    ListenerAltaEmpleado listener = new ListenerAltaEmpleado(panelAltaEmpleado);
                    panelAltaEmpleado.addListener(listener);
                    VentanaEstandar ventana = new VentanaEstandar(panelAltaEmpleado, 800, 700);
                } catch (IOException ex) {
                    Message.showErrorMessage(ex.getMessage());
                }
                break;
            case "Alta en el inventario":
                try {
                    PanelAltaProducto panelAltaProducto = new PanelAltaProducto(user, pass);
                    ListenerAltaProducto listener = new ListenerAltaProducto(panelAltaProducto);
                    panelAltaProducto.addListener(listener);
                    VentanaEstandar ventana = new VentanaEstandar(panelAltaProducto, 550, 300);
                } catch (IOException ex) {
                    Message.showErrorMessage(ex.getMessage());
                }
                break;
            case "Lista de empleados":
                try {
                    PanelConsultas panel = new PanelConsultas(user, pass, 1);
                    VentanaConsulta ventana = new VentanaConsulta(panel);
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Message.showErrorMessage("Error.\n" + ex.getMessage());
                }
                break;
            case "Lista del inventario": {
                try {
                    PanelConsultas panel = new PanelConsultas(user, pass, 2);
                    VentanaConsulta ventana = new VentanaConsulta(panel);
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Message.showErrorMessage("Error.\n" + ex.getMessage());
                }
            }
            break;
            case "Busqueda de empleados":

                PanelID p1;
                try {
                    p1 = new PanelID(Utils.elementosEmpleados(user, pass));
                    p1.addListener(new ListenerBusquedaEmpleados(user, pass, p1));
                    VentanaID ventana1 = new VentanaID("Busqueda de empleado");
                    ventana1.setSize(500, 100);
                    ventana1.add(p1);
                } catch (SQLException ex) {
                    System.out.println(ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListenerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            case "Baja de empleados":
                System.out.println("Baja de empleados");
                PanelID panelI;
                try {
                    panelI = new PanelID(Utils.elementosEmpleados(user, pass));
                    panelI.addListener(new ListenerBajaEmpleado(user, pass, panelI));
                    VentanaID ventana1 = new VentanaID("Baja de empleado");
                    ventana1.setSize(500, 100);
                    ventana1.add(panelI);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    break;
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    break;
                }
                break;
            case "Busqueda en el inventario":
                
                try {
                    p1 = new PanelID(Utils.elementosInventario(user, pass));
                    p1.addListener(new ListenerBusquedaInventario(user, pass, p1));
                    VentanaID ventana = new VentanaID("Busqueda en el inventario");
                    ventana.add(p1);
                    
                } catch (SQLException ex) {
                    System.out.println(ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListenerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Baja en el inventario":

                try {
                    panelI = new PanelID(Utils.elementosInventario(user, pass));
                    panelI.addListener(new ListenerBajaInventario(user, pass, panelI));
                    VentanaID ventana = new VentanaID("Baja en el inventario");
                    ventana.add(panelI);
                } catch (SQLException ex) {
                    System.out.println(ex);
                    break;
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    break;
                }

                System.out.println("baja inventario");
                break;
            case "Ver reporte":
                System.out.println("Ver reporte");
                break;
            case "Exportar reporte":
                System.out.println("Reporte");
                break;
            case "Crear un respaldo":
                Backup respaldo = new Backup(user, pass);
                respaldo.crearRespaldo();
                break;
            case "Restaurar desde respaldo":
                Backup restore = new Backup(user, pass);
                restore.restaurar();
                break;
            case "Modificar inventario":
                System.out.println("Modificar inventario");
                break;
            case "Reabastecer inventario":
                System.out.println("Reabastecer inventario");
                break;
            case "Renta de habitación":
                System.out.println("Renta hab");
                break;
            case "Manual":
                System.out.println("Manual");
                break;
            case "Acerca de":
                System.out.println("Acerca de");
                break;
            default:
                System.out.println("Hellou shabot!");
                break;
        }
    }

}
