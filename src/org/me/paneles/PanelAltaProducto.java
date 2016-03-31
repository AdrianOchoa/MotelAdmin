/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import com.toedter.components.JSpinField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import org.me.listeners.ListenerAltaProducto;

/**
 *
 * @author JR
 */
public class PanelAltaProducto extends javax.swing.JPanel {
    
    private final String dbUser;
    private final String dbPass;

    /**
     * Creates new form PanelAltaEmpleado
     * @param dbUser
     * @param dbPass
     */
    public PanelAltaProducto(String dbUser, String dbPass) {
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        initComponents();
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
        jlNombreProducto = new javax.swing.JLabel();
        jtfNombreProducto = new javax.swing.JTextField();
        jlMarca = new javax.swing.JLabel();
        jtfMarca = new javax.swing.JTextField();
        jlExistencias = new javax.swing.JLabel();
        jtfExistencias = new javax.swing.JTextField();
        jlPrecioUnitario = new javax.swing.JLabel();
        jtfPrecioUnitario = new javax.swing.JTextField();
        jlPrecioTotal = new javax.swing.JLabel();
        jtfPrecioTotal = new javax.swing.JTextField();
        jlTipo = new javax.swing.JLabel();
        jtfTipo = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jlNombreProducto.setText("Nombre del producto");

        jlMarca.setText("Marca");

        jlExistencias.setText("Existencias");

        jlPrecioUnitario.setText("Precio unitario");

        jlPrecioTotal.setText("Precio total");

        jlTipo.setText("Tipo");

        jbAceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPrecioTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlNombreProducto)
                            .addComponent(jlMarca)
                            .addComponent(jlExistencias)
                            .addComponent(jlPrecioUnitario)
                            .addComponent(jlPrecioTotal)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfExistencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                                    .addComponent(jtfMarca, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfNombreProducto)
                                    .addComponent(jtfPrecioUnitario, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(jbAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombreProducto)
                    .addComponent(jtfNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMarca)
                    .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlExistencias)
                    .addComponent(jtfExistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecioUnitario)
                    .addComponent(jtfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecioTotal)
                    .addComponent(jtfPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlTipo)
                    .addComponent(jtfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jbAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public JRadioButtonMenuItem getjRadioButtonMenuItem1() {
        return jRadioButtonMenuItem1;
    }

    public void setjRadioButtonMenuItem1(JRadioButtonMenuItem jRadioButtonMenuItem1) {
        this.jRadioButtonMenuItem1 = jRadioButtonMenuItem1;
    }

    public JSpinField getjSpinField1() {
        return jSpinField1;
    }

    public void setjSpinField1(JSpinField jSpinField1) {
        this.jSpinField1 = jSpinField1;
    }

    public JButton getJbAceptar() {
        return jbAceptar;
    }

    public void setJbAceptar(JButton jbAceptar) {
        this.jbAceptar = jbAceptar;
    }

    public JLabel getJlExistencias() {
        return jlExistencias;
    }

    public void setJlExistencias(JLabel jlExistencias) {
        this.jlExistencias = jlExistencias;
    }

    public JLabel getJlMarca() {
        return jlMarca;
    }

    public void setJlMarca(JLabel jlMarca) {
        this.jlMarca = jlMarca;
    }

    public JLabel getJlNombreProducto() {
        return jlNombreProducto;
    }

    public void setJlNombreProducto(JLabel jlNombreProducto) {
        this.jlNombreProducto = jlNombreProducto;
    }

    public JLabel getJlPrecioTotal() {
        return jlPrecioTotal;
    }

    public void setJlPrecioTotal(JLabel jlPrecioTotal) {
        this.jlPrecioTotal = jlPrecioTotal;
    }

    public JLabel getJlPrecioUnitario() {
        return jlPrecioUnitario;
    }

    public void setJlPrecioUnitario(JLabel jlPrecioUnitario) {
        this.jlPrecioUnitario = jlPrecioUnitario;
    }

    public JLabel getJlTipo() {
        return jlTipo;
    }

    public void setJlTipo(JLabel jlTipo) {
        this.jlTipo = jlTipo;
    }

    public JTextField getJtfExistencias() {
        return jtfExistencias;
    }

    public void setJtfExistencias(JTextField jtfExistencias) {
        this.jtfExistencias = jtfExistencias;
    }

    public JTextField getJtfMarca() {
        return jtfMarca;
    }

    public void setJtfMarca(JTextField jtfMarca) {
        this.jtfMarca = jtfMarca;
    }

    public JTextField getJtfNombreProducto() {
        return jtfNombreProducto;
    }

    public void setJtfNombreProducto(JTextField jtfNombreProducto) {
        this.jtfNombreProducto = jtfNombreProducto;
    }

    public JTextField getJtfPrecioTotal() {
        return jtfPrecioTotal;
    }

    public void setJtfPrecioTotal(JTextField jtfPrecioTotal) {
        this.jtfPrecioTotal = jtfPrecioTotal;
    }

    public JTextField getJtfPrecioUnitario() {
        return jtfPrecioUnitario;
    }

    public void setJtfPrecioUnitario(JTextField jtfPrecioUnitario) {
        this.jtfPrecioUnitario = jtfPrecioUnitario;
    }

    public JTextField getJtfTipo() {
        return jtfTipo;
    }

    public void setJtfTipo(JTextField jtfTipo) {
        this.jtfTipo = jtfTipo;
    }

   public boolean datosValidos () {
       return camposLLenos() && existenciasValidas() && precioUValido() && precioTValido();
   }
   
   private boolean existenciasValidas () {
       try {
           Integer.parseInt(jtfExistencias.getText());
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
   
   private boolean camposLLenos () {
       return !jtfNombreProducto.getText().isEmpty() && 
               !jtfMarca.getText().isEmpty() && 
               !jtfExistencias.getText().isEmpty() &&
               !jtfPrecioUnitario.getText().isEmpty() &&
               !jtfPrecioTotal.getText().isEmpty() && 
               !jtfTipo.getText().isEmpty();
   }
   
   private boolean precioTValido () {
       try {
           Double.parseDouble(jtfPrecioTotal.getText());
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
   
   private boolean precioUValido () {
       try {
           Double.parseDouble(jtfPrecioUnitario.getText());
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private com.toedter.components.JSpinField jSpinField1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JLabel jlExistencias;
    private javax.swing.JLabel jlMarca;
    private javax.swing.JLabel jlNombreProducto;
    private javax.swing.JLabel jlPrecioTotal;
    private javax.swing.JLabel jlPrecioUnitario;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JTextField jtfExistencias;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfNombreProducto;
    private javax.swing.JTextField jtfPrecioTotal;
    private javax.swing.JTextField jtfPrecioUnitario;
    private javax.swing.JTextField jtfTipo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the dbUser
     */
    public String getDbUser() {
        return dbUser;
    }

    /**
     * @return the dbPass
     */
    public String getDbPass() {
        return dbPass;
    }
    
    public void addListener (ListenerAltaProducto listener) {
        jbAceptar.addActionListener(listener);
    }
    
}
