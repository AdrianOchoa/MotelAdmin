/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.listeners;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.me.modelos.DataBaseHelper;
import org.me.paneles.PanelAltaEmpleado;
import org.me.paneles.PanelAltaProducto;
import org.me.util.Message;
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

                String consulta = "select idEmpleado,nombreEmpleado, "
                        + "apellidoPE , apellidoME, celular,direccion,email, fechaIngreso,salario,horarioE, horarioS, turnoSemana from sistema_motel.Empleado;";
                hacerLista(consulta);
                break;
            case "Lista del inventario":

                hacerLista("select * from Producto");
                break;
            case "Busqueda de empleados":
                System.out.println("Busqueda de empleados");
                String id = JOptionPane.showInputDialog(null, "Buscar ID empleado", "Buscar", JOptionPane.QUESTION_MESSAGE);
                consulta = "select idEmpleado,nombreEmpleado, "
                        + "apellidoPE , apellidoME, celular,direccion,email, fechaIngreso,salario,horarioE, "
                        + "horarioS, turnoSemana from sistema_motel.Empleado "
                        + "where idEmpleado = " + id + ";";
                System.out.println(consulta);
                hacerLista(consulta);
                break;
            case "Baja de empleados":
                System.out.println("Baja de empleados");
                break;
            case "Busqueda en el inventario":
                id = JOptionPane.showInputDialog(null, "Buscar ID producto", "Buscar", JOptionPane.QUESTION_MESSAGE);
                consulta = "select * from sistema_motel.Producto where idProducto=" + id + ";";
                System.out.println("Busqueda inventario");
                hacerLista(consulta);
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
                System.out.println("Crear respaldo");
                crearRespaldo();
                break;
            case "Restaurar desde respaldo":
                System.out.println("Restaurar respaldo");
                restaurarDesdeRespaldo();
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

    private void hacerLista(String consulta) {
        ResultSet resultados;
        DataBaseHelper dh = new DataBaseHelper(user, pass);

        try {
            dh.iniciarConexion();
            resultados = dh.resultSetFromQuery(consulta); //ejecuta la consulta
            JTable res = new JTable();
            DefaultTableModel modelo = new DefaultTableModel();

            JScrollPane desplazar = new JScrollPane(res);
            String[] columnas = new String[resultados.getMetaData().getColumnCount()];

            for (int i = 0; i < resultados.getMetaData().getColumnCount(); i++) {
                columnas[i] = resultados.getMetaData().getColumnName(i + 1);
            }

            modelo.setColumnIdentifiers(columnas);
            desplazar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            desplazar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            res.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            res.setFillsViewportHeight(true);

            res.setModel(modelo);
            JFrame ventana = new JFrame();
            Image image = ImageIO.read(this.getClass().getResource("/org/images/exe.png"));
            ventana.setIconImage(image);
            ventana.setSize(800, 600);
            ventana.setLocationRelativeTo(null);
            ventana.setResizable(false);
            ventana.setTitle("Contenido de la tabla");
            ventana.setVisible(true);
            ventana.getContentPane().add(desplazar, BorderLayout.NORTH);

            String fila[] = new String[resultados.getMetaData().getColumnCount()];

            while (resultados.next()) {
                for (int i = 0; i < resultados.getMetaData().getColumnCount(); i++) {
                    fila[i] = resultados.getString(i + 1);
                }

                modelo.addRow(fila);
            }
            System.out.println(res.getColumnCount());
            for (int i = 0; i < res.getColumnCount(); i++) {
                res.getColumnModel().getColumn(i).setPreferredWidth(200);

            }
            dh.cerrarConexion();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            if (ex instanceof SQLException) {
                Message.showErrorMessage("Error en la busqueda en la base de datos, "
                        + "probable error en el ID insertado, Detalles: \n" + ex);
            } else {
                System.out.println(ex);
            }
        }

    }

    /*
    * SUMAMENTE IMPORTANTE!!! para que este metodo
    * funcione es necesario que se agregue a las variables
    * del entorno del sistema operativo los comandos de mysql
    * en especial el comando mysqldump
   ¨* es sumamante importante no tener contraseña vacia
    * o el programa se colgará esperando instrucciones de entrada-salida
    * para la contraseña de usuario
    * NO OLVIDAR ESO
    *PD2: Si se llegara a eliminar la base de datos, es necesario crearla antes
    * de ingresar a éste programa
     */
    private void crearRespaldo() {

        JFileChooser elegir = new JFileChooser();
        String respaldo;

        int seleccionar = elegir.showSaveDialog(null);

        try {
            respaldo = elegir.getSelectedFile().getPath() + ".sql";
        } catch (Exception e) {
            return;
        }

        try {
            if (seleccionar == JFileChooser.APPROVE_OPTION) {
                try {
                    Process p = Runtime
                            .getRuntime()
                            .exec("mysqldump -u " + user + " -p" + pass + " sistema_motel ");

                    InputStream is = p.getInputStream();
                    FileOutputStream fos = new FileOutputStream(respaldo);
                    byte[] buffer = new byte[1000];

                    int leido = is.read(buffer);
                    while (leido > 0) {
                        fos.write(buffer, 0, leido);
                        leido = is.read(buffer);
                    }

                    fos.close();
                    Message.showInfoMessage("Respaldo creado en \n"+respaldo);
                } catch (Exception e) {
                    Message.showErrorMessage("Error al crear respaldo \n"+e);
                }
            } else {
                return;
            }

        } catch (Exception e) {
            Message.showErrorMessage("Error en la operacion \n" + e);
        }
    }
    
    
    private void restaurarDesdeRespaldo() {
        JFileChooser elegir = new JFileChooser();
        String respaldo;
        
        FileNameExtensionFilter sql = new FileNameExtensionFilter("Archivos sql", "sql");
        elegir.setFileFilter(sql);
        int seleccionar = elegir.showOpenDialog(null);
        

        try {
            respaldo = elegir.getSelectedFile().getAbsolutePath();
        } catch (Exception e) {
            return;
        }

        try {
            if (seleccionar == JFileChooser.APPROVE_OPTION) {
                try {
                    Process p = Runtime
                            .getRuntime()
                            .exec("mysql -u " + user + " -p" + pass + " sistema_motel ");
                    System.out.println("mysql -u " + user + " -p" + pass + " sistema_motel ");

                    OutputStream os = p.getOutputStream();
                    FileInputStream fis = new FileInputStream(respaldo);
                    byte[] buffer = new byte[1000];

                    int leido = fis.read(buffer);
                    while (leido > 0) {
                        os.write(buffer, 0, leido);
                        leido = fis.read(buffer);
                    }
                    os.flush();
                    os.close();
                    fis.close();
                    Message.showInfoMessage("Respaldo restaurado desde \n"+respaldo);
                } catch (Exception e) {
                    Message.showErrorMessage("Error al restaurar respaldo \n"+e);
                }
            } else {
                return;
            }

        } catch (Exception e) {
            Message.showErrorMessage("Error en la operacion \n" + e);
        }
    }

}
