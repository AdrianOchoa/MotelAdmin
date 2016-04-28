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
import javax.swing.SwingUtilities;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelReabastecimientoHabitacion;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class ListenerReabastecerHabitacion implements ActionListener {

    private final PanelReabastecimientoHabitacion panel;

    public ListenerReabastecerHabitacion(PanelReabastecimientoHabitacion panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Aceptar":
                if (panel.datosValidos()) {
                    try {
                        String usuario = panel.getDbUser();
                        String pass = panel.getDbPassword();
                        int prodEnc = Integer.parseInt(panel.getJtfProductoEncontrado().getText());
                        int prodDep = Integer.parseInt(panel.getJtfProductoDepositado().getText());
                        String fecha;
                        StringBuilder sb = new StringBuilder();
                        sb.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.YEAR));
                        sb.append("-");
                        sb.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.MONTH) + 1);
                        sb.append("-");
                        sb.append(panel.getJcFechaIngreso().getCalendar().get(Calendar.DAY_OF_MONTH));
                        fecha = sb.toString();
                        String hora;
                        sb = new StringBuilder();
                        sb.append(panel.getJsHoraD().getValue().toString());
                        sb.append(":");
                        sb.append(panel.getJsMinutosD().getValue().toString());
                        sb.append(":00");
                        hora = sb.toString();
                        int idProducto = Integer.parseInt(panel.getJcbProducto().getSelectedItem().toString().split("[,]+")[0]);
                        int idHabitacion = Integer.parseInt(panel.getJcbHabitacion().getSelectedItem().toString().split("[,]+")[0]);
                        DataBaseHelper dbh = new DataBaseHelper(usuario, pass);
                        dbh.iniciarConexion();
                        dbh.insertReabastecimiento(usuario, prodEnc, prodDep, hora, fecha, idProducto, idHabitacion);
                        dbh.cerrarConexion();
                        Message.showInfoMessage("Se realizó correctamente.");
                        limpiar();
                    } catch (ClassNotFoundException | SQLException ex) {
                        Message.showErrorMessage("Error.\n" + ex.getMessage());
                    }
                }
                break;
        }
    }

    private void limpiar() {
        panel.getJtfProductoDepositado().setText("");
        panel.getJtfProductoEncontrado().setText("");
    }

}
