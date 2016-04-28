/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import org.me.listeners.ListenerAltaEmpleado;
import org.me.util.Message;

/**
 *
 * @author JR
 */
public class PanelAltaEmpleado extends javax.swing.JPanel {

    private final String dbUser;
    private final String dbPassword;

    /**
     * Creates new form PanelAltaEmpleado
     *
     * @param dbUser
     * @param dbPassword
     */
    public PanelAltaEmpleado(String dbUser, String dbPassword) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        initComponents();
    }

    /**
     * Comprueba todas las validaciones de los campos
     *
     * @return true si se cumplen todas las validaciones, false de otro modo
     */
    public boolean datosValidos() {
        return camposLlenos()
                && telefonoValido()
                && emailValido()
                && sueldoValido()
                && usuarioValido()
                && passValido();
    }

    private boolean usuarioValido() {
        String user = jtfUsuario.getText();
        if (user.matches("[a-zA-Z]{5,15}") && !user.matches("[áéíóúÁÉÍÓÚñÑ]")) {
            return true;
        } else {
            Message.showErrorMessage("Error en el campo del usuario.\n"
                    + "Debe contener sólo letras mayúsculas y minúsculas "
                    + "sin acentos y sin la letra Ñ y de 5 a 15 caracteres.");
            return false;
        }
    }

    /**
     * Comprueba que el sueldo sea una cantidad double válida
     *
     * @return true si el campo es válido, false de otro modo
     */
    private boolean sueldoValido() {
        double sueldo;
        try {
            sueldo = Double.parseDouble(jtfSalario.getText());
            return true;
        } catch (NumberFormatException ex) {
            Message.showErrorMessage("Error en el campo del sueldo.\nDebe contener"
                    + " una cantidad doble válida");
            return false;
        }
    }

    public boolean telefonoValido() {
        String telefono = jtfCelular.getText();
        if (telefono.matches("[0-9]{10}")) {
            return true;
        } else {
            Message.showErrorMessage("Error en el campo teléfono.\n Debe contener"
                    + " sólo 10 dígitos.");
            return false;
        }
    }

    /**
     * Comprueba que el email tenga la siguiente forma algo@algo.algo
     *
     * @return true si el campo es válido, false de otro modo
     */
    private boolean emailValido() {
        String email = jtfEmail.getText();
        if (email.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            return true;
        } else {
            Message.showErrorMessage("Error en el campo del email.\n Debe contener"
                    + " un correo electrónico válido de la forma"
                    + " algo@algo.com");
            return false;
        }
    }

    /**
     * Comprueba que la contraseña tenga de 8 a 16 caracteres, mayúsculas,
     * minúsculas y números
     *
     * @return true si el campo es válido, false de otro modo
     */
    private boolean passValido() {
        String pass = new String(jpContrasena.getPassword());
        if (pass.matches("[a-zA-Z0-9]{8,16}")) {
            String pass2 = new String(jpfConfirmar.getPassword());
            if (pass.equals(pass2)) {
                return true;
            } else {
                Message.showErrorMessage("Error, las contraseñas no coinciden.");
                return false;
            }
        } else {
            Message.showErrorMessage("Error en la campo contraseña.\nDebe tener al "
                    + "menos 8 caracteres, máximo 16, y sólo puede"
                    + " contener minúsculas, mayúsculas y números.");
            return false;
        }
    }

    /**
     * Comprueba que todos los campos estén llenos
     *
     * @return true si el campo es válido, false de otro modo
     */
    private boolean camposLlenos() {
        if (!jtfNombreEmpleado.getText().isEmpty()
                && !jtfApellidoPaterno.getText().isEmpty()
                && !jtfApellidoMaterno.getText().isEmpty()
                && !jtfCelular.getText().isEmpty()
                && !jtfDireccion.getText().isEmpty()
                && !jtfEmail.getText().isEmpty()
                && !jtfSalario.getText().isEmpty()
                && jpContrasena.getPassword().length != 0) {
            return true;
        } else {
            Message.showErrorMessage("Faltan campos por llenar.");
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jcbTurno = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbTipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jpfConfirmar = new javax.swing.JPasswordField();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setLayout(new java.awt.GridBagLayout());

        jlNombreEmpleado.setText("Nombre del empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jlNombreEmpleado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 430;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jtfNombreEmpleado, gridBagConstraints);

        jlApellidoPaterno.setText("Apellido paterno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jlApellidoPaterno, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 430;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jtfApellidoPaterno, gridBagConstraints);

        jlApellidoMaterno.setText("Apellido materno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jlApellidoMaterno, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 430;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jtfApellidoMaterno, gridBagConstraints);

        jlCelular.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        add(jlCelular, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 430;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(jtfCelular, gridBagConstraints);

        jlDireccion.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 0, 0);
        add(jlDireccion, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 387;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 1, 0, 0);
        add(jtfDireccion, gridBagConstraints);

        jlFecha.setText("Selecciona en el calendario la fecha de ingreso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(jlFecha, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 1, 0, 0);
        add(jcFechaIngreso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 42;
        gridBagConstraints.ipadx = 1094;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 12);
        add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 37;
        gridBagConstraints.ipadx = 546;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(jSeparator2, gridBagConstraints);

        jlSalario.setText("Salario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 12, 0, 0);
        add(jlSalario, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 30;
        gridBagConstraints.ipadx = 412;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        add(jtfSalario, gridBagConstraints);

        jlHorarioEntrada.setText("Horario de Entrada");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 12, 0, 0);
        add(jlHorarioEntrada, gridBagConstraints);

        jsHoraE.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 2, 0, 0);
        add(jsHoraE, gridBagConstraints);

        jsMinutosE.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 12, 0, 0);
        add(jsMinutosE, gridBagConstraints);

        jlHoraSalida.setText("Hora de Salida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 21, 0, 0);
        add(jlHoraSalida, gridBagConstraints);

        jsHoraS.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 2, 0, 0);
        add(jsHoraS, gridBagConstraints);

        jsMinutosS.setModel(new javax.swing.SpinnerListModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(jsMinutosS, gridBagConstraints);

        jlContrasena.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 23, 0, 0);
        add(jlContrasena, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 356;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 14, 0, 12);
        add(jpContrasena, gridBagConstraints);

        jbAceptar.setText("Aceptar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 25;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 16, 0);
        add(jbAceptar, gridBagConstraints);

        jlEmail.setText("Correo electrónico");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jlEmail, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 25;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 387;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 0);
        add(jtfEmail, gridBagConstraints);

        jLabel1.setText("Turno");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 21, 0, 0);
        add(jLabel1, gridBagConstraints);

        jcbTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Matutino", "Vespertino", "Nocturno"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 2, 0, 0);
        add(jcbTurno, gridBagConstraints);

        jLabel2.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 12, 0, 0);
        add(jLabel2, gridBagConstraints);

        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Empleado", "Mucama"}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 23;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 2, 0, 0);
        add(jcbTipo, gridBagConstraints);

        jLabel3.setText("Nombre de Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 23, 0, 0);
        add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 356;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 14, 0, 12);
        add(jtfUsuario, gridBagConstraints);

        jLabel4.setText("Confirmar Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 37;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 18, 0, 0);
        add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 41;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 356;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 14, 0, 12);
        add(jpfConfirmar, gridBagConstraints);
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

    public JLabel getJlEmail() {
        return jlEmail;
    }

    public void setJlEmail(JLabel jlEmail) {
        this.jlEmail = jlEmail;
    }

    public JTextField getJtfEmail() {
        return jtfEmail;
    }

    public void setJtfEmail(JTextField jtfEmail) {
        this.jtfEmail = jtfEmail;
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

    public void addListener(ListenerAltaEmpleado listener) {
        jbAceptar.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JButton jbAceptar;
    private com.toedter.calendar.JCalendar jcFechaIngreso;
    private javax.swing.JComboBox jcbTipo;
    private javax.swing.JComboBox jcbTurno;
    private javax.swing.JLabel jlApellidoMaterno;
    private javax.swing.JLabel jlApellidoPaterno;
    private javax.swing.JLabel jlCelular;
    private javax.swing.JLabel jlContrasena;
    private javax.swing.JLabel jlDireccion;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFecha;
    private javax.swing.JLabel jlHoraSalida;
    private javax.swing.JLabel jlHorarioEntrada;
    private javax.swing.JLabel jlNombreEmpleado;
    private javax.swing.JLabel jlSalario;
    private javax.swing.JPasswordField jpContrasena;
    private javax.swing.JPasswordField jpfConfirmar;
    private javax.swing.JSpinner jsHoraE;
    private javax.swing.JSpinner jsHoraS;
    private javax.swing.JSpinner jsMinutosE;
    private javax.swing.JSpinner jsMinutosS;
    private javax.swing.JTextField jtfApellidoMaterno;
    private javax.swing.JTextField jtfApellidoPaterno;
    private javax.swing.JTextField jtfCelular;
    private javax.swing.JTextField jtfDireccion;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNombreEmpleado;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JTextField jtfUsuario;
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

    /**
     * @return the jcbTurno
     */
    public javax.swing.JComboBox getJcbTurno() {
        return jcbTurno;
    }

    /**
     * @return the jcbTipo
     */
    public javax.swing.JComboBox getJcbTipo() {
        return jcbTipo;
    }

    /**
     * @return the jpfConfirmar
     */
    public javax.swing.JPasswordField getJpfConfirmar() {
        return jpfConfirmar;
    }

    /**
     * @return the jtfUsuario
     */
    public javax.swing.JTextField getJtfUsuario() {
        return jtfUsuario;
    }
}
