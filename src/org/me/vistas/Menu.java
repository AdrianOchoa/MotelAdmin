/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import org.me.listeners.ListenerMenu;

/**
 *
 * @author Adrián
 */
public class Menu extends JMenuBar {

    private JMenu jmEmpleados;
    private JMenuItem jmiEmpLista;
    private JMenuItem jmiEmpBusqueda;
    private JMenuItem jmiEmpAlta;
    private JMenuItem jmiEmpBaja;

    private JMenu jmInventario;
    private JMenuItem jmiInvLista;
    private JMenuItem jmiInvBusqueda;
    private JMenuItem jmiInvAlta;
    private JMenuItem jmiInvBaja;

    private JMenu jmReportes;
    private JMenuItem verReporte;
    private JMenuItem exportarReporte;

    private JMenu jmRespaldo;
    private JMenuItem jmiRespBackup;
    private JMenuItem jmiRespRestore;

    private JMenu jmProceso;
    private JMenuItem jmiReabastecerInventario;
    private JMenuItem jmiReabastecerHabitacion;
    private JMenuItem jmiRentaHabitacion;
    private JMenuItem jmiLiberarHabitacion;
    private JMenuItem jmiMandarServicioHabitacion;

    private JMenu jmAyuda;
    private JMenuItem jmiAyudaManual;
    private JMenuItem jmiAyudaAcerca;

    /**
     *
     */
    public Menu() {
        initMenu();
    }

    private void initMenu() {
        jmEmpleados = new JMenu("Empleados");
        jmiEmpLista = new JMenuItem("Lista de empleados");
        agregarParametros(jmiEmpLista, KeyEvent.VK_1,
                "Muestra la lista de empleados", jmEmpleados, "listaEmpleados", "/org/me/resources/list.png");
        jmiEmpBusqueda = new JMenuItem("Busqueda de empleados");
        agregarParametros(jmiEmpBusqueda, KeyEvent.VK_2,
                "Busca un empleado específico", jmEmpleados, "busquedaEmpleados", "/org/me/resources/search.png");
        jmiEmpAlta = new JMenuItem("Alta de empleados");
        agregarParametros(jmiEmpAlta, KeyEvent.VK_3,
                "Da de alta un empleado", jmEmpleados, "altaEmpleados", "/org/me/resources/add.png");
        jmiEmpBaja = new JMenuItem("Baja de empleados");
        agregarParametros(jmiEmpBaja, KeyEvent.VK_4,
                "Da de baja a un empleado", jmEmpleados, "bajaEmpleados", "/org/me/resources/delete.png");
        this.add(jmEmpleados);

        jmInventario = new JMenu("Inventario");
        jmiInvLista = new JMenuItem("Lista del inventario");
        agregarParametros(jmiInvLista, KeyEvent.VK_5,
                "Muestra lo que se encuentra en el inventario", jmInventario, "listaObjetos", "/org/me/resources/list.png");
        jmiInvBusqueda = new JMenuItem("Busqueda en el inventario");
        agregarParametros(jmiInvBusqueda, KeyEvent.VK_6,
                "Busca un objeto especifico en el inventario", jmInventario, "busquedaObjetos", "/org/me/resources/search.png");
        jmiInvAlta = new JMenuItem("Alta en el inventario");
        agregarParametros(jmiInvAlta, KeyEvent.VK_7,
                "Dar de alta un objeto en el inventario", jmInventario, "altaInventario", "/org/me/resources/add.png");
        jmiInvBaja = new JMenuItem("Baja en el inventario");
        agregarParametros(jmiInvBaja, KeyEvent.VK_8,
                "Da de baja un objeto en el inventario", jmInventario, "bajaInventario", "/org/me/resources/delete.png");
        this.add(jmInventario);

        jmReportes = new JMenu("Reportes");
        verReporte = new JMenuItem("Ver reporte");
        agregarParametros(verReporte, KeyEvent.VK_W,
                "Muestra reporte", jmReportes, "verReporte", "/org/me/resources/ver.png");
        exportarReporte = new JMenuItem("Exportar reporte");
        agregarParametros(exportarReporte, KeyEvent.VK_E,
                "Exporta el reporte", jmReportes, "exportarReporte", "/org/me/resources/export.png");
        this.add(jmReportes);

        jmRespaldo = new JMenu("Respaldo");
        jmiRespBackup = new JMenuItem("Crear un respaldo");
        agregarParametros(jmiRespBackup, KeyEvent.VK_B,
                "Crea respaldo de la BD", jmRespaldo, "hacerRespaldo", "/org/me/resources/backup.png");
        jmiRespRestore = new JMenuItem("Restaurar desde respaldo");
        agregarParametros(jmiRespRestore, KeyEvent.VK_R,
                "Restaurar datos desde un respaldo", jmRespaldo, "restaurarRespaldo", "/org/me/resources/restore.png");
        this.add(jmRespaldo);

        jmProceso = new JMenu("Proceso");
        jmiReabastecerInventario = new JMenuItem("Reabastecer inventario");
        agregarParametros(jmiReabastecerInventario, KeyEvent.VK_I,
                "Cambia existencias del inventario", jmProceso, "modificarInventario", "/org/me/resources/reabastecer.png");
        jmiReabastecerHabitacion = new JMenuItem("Reabastecer habitacion");
        agregarParametros(jmiReabastecerHabitacion, KeyEvent.VK_J,
                "Reabastece inventario", jmProceso, "reabastecerInventario", "/org/me/resources/reabastecer.png");
        jmiRentaHabitacion = new JMenuItem("Renta de habitación");
        agregarParametros(jmiRentaHabitacion, KeyEvent.VK_H,
                "Reabastece inventario", jmProceso, "rentaHabitacion", "/org/me/resources/renta.png");
        jmiLiberarHabitacion = new JMenuItem("Liberar habitación");
        agregarParametros(jmiLiberarHabitacion, KeyEvent.VK_L,
                "Libera la habitación", jmProceso, "liberahabitacion", "/org/me/resources/renta.png");
        jmiMandarServicioHabitacion = new JMenuItem("Mandar Servicio a habitación");
        agregarParametros(jmiMandarServicioHabitacion, KeyEvent.VK_M,
                "Manda ka habitación a servicio", jmProceso, "serviciohabitacion", "/org/me/resources/renta.png");
        this.add(jmProceso);

        jmAyuda = new JMenu("Ayuda");
        jmiAyudaManual = new JMenuItem("Manual");
        agregarParametros(jmiAyudaManual, KeyEvent.VK_F1,
                "Manual de usuario", jmAyuda, "manual", "/org/me/resources/ayuda.png");
        jmiAyudaAcerca = new JMenuItem("Acerca de");
        agregarParametros(jmiAyudaAcerca, KeyEvent.VK_F2,
                "Acerca de", jmAyuda, "acerca", "/org/me/resources/acercade.png");
        this.add(jmAyuda);
    }

