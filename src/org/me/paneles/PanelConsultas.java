/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.paneles;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.me.modelos.DataBaseHelper;

/**
 *
 * @author Adrián
 */
public class PanelConsultas extends JPanel {

    private final String dbUser;
    private final String dbPass;
    private final int consulta;
    private final String id;
    private ResultSet resultados;
    private DataBaseHelper dbh;
    private JScrollPane desplazar;

    /**
     *
     * @param dbUser
     * @param dbPass
     * @param consulta Un entero que expresa la consulta, 1 lista de empleados,
     * 2 lista del inventario.
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public PanelConsultas(String dbUser, String dbPass, int consulta) throws
            ClassNotFoundException, SQLException {
        this(dbUser, dbPass, consulta, "");
    }

    public PanelConsultas(String dbUser, String dbPass, int consulta,
            String id) throws ClassNotFoundException, SQLException {
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.consulta = consulta;
        this.id = id;
        init();
    }

    protected void init() throws ClassNotFoundException, SQLException {
        dbh = new DataBaseHelper(dbUser, dbPass);
        dbh.iniciarConexion();
        switch (consulta) {
            case 1:
                resultados = dbh.listaEmpleados();
                break;
            case 2:
                resultados = dbh.listaInventario();
                break;
            case 3:
                resultados = dbh.busquedaEmpleadoID(id);
                break;
            case 4:
                resultados = dbh.busquedaInventarioID(id);
                break;
            case 5:
                resultados = dbh.reabastecimiento();
                break;
            case 6:
                resultados = dbh.renta();
                break;
        }
        JTable res = new JTable();
        DefaultTableModel modelo = new DefaultTableModel();

        desplazar = new JScrollPane(res);
        String[] columnas = new String[resultados.getMetaData().getColumnCount()];

        for (int i = 0; i < resultados.getMetaData().getColumnCount(); i++) {
            columnas[i] = resultados.getMetaData().getColumnName(i + 1);
        }

        modelo.setColumnIdentifiers(columnas);
        getDesplazar().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        getDesplazar().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        res.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        res.setFillsViewportHeight(true);

        res.setModel(modelo);

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
        dbh.cerrarConexion();
    }

    /**
     * @return the desplazar
     */
    public JScrollPane getDesplazar() {
        return desplazar;
    }

}
