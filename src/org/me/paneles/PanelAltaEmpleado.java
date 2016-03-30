/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author JR
 */
public class PanelAltaEmpleado extends javax.swing.JPanel {
    
    private final String dbUser;
    private final String dbPassword;

    /**
     * Creates new form PanelAltaEmpleado
     * @param dbUser
     * @param dbPassword
     */
    public PanelAltaEmpleado(String dbUser, String dbPassword) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        initComponents();
    }
    
    public boolean datosValidos () {
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jSpinField1 = new com.toedter.components.JSpinField();
        jlNombreEmpleado = new javax.swing.JLabel();
        jtfNombreEmpleado = new javax.swing.JTextField();
        jlApellidoPaterno = new javax.swing.JLabel();
        jtfApellidoPaterno = new javax.swing.JTextField();
        jlApellidoMaterno = new javax.swing.JLabel();
        jtfApellidoMaterno = new javax.swing.JTextField();
        jlCelular = new javax.swing.JLabel();
        jtfCelular = new javax.swing.JTextField();
        jlDireccion = new javax.swing.JLabel();
        jtfDireccion = new javax.swing.JTextField();
        jlFecha = new javax.swing.JLabel();
        jcFechaIngreso = new com.toedter.calendar.JCalendar();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jlSalario = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();
        jlHorarioEntrada = new javax.swing.JLabel();
        jsHoraE = new javax.swing.JSpinner();
        jsMinutosE = new javax.swing.JSpinner();
        jlHoraSalida = new javax.swing.JLabel();
        jsHoraS = new javax.swing.JSpinner();
        jsMinutosS = new javax.swing.JSpinner();
        jlContrasena = new javax.swing.JLabel();
        jpContrasena = new javax.swing.JPasswordField();
        jbAceptar = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jlNombreEmpleado.setText("Nombre del empleado");

        jlApellidoPaterno.setText("Apellido paterno");

        jlApellidoMaterno.setText("Apellido materno");

        jlCelular.setText("Celular");

        jlDireccion.setText("Dirección");

        jlFecha.setText("Selecciona en el calendario la fecha de ingreso");

        jlSalario.setText("Salario");

        jlHorarioEntrada.setText("Horario de Entrada");

        jsHoraE.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        jsMinutosE.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));

        jlHoraSalida.setText("Hora de Salida");

        jsHoraS.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        jsMinutosS.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));

        jlContrasena.setText("Contraseña");

        jbAceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jlSalario)
                            .addGap(81, 81, 81)
                            .addComponent(jtfSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                        .addComponent(jlNombreEmpleado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlApellidoPaterno, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlApellidoMaterno, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlCelular, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlFecha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlHoraSalida)
                                    .addGap(44, 44, 44)
                                    .addComponent(jsHoraS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlHorarioEntrada)
                                    .addGap(22, 22, 22)
                                    .addComponent(jsHoraE, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jsMinutosE, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jsMinutosS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbAceptar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlContrasena)
                                .addGap(270, 270, 270)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfApellidoMaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfApellidoPaterno, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfNombreEmpleado)
                                .addComponent(jtfCelular, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombreEmpleado)
                    .addComponent(jtfNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApellidoPaterno)
                    .addComponent(jtfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlApellidoMaterno)
                    .addComponent(jtfApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCelular)
                    .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDireccion)
                    .addComponent(jtfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlFecha)
                .addGap(18, 18, 18)
                .addComponent(jcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlSalario)
                    .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHorarioEntrada)
                    .addComponent(jsHoraE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinutosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlHoraSalida)
                    .addComponent(jsHoraS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsMinutosS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlContrasena)
                    .addComponent(jpContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jbAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JCalendar getjCalendar1() {
        return jcFechaIngreso;
    }

    public void setjCalendar1(JCalendar jCalendar1) {
        this.jcFechaIngreso = jCalendar1;
    }

    public JRadioButtonMenuItem getjRadioButtonMenuItem1() {
        return jRadioButtonMenuItem1;
    }

    public void setjRadioButtonMenuItem1(JRadioButtonMenuItem jRadioButtonMenuItem1) {
        this.jRadioButtonMenuItem1 = jRadioButtonMenuItem1;
    }

    public JSeparator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JSeparator getjSeparator2() {
        return jSeparator2;
    }

    public void setjSeparator2(JSeparator jSeparator2) {
        this.jSeparator2 = jSeparator2;
    }

    public JSpinField getjSpinField1() {
        return jSpinField1;
    }

    public void setjSpinField1(JSpinField jSpinField1) {
        this.jSpinField1 = jSpinField1;
    }

    public JLabel getJlContrasena() {
        return jlContrasena;
    }

    public void setJlContrasena(JLabel jlContrasena) {
        this.jlContrasena = jlContrasena;
    }

    public JLabel getJlHoraSalida() {
        return jlHoraSalida;
    }

    public void setJlHoraSalida(JLabel jlHoraSalida) {
        this.jlHoraSalida = jlHoraSalida;
    }

    public JLabel getJlHorarioEntrada() {
        return jlHorarioEntrada;
    }

    public void setJlHorarioEntrada(JLabel jlHorarioEntrada) {
        this.jlHorarioEntrada = jlHorarioEntrada;
    }

    public JLabel getJlSalario() {
        return jlSalario;
    }

    public void setJlSalario(JLabel jlSalario) {
        this.jlSalario = jlSalario;
    }

    public JPasswordField getJpContrasena() {
        return jpContrasena;
    }

    public void setJpContrasena(JPasswordField jpContrasena) {
        this.jpContrasena = jpContrasena;
    }

    public JSpinner getJsHoraE() {
        return jsHoraE;
    }

    public void setJsHoraE(JSpinner jsHoraE) {
        this.jsHoraE = jsHoraE;
    }

    public JSpinner getJsHoraS() {
        return jsHoraS;
    }

    public void setJsHoraS(JSpinner jsHoraS) {
        this.jsHoraS = jsHoraS;
    }

    public JSpinner getJsMinutosE() {
        return jsMinutosE;
    }

    public void setJsMinutosE(JSpinner jsMinutosE) {
        this.jsMinutosE = jsMinutosE;
    }

    public JSpinner getJsMinutosS() {
        return jsMinutosS;
    }

    public void setJsMinutosS(JSpinner jsMinutosS) {
        this.jsMinutosS = jsMinutosS;
    }

    public JTextField getJtfSalario() {
        return jtfSalario;
    }

    public void setJtfSalario(JTextField jtfSalario) {
        this.jtfSalario = jtfSalario;
    }

    public JLabel getjLabel1() {
        return jlFecha;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jlFecha = jLabel1;
    }

    public JButton getJbAceptar() {
        return jbAceptar;
    }

    public void setJbAceptar(JButton jbAceptar) {
        this.jbAceptar = jbAceptar;
    }

    public JCalendar getJcFechaIngreso() {
        return jcFechaIngreso;
    }

    public void setJcFechaIngreso(JCalendar jcFechaIngreso) {
        this.jcFechaIngreso = jcFechaIngreso;
    }

    public JLabel getJlFecha() {
        return jlFecha;
    }

    public void setJlFecha(JLabel jlFecha) {
        this.jlFecha = jlFecha;
    }

   

    public JLabel getJlApellidoMaterno() {
        return jlApellidoMaterno;
    }

    public void setJlApellidoMaterno(JLabel jlApellidoMaterno) {
        this.jlApellidoMaterno = jlApellidoMaterno;
    }

    public JLabel getJlApellidoPaterno() {
        return jlApellidoPaterno;
    }

    public void setJlApellidoPaterno(JLabel jlApellidoPaterno) {
        this.jlApellidoPaterno = jlApellidoPaterno;
    }

    public JLabel getJlCelular() {
        return jlCelular;
    }

    public void setJlCelular(JLabel jlCelular) {
        this.jlCelular = jlCelular;
    }

    public JLabel getJlDireccion() {
        return jlDireccion;
    }

    public void setJlDireccion(JLabel jlDireccion) {
        this.jlDireccion = jlDireccion;
    }

    public JLabel getJlNombreEmpleado() {
        return jlNombreEmpleado;
    }

    public void setJlNombreEmpleado(JLabel jlNombreEmpleado) {
        this.jlNombreEmpleado = jlNombreEmpleado;
    }

    public JTextField getJtfApellidoMaterno() {
        return jtfApellidoMaterno;
    }

    public void setJtfApellidoMaterno(JTextField jtfApellidoMaterno) {
        this.jtfApellidoMaterno = jtfApellidoMaterno;
    }

    public JTextField getJtfApellidoPaterno() {
        return jtfApellidoPaterno;
    }

    public void setJtfApellidoPaterno(JTextField jtfApellidoPaterno) {
        this.jtfApellidoPaterno = jtfApellidoPaterno;
    }

    public JTextField getJtfCelular() {
        return jtfCelular;
    }

    public void setJtfCelular(JTextField jtfCelular) {
        this.jtfCelular = jtfCelular;
    }

    public JTextField getJtfDireccion() {
        return jtfDireccion;
    }

    public void setJtfDireccion(JTextField jtfDireccion) {
        this.jtfDireccion = jtfDireccion;
    }

    public JTextField getJtfNombreEmpleado() {
        return jtfNombreEmpleado;
    }

    public void setJtfNombreEmpleado(JTextField jtfNombreEmpleado) {
        this.jtfNombreEmpleado = jtfNombreEmpleado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JButton jbAceptar;
    private com.toedter.calendar.JCalendar jcFechaIngreso;
    private javax.swing.JLabel jlApellidoMaterno;
    private javax.swing.JLabel jlApellidoPaterno;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlContrasena;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHoraSalida;
    private javax.swing.JLabel jlHorarioEntrada;
    private javax.swing.JLabel jlNombreEmpleado;
    private javax.swing.JLabel jlSalario;
    private javax.swing.JPasswordField jpContrasena;
    private javax.swing.JSpinner jsHoraE;
    private javax.swing.JSpinner jsHoraS;
    private javax.swing.JSpinner jsMinutosE;
    private javax.swing.JSpinner jsMinutosS;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfCelular;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfNombreEmpleado;
    private javax.swing.JTextField jtfSalario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @return the dbPassword
     */
    public String getDbPassword() {
        return dbPassword;
    }
}
