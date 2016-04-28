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
import javax.swing.DefaultComboBoxModel;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelRentaHabitacion;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerRentaHabitacion implements ActionListener {

    private final PanelRentaHabitacion panel;
    private final String dbUser;
    private final String dbPass;

    public ListenerRentaHabitacion(PanelRentaHabitacion panel,
            String dbUser, String dbPass) {
        this.panel = panel;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idHabitacion;
        String fecha;
        String hora;
        idHabitacion = panel.getJcbIDHabitacion().getSelectedItem().toString().split("[,]+")[0];
        StringBuilder sb = new StringBuilder();
        sb.append(panel.getJcFecha().getCalendar().get(Calendar.YEAR));
        sb.append("-");
        sb.append(panel.getJcFecha().getCalendar().get(Calendar.MONTH) + 1);
        sb.append("-");
        sb.append(panel.getJcFecha().getCalendar().get(Calendar.DAY_OF_MONTH));
        fecha = sb.toString();
        sb = new StringBuilder();
        sb.append(panel.getJsHora().getValue().toString());
        sb.append(":");
        sb.append(panel.getJsMinutos().getValue().toString());
        sb.append(":00");
        hora = sb.toString();
        try {
            DataBaseHelper dbh = new DataBaseHelper(dbUser, dbPass);
            dbh.iniciarConexion();
            dbh.rentaHabitacion(dbUser, Integer.parseInt(idHabitacion), hora, fecha);
            dbh.cerrarConexion();
            Message.showInfoMessage("La operación se realizó con éxito.");
            panel.getJcbIDHabitacion().setModel(new DefaultComboBoxModel(panel.getHabitacionesDisponibles()));
        } catch (SQLException | ClassNotFoundException ex) {
            Message.showErrorMessage("Error al realizar el proceso.\n" + ex.getMessage());
        }
    }

}
