/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.me.modelos.DataBaseHelper;
import org.me.modelos.Empleado;
import org.me.modelos.Producto;

/**
 *
 * @author JR
 */
public class Utils {

    /**
     *
     * @param arrayL
     * @return un arreglo de objetos
     */
    public static Object[] ArrayListToArray(ArrayList arrayL) {
        Object[] returnA = new Object[arrayL.size()];
        for (int i = 0; i < arrayL.size(); i++) {
            returnA[i] = arrayL.get(i);
        }
        return returnA;
    }

    /**
     *
     * @param usuario de la base de datos
     * @param password de dicho usuario
     * @return un arreglo de objetos Producto con los productos de las base de
     * datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Object[] elementosInventario(String usuario, String password)
            throws SQLException, ClassNotFoundException {
        ArrayList productos = new ArrayList();
        ResultSet resultados;
        DataBaseHelper dh = new DataBaseHelper(usuario, password);
        dh.iniciarConexion();
        resultados = dh.busquedaInventarioID();
        ArrayList fila = new ArrayList();
        int count1 = 0, count2 = 1;
        while (resultados.next()) {
            for (int i = 0; i < resultados.getMetaData().getColumnCount(); i++) {
                fila.add(resultados.getString(i + 1));
            }
            productos.add(new Producto(fila.get(count1).toString(), fila.get(count2).toString()));
            count1 += 2;
            count2 += 2;
        }
        dh.cerrarConexion();
        return ArrayListToArray(productos);
    }

    /**
     *
     * @param usuario
     * @param password
     * @param tipo Si tipo es true, buscará todos los empleados. Si es false,
     * buscará todos excepto en usuario con sesión iniciada (para eliminación de empleados)
     * @return Un arreglo de objetos Empleado con los empleados de la base de
     * datos
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Object[] elementosEmpleados(String usuario, String password, boolean tipo)
            throws SQLException, ClassNotFoundException {
        ArrayList productos = new ArrayList();
        ResultSet resultados;
        DataBaseHelper dh = new DataBaseHelper(usuario, password);
        dh.iniciarConexion();
        if (tipo) {
            resultados = dh.busquedaEmpleados();
        } else {
            resultados = dh.busquedaEmpleadoID(usuario);
        }
        ArrayList fila = new ArrayList();
        int count1 = 0, count2 = 1, count3 = 2, count4 = 3, count5 = 4;
        while (resultados.next()) {
            for (int i = 0; i < resultados.getMetaData().getColumnCount(); i++) {
                fila.add(resultados.getString(i + 1));
            }
            productos.add(new Empleado(fila.get(count1).toString(), fila.get(count2).toString(),
                    fila.get(count3).toString(), fila.get(count4).toString(), fila.get(count5).toString()));
            count1 += 5;
            count2 += 5;
            count3 += 5;
            count4 += 5;
            count5 += 5;
        }
        dh.cerrarConexion();
        return ArrayListToArray(productos);
    }

}
