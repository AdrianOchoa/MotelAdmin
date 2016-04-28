/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelAltaEmpleado;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerAltaEmpleado implements ActionListener {
    
    private final PanelAltaEmpleado panel;
    private DataBaseHelper dbh;
    private String dbUser;
    private String dbPass;
    
    private String nombreEmpleado;
    private String apellidoP;
    private String apellidoM;
    private String celular;
    private String direccion;
    private String email;
    private String fechaIngreso;
    private double salario;
    private String horaE;
    private String horaS;
    private String contra;
    private String turno;
    private String user;
    private String tipo;
    
    /**
     * 
     * @param panel 
     */
    public ListenerAltaEmpleado (PanelAltaEmpleado panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(panel.datosValidos()) {
            dbUser = panel.getDbUser();
            dbPass = panel.getDbPassword();
            dbh = new DataBaseHelper(dbUser, dbPass);
            String nombres [] = panel.getJtfNombreEmpleado().getText().split("[ ]+");
            nombreEmpleado = "";
            for (String nombre : nombres) {
                nombreEmpleado += nombre;
            }
            apellidoP = panel.getJtfApellidoPaterno().getText();
            apellidoM = panel.getJtfApellidoMaterno().getText();
            celular = panel.getJtfCelular().getText();
            direccion = panel.getJtfDireccion().getText();
            email = panel.getJtfEmail().getText();
            StringBuilder fecha = new StringBuilder();
            fecha.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.YEAR));
            fecha.append("-");
            fecha.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.MONTH) + 1);
            fecha.append("-");
            fecha.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.DAY_OF_MONTH));
            fechaIngreso = fecha.toString();
            salario = Double.parseDouble(panel.getJtfSalario().getText());
            StringBuilder entrada = new StringBuilder();
            entrada.append(panel.getJsHoraE().getValue().toString());
            entrada.append(":");
            entrada.append(panel.getJsMinutosE().getValue().toString());
            entrada.append(":00");
            horaE = entrada.toString();
            StringBuilder salida = new StringBuilder();
            salida.append(panel.getJsHoraS().getValue().toString());
            salida.append(":");
            salida.append(panel.getJsMinutosS().getValue().toString());
            salida.append(":00");
            horaS = salida.toString();
            contra = new String(panel.getJpContrasena().getPassword());
            turno = panel.getJcbTurno().getSelectedItem().toString();
            user = panel.getJtfUsuario().getText();
            tipo = panel.getJcbTipo().getSelectedItem().toString().toLowerCase();
            try {
                dbh.iniciarConexion();
                dbh.crearUsuario(nombreEmpleado, apellidoP, apellidoM, celular, 
                        direccion, email, fechaIngreso, salario, horaE, horaS, 
                        contra, turno, user, tipo);
                dbh.cerrarConexion();
                Message.showInfoMessage("Su usuario es: " + user + "\nSe ha dado de alta en el sistema correctamente.");
                limpiarCampos();
            } catch (ClassNotFoundException | SQLException ex) {
                Message.showErrorMessage("Error al crear el usuario en la base de datos.\n" + ex.getMessage());
            }
        } 
    }
    
    /**
     * resetea los campos del panel
     */
    private void limpiarCampos () {
        panel.getJtfNombreEmpleado().setText("");
        panel.getJtfApellidoPaterno().setText("");
        panel.getJtfApellidoMaterno().setText("");
        panel.getJtfCelular().setText("");
        panel.getJtfDireccion().setText("");
        panel.getJtfEmail().setText("");
        panel.getJtfSalario().setText("");
        panel.getJpContrasena().setText("");
        panel.getJtfUsuario().setText("");
        panel.getJpfConfirmar().setText("");
    }
    
}
