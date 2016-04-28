/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Adrián
 */
public class DataBaseHelper {

    private Connection conexion;
    private Statement statement;
    private String servidor;
    private String puerto;
    private String usuario;
    private String pass;

    /**
     * Constructor con datos estándar
     */
    public DataBaseHelper() {
        this("jdbc:mysql://localhost/sistema_motel", "3306", "root", "");
    }

    /**
     * Constructor con host y puertos estándar
     *
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String usuario, String pass) {
        this("jdbc:mysql://localhost/sistema_motel", "3306", usuario, pass);
    }

    /**
     * Constructor con servidor estandar
     *
     * @param puerto puerto del servidor mysql
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String puerto, String usuario, String pass) {
        this("jdbc:mysql://localhost/sistema_motel", puerto, usuario, pass);
    }

    /**
     * Constructor con datos específicos
     *
     * @param servidor Servidor de la base de datos (conexión remota)
     * @param puerto puerto del servidor mysql
     * @param usuario user de la base de datos
     * @param pass contraseña de la base de datos
     */
    public DataBaseHelper(String servidor, String puerto, String usuario, String pass) {
        conexion = null;
        statement = null;
        this.servidor = servidor;
        this.puerto = puerto;
        this.usuario = usuario;
        this.pass = pass;
    }