    /**
     *
     * @param item
     * @param keyEvent
     * @param accessibleDescription
     * @param menu
     * @param name
     */
    private void agregarParametros(JMenuItem item, int keyEvent,
            String accessibleDescription, JMenu menu, String name, String url) {
        item.setAccelerator(KeyStroke.getKeyStroke(
                keyEvent, ActionEvent.CTRL_MASK));
        item.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        item.setIcon(new ImageIcon(getClass().getResource(url)));
        menu.add(item);
        menu.addSeparator();
        item.setName(name);
    }

    public void addListener(ListenerMenu listener) {
        jmiEmpLista.addActionListener(listener);
        jmiEmpBusqueda.addActionListener(listener);
        jmiEmpAlta.addActionListener(listener);
        jmiEmpBaja.addActionListener(listener);
        jmiInvLista.addActionListener(listener);
        jmiInvBusqueda.addActionListener(listener);
        jmiInvAlta.addActionListener(listener);
        jmiInvBaja.addActionListener(listener);
        verReporte.addActionListener(listener);
        exportarReporte.addActionListener(listener);
        jmiRespBackup.addActionListener(listener);
        jmiRespRestore.addActionListener(listener);
        jmiReabastecerInventario.addActionListener(listener);
        jmiReabastecerHabitacion.addActionListener(listener);
        jmiRentaHabitacion.addActionListener(listener);
        jmiLiberarHabitacion.addActionListener(listener);
        jmiMandarServicioHabitacion.addActionListener(listener);
        jmiAyudaManual.addActionListener(listener);
        jmiAyudaAcerca.addActionListener(listener);
    }

}
