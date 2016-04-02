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
import javax.swing.JOptionPane;
import org.me.modelos.Backup;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.paneles.PanelConsultas;
import org.me.util.Message;
import org.me.ventanas.VentanaConsulta;
import org.me.ventanas.VentanaEstandar;

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
                try {
                    String id = JOptionPane.showInputDialog(null,
                            "Buscar ID empleado", "Buscar", JOptionPane.QUESTION_MESSAGE);
                    if (!id.isEmpty()) {
                        PanelConsultas panel = new PanelConsultas(user, pass, 3, id);
                        VentanaConsulta ventana = new VentanaConsulta(panel);
                    } else {
                        Message.showErrorMessage("Debe especificar un ID.");
                    }
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Message.showErrorMessage("Error.\n" + ex.getMessage());
                }
                break;
            case "Baja de empleados":
                System.out.println("Baja de empleados");
                break;
            case "Busqueda en el inventario":
                try {
                    String id = JOptionPane.showInputDialog(null,
                            "Buscar ID producto", "Buscar", JOptionPane.QUESTION_MESSAGE);
                    if (!id.isEmpty()) {
                        PanelConsultas panel = new PanelConsultas(user, pass, 4, id);
                        VentanaConsulta ventana = new VentanaConsulta(panel);
                    } else {
                        Message.showErrorMessage("Debe especificar un ID.");
                    }
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    Message.showErrorMessage("Error.\n" + ex.getMessage());
                }
                break;
            case "Baja en el inventario":
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
