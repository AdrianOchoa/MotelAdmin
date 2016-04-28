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
import org.me.modelos.Backup;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.paneles.PanelConsultas;
import org.me.paneles.PanelID;
import org.me.paneles.PanelLiberarHabitacion;
import org.me.paneles.PanelMandarHabitacionServicio;
import org.me.paneles.PanelReabastecimientoInventario;
import org.me.paneles.PanelReabastecimientoHabitacion;
import org.me.paneles.PanelRentaHabitacion;
import org.me.util.Message;
import org.me.util.Utils;
import org.me.ventanas.VentanaConsulta;
import org.me.ventanas.VentanaEstandar;
import org.me.ventanas.VentanaID;

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
                altaEmpleados();
                break;
            case "Lista de empleados":
                listaEmpleados();
                break;
            case "Busqueda de empleados":
                busquedaEmpleados();
                break;
            case "Baja de empleados":
                bajaEmpleados();
                break;
            case "Alta en el inventario":
                altaInventario();
                break;
            case "Lista del inventario":
                listaInventario();
                break;
            case "Busqueda en el inventario":
                busquedaInventario();
                break;
            case "Baja en el inventario":
                bajaInventario();
                break;
            case "Ver reporte":
                verReporte();
                break;
            case "Exportar reporte":
                System.out.println("Reporte");
                break;
            case "Crear un respaldo":
                backup();
                break;
            case "Restaurar desde respaldo":
                restore();
                break;
            case "Reabastecer habitacion":
                reabastecerHabitacion();
                break;
            case "Reabastecer inventario":
                reabastecerInventario();
                break;
            case "Renta de habitación":
                rentaHabitacion();
                break;
            case "Liberar habitación":
                liberarHabitacion();
                break;
            case "Mandar Servicio a habitación":
                mandarServicioHabitacion();
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

    private void altaEmpleados() {
        try {
            PanelAltaEmpleado panel = new PanelAltaEmpleado(user, pass);
            ListenerAltaEmpleado listener = new ListenerAltaEmpleado(panel);
            panel.addListener(listener);
            VentanaEstandar ventana = new VentanaEstandar(panel, 1050, 700);
        } catch (IOException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void listaEmpleados() {
        try {
            PanelConsultas panel = new PanelConsultas(user, pass, 1);
            VentanaConsulta ventana = new VentanaConsulta(panel);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void busquedaEmpleados() {
        try {
            PanelID p1 = new PanelID(Utils.elementosEmpleados(user, pass, true));
            p1.addListener(new ListenerBusquedaEmpleados(user, pass, p1));
            VentanaID ventana1 = new VentanaID("Busqueda de empleado");
            ventana1.setSize(500, 100);
            ventana1.add(p1);
        } catch (SQLException | ClassNotFoundException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void bajaEmpleados() {
        try {
            Object[] empleados = Utils.elementosEmpleados(user, pass, false);
            if (empleados.length > 0) {
                PanelID panelI = new PanelID(empleados);
                panelI.addListener(new ListenerBajaEmpleado(user, pass, panelI));
                VentanaID ventana1 = new VentanaID("Baja de empleado");
                ventana1.setSize(500, 100);
                ventana1.add(panelI);
            } else {
                Message.showErrorMessage("Error.\nNo existen empleados para dar de baja.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void altaInventario() {
        try {
            PanelAltaProducto panel = new PanelAltaProducto(user, pass);
            ListenerAltaProducto listener = new ListenerAltaProducto(panel);
            panel.addListener(listener);
            VentanaEstandar ventana = new VentanaEstandar(panel, 550, 300);
        } catch (IOException ex) {
            Message.showErrorMessage(ex.getMessage());
        }
    }

    private void listaInventario() {
        try {
            PanelConsultas panel = new PanelConsultas(user, pass, 2);
            VentanaConsulta ventana = new VentanaConsulta(panel);
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void busquedaInventario() {
        try {
            PanelID p1 = new PanelID(Utils.elementosInventario(user, pass));
            p1.addListener(new ListenerBusquedaInventario(user, pass, p1));
            VentanaID ventana = new VentanaID("Busqueda en el inventario");
            ventana.add(p1);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private void bajaInventario() {
        try {
            Object[] inventario = Utils.elementosInventario(user, pass);
            if (inventario.length > 0) {
                PanelID panelI = new PanelID(inventario);
                panelI.addListener(new ListenerBajaInventario(user, pass, panelI));
                VentanaID ventana = new VentanaID("Baja en el inventario");
                ventana.add(panelI);
            } else {
                Message.showErrorMessage("Error.\nNo hay productos en el inventario.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void verReporte() {
        try {
            String[] elementos = {"Reporte de reabastecimiento",
                "Reporte de Renta"};
            PanelID p1 = new PanelID(elementos);
            p1.addListener(new ListenerReporte(user, pass, p1));
            VentanaID ventana = new VentanaID("Busqueda en el inventario");
            ventana.add(p1);
        } catch (Exception ex) {
            Message.showErrorMessage("Error.\n" + ex);
        }
    }

    private void backup() {
        Backup respaldo = new Backup(user, pass);
        respaldo.crearRespaldo();
    }

    private void restore() {
        Backup restore = new Backup(user, pass);
        restore.restaurar();
    }

    private void reabastecerHabitacion() {
        try {
            PanelReabastecimientoHabitacion panel = new PanelReabastecimientoHabitacion(user, pass);
            if (panel.getHabitacionesOcupadas().length > 0) {
                ListenerReabastecerHabitacion listener = new ListenerReabastecerHabitacion(panel);
                panel.addListener(listener);
                VentanaEstandar ventana = new VentanaEstandar(panel);
            } else {
                Message.showErrorMessage("Error.\nNo hay habitaciones que necesiten ser reabastecidas.");
            }
        } catch (IOException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void reabastecerInventario() {
        try {
            PanelReabastecimientoInventario panel = new PanelReabastecimientoInventario(user, pass);
            ListenerModificarProducto listener = new ListenerModificarProducto(panel);
            panel.addListener(listener);
            VentanaEstandar ventana = new VentanaEstandar(panel, 600, 300);
        } catch (Exception ex) {
            Message.showErrorMessage(ex.getMessage());
        }
    }

    private void rentaHabitacion() {
        try {
            DataBaseHelper dbh = new DataBaseHelper(user, pass);
            dbh.iniciarConexion();
            if (dbh.habitacionesDisponibles()) {
                PanelRentaHabitacion panel = new PanelRentaHabitacion(user, pass);
                ListenerRentaHabitacion listener = new ListenerRentaHabitacion(panel, user, pass);
                panel.addListener(listener);
                VentanaEstandar ventana = new VentanaEstandar(panel, 520, 550);
            } else {
                Message.showErrorMessage("Error.\nNo hay habitaciones disponibles.");
            }
            dbh.cerrarConexion();
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Message.showErrorMessage("Error.\n" + ex.getMessage());
        }
    }

    private void liberarHabitacion() {
        PanelLiberarHabitacion panel = new PanelLiberarHabitacion(user, pass);
        if (panel.getHabitacionesOcupadas().length > 0) {
            try {
                ListenerLiberarHabitaciones listener = new ListenerLiberarHabitaciones(panel);
                panel.addListener(listener);
                VentanaEstandar ventana = new VentanaEstandar(panel, 300, 200);
            } catch (IOException ex) {
                Message.showErrorMessage("Error.\n" + ex.getMessage());
            }
        } else {
            Message.showErrorMessage("Error.\nNo hay habitaciones para liberar.");
        }
    }

    private void mandarServicioHabitacion() {
        PanelMandarHabitacionServicio panel = new PanelMandarHabitacionServicio(user, pass);
        if (panel.getHabitacionesOcupadas().length > 0) {
            try {
                ListenerMandarHabitacionServicio listener = new ListenerMandarHabitacionServicio(panel);
                panel.addListener(listener);
                VentanaEstandar ventana = new VentanaEstandar(panel, 300, 200);
            } catch (IOException ex) {
                Message.showErrorMessage("Error.\n" + ex.getMessage());
            }
        } else {
            Message.showErrorMessage("Error.\nNo hay habitaciones para mandar a servicio.");
        }
    }

}