    /**
     *
     * @return true si la conexión se realizó correctamente, falso de otro modo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean iniciarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
        return true;
    }

    /**
     * Esta operación realiza la inserción de un empleado en la base de datos y
     * crea un usuario en esta
     *
     * @param nombreEmpleado
     * @param apellidoPE
     * @param apellidoME
     * @param celular
     * @param direccion
     * @param email
     * @param fechaIngreso
     * @param salario
     * @param horarioE
     * @param horarioS
     * @param password
     * @param turnoSemana
     * @param user
     * @param tipo
     * @return true si la operación se realizó correctamente, falso de otro modo
     * @throws SQLException
     */
    public boolean crearUsuario(String nombreEmpleado, String apellidoPE,
            String apellidoME, String celular, String direccion,
            String email, String fechaIngreso, double salario,
            String horarioE, String horarioS, String password,
            String turnoSemana, String user, String tipo) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO sistema_motel.Empleado "
                + "(nombreEmpleado, apellidoPE, apellidoME, celular, "
                + "direccion, email, fechaIngreso, salario, horarioE, horarioS, "
                + "contrasena, turnoSemana, userName, tipo) values ('")
                .append(nombreEmpleado).append("', '").append(apellidoPE)
                .append("', '").append(apellidoME).append("', '")
                .append(celular).append("', '").append(direccion)
                .append("', '").append(email).append("', '")
                .append(fechaIngreso).append("', ").append(salario)
                .append(", '").append(horarioE).append("', '")
                .append(horarioS).append("', '").append(password)
                .append("', '").append(turnoSemana)
                .append("','").append(user)
                .append("', '").append(tipo).append("');");
        executeQuery(query.toString());

        query = new StringBuilder();
        query.append("CREATE USER '").append(user)
                .append("'@'localhost' IDENTIFIED BY '")
                .append(password).append("';");
        executeQuery(query.toString());
        flush();

        //Privilegios dependiendo usuario
        //Usuario administrador, permisos de todo
        if (tipo.equals("administrador")) {
            query = new StringBuilder();
            query.append("GRANT ALL PRIVILEGES ON *.* TO '")
                    .append(user).append("'@'localhost' WITH GRANT OPTION;");
            executeQuery(query.toString());
            flush();
        }
        //Usuario empleado (ventanilla) 
        if (tipo.equals("empleado")) {
            query = new StringBuilder();
            query.append("GRANT INSERT ON sistema_motel.renta TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.renta TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.habitacion TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT INSERT ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.reabastecimiento TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.empleado TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            flush();
            query = new StringBuilder();
            query.append("GRANT UPDATE ON sistema_motel.habitacion TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            flush();
            query = new StringBuilder();
            query.append("GRANT UPDATE ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            flush();
        }
        //Usuario mucama
        if (tipo.equals("mucama")) {
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.habitacion TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT INSERT ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.reabastecimiento TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            query = new StringBuilder();
            query.append("GRANT SELECT ON sistema_motel.empleado TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            flush();
            query = new StringBuilder();
            query.append("GRANT UPDATE ON sistema_motel.producto TO '")
                    .append(user).append("'@'localhost';");
            executeQuery(query.toString());
            flush();
        }
        return true;
    }

    /**
     * Este metodo realiza la inserción de datos a la tabla de rebastecimiento
     *
     * @param usuario
     * @param productoEncontrado
     * @param productoDepositado
     * @param hora
     * @param fecha
     * @param idProducto
     * @param idHabitacion
     * @throws SQLException
     */
    public void insertReabastecimiento(String usuario,
            int productoEncontrado, int productoDepositado,
            String hora, String fecha,
            int idProducto, int idHabitacion) throws SQLException {
        int idUsuario = Integer.parseInt(getIdEmpleado(usuario));
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO sistema_motel.reabastecimiento"
                + "(productoEncontrado, productoDepositado, hora, fecha, "
                + "Producto_idProducto, Empleado_idEmpleado, "
                + "Habitacion_idHabitacion) values (")
                .append(productoEncontrado).append(", ")
                .append(productoDepositado).append(", '")
                .append(hora).append("', '").append(fecha)
                .append("', ").append(idProducto).append(", ")
                .append(idUsuario).append(", ").append(idHabitacion)
                .append(");");
        executeQuery(query.toString());
        query = new StringBuilder();
        int productoActual = getProductoActual(idProducto);
        query.append("UPDATE sistema_motel.producto SET existencias= ")
                .append(productoActual).append(" + ")
                .append(productoEncontrado).append(" - ")
                .append(productoDepositado).append(" WHERE idProducto = ")
                .append(idProducto).append(";");
        executeQuery(query.toString());
    }

    /**
     * Este metódo actualiza la habitación de 'ocupada' a 'libre'
     *
     * @param idHabitacion
     * @throws SQLException
     */
    public void liberarHabitacion(int idHabitacion) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE sistema_motel.habitacion SET "
                + "estado='libre' WHERE idHabitacion = ")
                .append(idHabitacion).append(";");
        executeQuery(query.toString());
    }
    
    /**
     * Este metódo actualiza la habitación de 'ocupada' a 'libre'
     *
     * @param idHabitacion
     * @throws SQLException
     */
    public void mandarServicioHabitacion(int idHabitacion) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE sistema_motel.habitacion SET "
                + "estado='servicio' WHERE idHabitacion = ")
                .append(idHabitacion).append(";");
        
        executeQuery(query.toString());
    }

    /**
     * Devuelve la cantidad actual de un producto de la base de datos
     *
     * @param id
     * @return
     * @throws SQLException
     */
    private int getProductoActual(int id) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("select existencias from sistema_motel.producto "
                + "where idProducto = ").append(id).append(";");
        ResultSet rs = resultSetFromQuery(sb.toString());
        sb = new StringBuilder();
        while (rs.next()) {
            sb.append(rs.getString(1));
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * Esta operación de de alta un producto en la base de datos
     *
     * @param nombreProducto
     * @param marca
     * @param existencias
     * @param precioUnitario
     * @param precioTotal
     * @param tipo
     * @return true si la operación se realizó con éxito, falso de otro modo
     * @throws SQLException
     */
    public boolean altaProducto(String nombreProducto, String marca,
            String existencias, String precioUnitario,
            String precioTotal, String tipo) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO sistema_motel.producto (nombreProducto, "
                + "marca, existencias, precioUnitario, precioTotal, tipo) "
                + "VALUES ('").append(nombreProducto).append("', '")
                .append(marca).append("', ").append(existencias)
                .append(", ").append(precioUnitario).append(", ")
                .append(precioTotal).append(", '").append(tipo).append("');");
        executeQuery(query.toString());
        return true;
    }

    /**
     * Realiza la inserción de datos a la tabla renta y actualiza la habitación
     * de 'libre' a 'ocupada'
     *
     * @param user
     * @param idHabitacion
     * @param hora
     * @param fecha
     * @return true si la operación se realizó con éxito, false de otro modo
     * @throws SQLException
     */
    public boolean rentaHabitacion(String user, int idHabitacion,
            String hora, String fecha) throws SQLException {
        int idEmpleado = Integer.parseInt(getIdEmpleado(user));
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO sistema_motel.renta(Empleado_idEmpleado, "
                + "Habitacion_idHabitacion, hora, fecha) values(")
                .append(idEmpleado).append(", ").append(idHabitacion)
                .append(", '").append(hora).append("', '").append(fecha)
                .append("');");
        executeQuery(query.toString());
        query = new StringBuilder();
        query.append("UPDATE sistema_motel.habitacion SET estado='ocupada' "
                + "WHERE idHabitacion = ").append(idHabitacion).append(";");
        executeQuery(query.toString());
        return true;
    }

    /**
     *
     * @param user
     * @return una cadena con el id del empleado de un usuario de la bd
     * @throws SQLException
     */
    public String getIdEmpleado(String user) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String query = "select idEmpleado from sistema_motel.Empleado where userName = '" + user + "';";
        ResultSet rs = resultSetFromQuery(query);
        while (rs.next()) {
            sb.append(rs.getString(1));
        }
        return sb.toString();
    }

    /**
     * Este metodo actualiza la tabla del inventario después de un
     * reabastecimiento
     *
     * @param id
     * @param marca
     * @param existencias
     * @param precioUnitario
     * @param precioTotal
     * @param tipo
     * @throws SQLException
     */
    public void modificarInventario(String id, String marca, String existencias,
            String precioUnitario, String precioTotal, String tipo) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE sistema_motel.producto SET marca='").append(marca)
                .append("', existencias=").append(existencias)
                .append(", precioUnitario=").append(precioUnitario)
                .append(", precioTotal=").append(precioTotal).append(", tipo='")
                .append(tipo).append("' WHERE idProducto = ").append(id).append(";");
        executeQuery(sb.toString());
    }

    /**
     * Este método realiza una inserción sin ResultSet en la base de datos
     *
     * @param query
     * @return true si se realiza correctamente, false de otro modo
     * @throws SQLException
     */
    public boolean executeQuery(String query) throws SQLException {
        statement = conexion.createStatement();
        statement.execute(query);
        return true;
    }

    /**
     *
     * @return un ResultSet con el contenido de la tabla del productos
     * @throws SQLException
     */
    public ResultSet listaInventario() throws SQLException {
        ResultSet rs;
        String query = "select * from Producto";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @return un ResultSet con la lista de reabastecimiento por fecha
     * @throws SQLException
     */
    public ResultSet reabastecimiento() throws SQLException {
        ResultSet rs;
        String query = "select Reabastecimiento.idReabastecimiento, Reabastecimiento.productoEncontrado,\n"
                + "Reabastecimiento.productoDepositado, Reabastecimiento.fecha, Reabastecimiento.hora, \n"
                + "Producto.nombreProducto,\n"
                + "Empleado.nombreEmpleado, Empleado.apellidoPE,\n"
                + "Empleado.apellidoME, Habitacion_idHabitacion from sistema_motel.Reabastecimiento, sistema_motel.Empleado,\n"
                + "sistema_motel.Producto where\n"
                + "Producto.idProducto = Reabastecimiento.Producto_idProducto and \n"
                + "Empleado.idEmpleado = Reabastecimiento.Empleado_idEmpleado group by Reabastecimiento.fecha;";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @param id El id del producto en el inventario que se buscará
     * @return El ResultSet con el resultado de la query
     * @throws SQLException
     */
    public ResultSet busquedaInventarioID(String id) throws SQLException {
        ResultSet rs;
        String query = "select * from sistema_motel.Producto where idProducto=" + id + ";";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @return un ResultSet con los productos contenidos en la base de datos
     * @throws SQLException
     */
    public ResultSet busquedaInventarioID() throws SQLException {
        ResultSet rs;
        String query = "select idProducto, nombreProducto from sistema_motel.Producto ;";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @return Un ResultSet con el contenido de la tabla de los empleados
     * @throws SQLException
     */
    public ResultSet listaEmpleados() throws SQLException {
        ResultSet rs;
        String query = "select idEmpleado,nombreEmpleado, "
                + "apellidoPE , apellidoME, celular,direccion,email, fechaIngreso,salario,horarioE, horarioS, turnoSemana from sistema_motel.Empleado;";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @param id El ID del empleado a buscar
     * @return un ResultSet con el resultado de la búsqueda del empleado
     * @throws SQLException
     */
    public ResultSet busquedaDatosEmpleadoID(String id) throws SQLException {
        ResultSet rs;
        String query = "select idEmpleado,nombreEmpleado, "
                + "apellidoPE , apellidoME, celular,direccion,email, fechaIngreso,salario,horarioE, "
                + "horarioS, turnoSemana from sistema_motel.Empleado "
                + "where idEmpleado = " + id + ";";
        rs = resultSetFromQuery(query);
        return rs;
    }

    public boolean habitacionesDisponibles() throws SQLException {
        String query = "select count(idHabitacion) from sistema_motel.habitacion where estado = 'libre';";
        String res = "";
        ResultSet rs = resultSetFromQuery(query);
        while (rs.next()) {
            res = rs.getString(1);
        }
        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(res);
        } catch (NumberFormatException ex) {

        }
        return cantidad > 0;
    }

    /**
     *
     *
     * @param usuario
     * @return un ResultSet con todos los empleados e id's
     * @throws SQLException
     */
    public ResultSet busquedaEmpleadoID(String usuario) throws SQLException {
        ResultSet rs;
        int id = Integer.parseInt(getIdEmpleado(usuario));
        String query = "select idEmpleado,nombreEmpleado,apellidoPE,"
                + "apellidoME, contrasena "
                + "from sistema_motel.Empleado where idEmpleado != " + id + ";";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @return un ResultSet con todos los empleadosregistrados en la base de
     * datos
     * @throws SQLException
     */
    public ResultSet busquedaEmpleados() throws SQLException {
        ResultSet rs;
        String query = "select idEmpleado, nombreEmpleado, "
                + "apellidoPE, apellidoME, contrasena "
                + "from sistema_motel.Empleado;";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     *
     * @param id
     * @throws SQLException
     */
    public void eliminarProducto(String id) throws SQLException {
        eliminarReabastecimientoProducto(id);
        String query = "delete from sistema_motel.Producto where idProducto = "
                + id + ";";
        executeQuery(query);
    }

    /**
     *
     * @param query
     * @return un ResultSet con los datos de la consulta
     * @throws SQLException
     */
    public ResultSet resultSetFromQuery(String query) throws SQLException {
        statement = conexion.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Esta operación cierra la conexión con la base de datos
     *
     * @throws SQLException
     */
    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

    /**
     *
     *
     * @param empleado
     * @param user
     * @throws SQLException
     */
    public void eliminarEmpleado(Empleado empleado, String user) throws SQLException {
        String id = empleado.getId();
        String query = "drop user '" + user + "'@'localhost';";
        executeQuery(query);
        flush();
        eliminarReabastecimientoEmpleado(id);
        eliminarRentaEmpleado(id);
        query = "delete from sistema_motel.Empleado where idEmpleado = "
                + id + ";";
        executeQuery(query);
    }

    //Importante si se quiere eliminar empleado o producto
    //ya que estas dos tablas tienen relacion con reabastecimiento
    //y renta
    public void eliminarReabastecimientoEmpleado(String id) throws SQLException {
        String query = "delete from sistema_motel.Reabastecimiento where Empleado_idEmpleado = "
                + id + ";";
        executeQuery(query);
    }

    /**
     * Es
     *
     * @param id
     * @throws SQLException
     */
    public void eliminarReabastecimientoProducto(String id) throws SQLException {
        String query = "delete from sistema_motel.Reabastecimiento where Producto_idProducto = "
                + id + ";";
        executeQuery(query);
    }

    /**
     * Este metodo elimina registros de la tabla renta para un empleado que haya
     * sido dado de baja del sistema
     *
     * @param id
     * @throws SQLException
     */
    public void eliminarRentaEmpleado(String id) throws SQLException {
        String query = "delete from sistema_motel.Renta where Empleado_idEmpleado = "
                + id + ";";
        executeQuery(query);
    }

    /**
     *
     * @return un ResultSet con la tabla de renta
     * @throws SQLException
     */
    public ResultSet renta() throws SQLException {
        ResultSet rs;
        String query = "select Renta.idRenta, Renta.Habitacion_idHabitacion, Empleado.nombreEmpleado, Empleado.apellidoPE,\n"
                + "Empleado.apellidoME, Renta.hora, Renta.fecha from sistema_motel.Renta, sistema_motel.Empleado\n"
                + "where Empleado.idEmpleado = Renta.Empleado_idEmpleado;";
        rs = resultSetFromQuery(query);
        return rs;
    }

    /**
     *
     * @return un arreglo de cadenas con el id y el nombre de los productos que
     * existen en la base de datos
     * @throws SQLException
     */
    public String[] getProductos() throws SQLException {
        String[] productos;
        String query = "select idProducto, nombreProducto from sistema_motel.Producto;";
        ResultSet rs = resultSetFromQuery(query);
        ArrayList<Object> array = new ArrayList();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            sb.append(rs.getString(1))
                    .append(", Nombre: ").append(rs.getString(2));
            array.add(sb.toString());
        }
        productos = new String[array.size()];
        for (int i = 0; i < productos.length; i++) {
            productos[i] = array.get(i).toString();
        }
        return productos;
    }

    /**
     *
     * @return regresa un arreglo de cadenas con las habitaciones disponibles
     * @throws SQLException
     */
    public String[] getHabitacionesDisponibles() throws SQLException {
        String[] habs;
        String query = "select idHabitacion, tipo, precio from sistema_motel.Habitacion where estado = 'libre';";
        ResultSet rs = resultSetFromQuery(query);
        ArrayList<Object> array = new ArrayList();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            sb.append(rs.getString(1)).append(", Tipo: ")
                    .append(rs.getString(2)).append(", Precio: ")
                    .append(rs.getString(3));
            array.add(sb.toString());
        }
        habs = new String[array.size()];
        for (int i = 0; i < habs.length; i++) {
            habs[i] = array.get(i).toString();
        }
        return habs;
    }

    /**
     *
     * @return un arreglo de cadenas con las habitaciones no disponibles
     * @throws SQLException
     */
    public String[] getHabitacionesOcupadas() throws SQLException {
        String[] habs;
        String query = "select idHabitacion, tipo, precio from sistema_motel.Habitacion where estado = 'ocupada';";
        ResultSet rs = resultSetFromQuery(query);
        ArrayList<Object> array = new ArrayList();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            sb.append(rs.getString(1)).append(", Tipo: ")
                    .append(rs.getString(2)).append(", Precio: ")
                    .append(rs.getString(3));
            array.add(sb.toString());
        }
        habs = new String[array.size()];
        for (int i = 0; i < habs.length; i++) {
            habs[i] = array.get(i).toString();
        }
        return habs;
    }
    
    /**
     *
     * @return un arreglo de cadenas con las habitaciones no disponibles
     * @throws SQLException
     */
    public String[] getHabitacionesEnServicio() throws SQLException {
        String[] habs;
        String query = "select idHabitacion, tipo, precio from sistema_motel.Habitacion where estado = 'servicio';";
        ResultSet rs = resultSetFromQuery(query);
        ArrayList<Object> array = new ArrayList();
        while (rs.next()) {
            StringBuilder sb = new StringBuilder();
            sb.append(rs.getString(1)).append(", Tipo: ")
                    .append(rs.getString(2)).append(", Precio: ")
                    .append(rs.getString(3));
            array.add(sb.toString());
        }
        habs = new String[array.size()];
        for (int i = 0; i < habs.length; i++) {
            habs[i] = array.get(i).toString();
        }
        return habs;
    }

    /**
     * Este metodo realiza un flush a la base de datos, se debe invocar al crear
     * o eliminar un usuario de la base de datos, o al conceder/quitar
     * privilegios
     *
     * @throws SQLException
     */
    private void flush() throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("FLUSH PRIVILEGES;");
        executeQuery(sb.toString());
    }

}
