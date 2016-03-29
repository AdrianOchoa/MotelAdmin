/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.vistas;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
    private JMenuItem jmiModificarInventario;
    private JMenuItem jmiReabastecerInventario;
            
            
    private JMenu jmAyuda;
    private JMenuItem jmiAyudaManual;
    private JMenuItem jmiAyudaAcerca;

    public Menu() {
        initMenu();
    }

    private void initMenu () {
        jmEmpleados = new JMenu("Empleados");
        jmiEmpLista = new JMenuItem("Lista de empleados");
        agregarParametros(jmiEmpLista, KeyEvent.VK_1, 
                "Muestra la lista de empleados", jmEmpleados, "listaEmpleados");
        jmiEmpBusqueda = new JMenuItem("Busqueda de empleados");
        agregarParametros(jmiEmpBusqueda, KeyEvent.VK_2, 
                "Busca un empleado específico", jmEmpleados, "busquedaEmpleados");
        jmiEmpAlta = new JMenuItem("Alta de empleados");
        agregarParametros(jmiEmpAlta, KeyEvent.VK_3, 
                "Da de alta un empleado", jmEmpleados, "altaEmpleados");
        jmiEmpBaja = new JMenuItem("Baja de empleados");
        agregarParametros(jmiEmpBaja, KeyEvent.VK_4, 
                "Da de baja a un empleado", jmEmpleados, "bajaEmpleados");
        this.add(jmEmpleados);

        jmInventario = new JMenu("Inventario");
        jmiInvLista = new JMenuItem("Lista del inventario");
        agregarParametros(jmiInvLista, KeyEvent.VK_5, 
                "Muestra lo que se encuentra en el inventario", jmInventario, "listaObjetos");
        jmiInvBusqueda = new JMenuItem("Busqueda en el inventario");
        agregarParametros(jmiInvBusqueda, KeyEvent.VK_6, 
                "Busca un objeto especifico en el inventario", jmInventario, "busquedaObjetos");
        jmiInvAlta = new JMenuItem("Alta en el inventario");
        agregarParametros(jmiInvAlta, KeyEvent.VK_7, 
                "Dar de alta un objeto en el inventario", jmInventario, "altaInventario");
        jmiInvBaja = new JMenuItem("Baja en el inventario");
        agregarParametros(jmiInvBaja, KeyEvent.VK_8, 
                "Da de baja un objeto en el inventario", jmInventario, "bajaInventario");
        this.add(jmInventario);
        
        jmReportes = new JMenu("Reportes");
        verReporte = new JMenuItem("Ver reporte");
        agregarParametros(verReporte, KeyEvent.VK_W, 
                "Muestra reporte", jmReportes, "verReporte");
        exportarReporte = new JMenuItem("Exportar reporte");
        agregarParametros(exportarReporte, KeyEvent.VK_E, 
                "Exporta el reporte", jmReportes, "exportarReporte");
        this.add(jmReportes);

        jmRespaldo = new JMenu("Respaldo");
        jmiRespBackup = new JMenuItem("Crear un respaldo");
        agregarParametros(jmiRespBackup, KeyEvent.VK_B, 
                "Crea respaldo de la BD", jmRespaldo, "hacerRespaldo");
        jmiRespRestore = new JMenuItem("Restaurar desde respaldo");
        agregarParametros(jmiRespRestore, KeyEvent.VK_R, 
                "Restaurar datos desde un respaldo", jmRespaldo, "restaurarRespaldo");
        this.add(jmRespaldo);
        
        jmProceso = new JMenu("Proceso");
        jmiModificarInventario = new JMenuItem("Modificar inventario");
        agregarParametros(jmiModificarInventario, KeyEvent.VK_I, 
                "Cambia existencias del inventario", jmProceso, "modificarInventario");
        jmiReabastecerInventario = new JMenuItem("Reabastecer inventario");
        agregarParametros(jmiReabastecerInventario, KeyEvent.VK_J, 
                "Reabastece inventario", jmProceso, "reabastecerInventario");
        this.add(jmProceso);

        jmAyuda = new JMenu("Ayuda");
        jmiAyudaManual = new JMenuItem("Manual");
        agregarParametros(jmiAyudaManual, KeyEvent.VK_F1, 
                "Manual de usuario", jmAyuda, "manual");
        jmiAyudaAcerca = new JMenuItem("Acerca de");
        agregarParametros(jmiAyudaAcerca, KeyEvent.VK_F2, 
                "Acerca de", jmAyuda, "acerca");
        this.add(jmAyuda);
    }

    private void agregarParametros(JMenuItem item, int keyEvent, 
            String accessibleDescription, JMenu menu, String name) {
        item.setAccelerator(KeyStroke.getKeyStroke(
                keyEvent, ActionEvent.CTRL_MASK));
        item.getAccessibleContext().setAccessibleDescription(accessibleDescription);
        menu.add(item);
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
        jmiModificarInventario.addActionListener(listener);
        jmiReabastecerInventario.addActionListener(listener);
        jmiAyudaManual.addActionListener(listener);
        jmiAyudaAcerca.addActionListener(listener);
    }

}
