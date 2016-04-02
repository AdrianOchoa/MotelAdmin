/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.modelos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.me.util.Message;

/**
 *
 * @author Adrián
 */
public class Backup {

    private final String dbUser;
    private final String dbPass;

    public Backup(String dbUser, String dbPass) {
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    public void crearRespaldo() {
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
                            .exec("mysqldump -u " + dbUser + " -p" + dbPass + " sistema_motel ");
                    InputStream is = p.getInputStream();
                    FileOutputStream fos = new FileOutputStream(respaldo);
                    byte[] buffer = new byte[1000];

                    int leido = is.read(buffer);
                    while (leido > 0) {
                        fos.write(buffer, 0, leido);
                        leido = is.read(buffer);
                    }
                    fos.close();
                    Message.showInfoMessage("Respaldo creado en \n" + respaldo);
                } catch (Exception e) {
                    Message.showErrorMessage("Error al crear respaldo \n" + e);
                }
            } else {
                Message.showErrorMessage("Error");
            }

        } catch (Exception e) {
            Message.showErrorMessage("Error en la operacion \n" + e);
        }
    }

    public void restaurar() {
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
                            .exec("mysql -u " + dbUser + " -p" + dbPass + " sistema_motel ");
                    System.out.println("mysql -u " + dbUser + " -p" + dbPass + " sistema_motel ");
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
                    Message.showInfoMessage("Respaldo restaurado desde \n" + respaldo);
                } catch (Exception e) {
                    Message.showErrorMessage("Error al restaurar respaldo \n" + e);
                }
            } else {
                return;
            }
        } catch (Exception e) {
            Message.showErrorMessage("Error en la operacion \n" + e);
        }
    }

}
