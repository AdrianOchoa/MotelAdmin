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
     * @return true si la operación se realizó correctamente, falso de otro modo
     * @throws SQLException
     */
    public boolean crearUsuario(String nombreEmpleado, String apellidoPE,
            String apellidoME, String celular, String direccion,
            String email, String fechaIngreso, double salario,
            String horarioE, String horarioS, String password,
            String turnoSemana, String user) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO sistema_motel.empleado "
                + "(nombreEmpleado, apellidoPE, apellidoME, celular, "
                + "direccion, email, fechaIngreso, salario, horarioE, horarioS, "
                + "contrasena, turnoSemana) values ('")
                .append(nombreEmpleado).append("', '").append(apellidoPE)
                .append("', '").append(apellidoME).append("', '")
                .append(celular).append("', '").append(direccion)
                .append("', '").append(email).append("', '")
                .append(fechaIngreso).append("', ").append(salario)
                .append(", '").append(horarioE).append("', '")
                .append(horarioS).append("', '").append(password)
                .append("', '").append(turnoSemana).append("');");
        executeQuery(query.toString());

        query = new StringBuilder();
        query.append("CREATE USER '").append(user)
                .append("'@'localhost' IDENTIFIED BY '")
                .append(password).append("';");
        executeQuery(query.toString());

        query = new StringBuilder();
        query.append("FLUSH PRIVILEGES;");
        executeQuery(query.toString());

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
        query.append("GRANT SELECT ON sistema_motel.reabastecimiento TO '")
                .append(user).append("'@'localhost';");
        executeQuery(query.toString());
        query = new StringBuilder();
        query.append("FLUSH PRIVILEGES;");
        executeQuery(query.toString());
        return true;
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
     * Esta operación realiza una query en la base de datos
     *
     * @param query
     * @return un ResultSet con el resultado de la query
     * @throws SQLException
     */
    public String executeQueryRS(String query) throws SQLException {
        String r = "";
        statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            r += rs.getString(1);
        }
        return r;
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
        String query = "select * from sistema_motel.Reabastecimiento"
                + " group by fecha";
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
     * @return El ResultSet con los productos del inventario
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
    public ResultSet busquedaEmpleadoID(String id) throws SQLException {
        ResultSet rs;
        String query = "select idEmpleado,nombreEmpleado, "
                + "apellidoPE , apellidoME, celular,direccion,email, fechaIngreso,salario,horarioE, "
                + "horarioS, turnoSemana from sistema_motel.Empleado "
                + "where idEmpleado = " + id + ";";
        rs = resultSetFromQuery(query);
        return rs;
    }
    
    /**
     *
     * 
     * @return un ResultSet con todos los empleados e id's
     * @throws SQLException
     */
    public ResultSet busquedaEmpleadoID() throws SQLException {
        ResultSet rs;
        String query = "select idEmpleado,nombreEmpleado,apellidoPE,"
                + "apellidoME, contrasena "
                + "from sistema_motel.Empleado "
                ;
        System.out.println(query);
        rs = resultSetFromQuery(query);
        return rs;
    }
    
    
    /**
     *
     * 
     * @param recibe el id del producto a eliminar
     * @throws SQLException
     */
    public void eliminarProducto(String id) throws SQLException{
        eliminarReabastecimientoProducto(id);
        String query = "delete from sistema_motel.Producto where idProducto = "+
                id+";";
        statement = conexion.createStatement();
        statement.execute(query);
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
     * @param recibe el id del empleado a eliminar
     * @throws SQLException
     */
    public void eliminarEmpleado(Empleado empleado) throws SQLException{
        
        String user = empleado.getNombre()+empleado.getApellidoPaterno()+
                empleado.getApellidoMaterno();
        
        System.out.println(user);
        
        String query = "drop user '"+user+"'@localhost";
        executeQuery(query);
        
        eliminarReabastecimientoEmpleado(empleado.getId());
        eliminarRentaEmpleado(empleado.getId());
        
        
        if(user.length() > 15){
            user = (empleado.getNombre()+empleado.getApellidoPaterno()+
                    empleado.getApellidoMaterno()).substring(0, 15);
        }
        
        query = "delete from sistema_motel.Empleado where idEmpleado = "+
                empleado.getId()+";";
        statement = conexion.createStatement();
        statement.execute(query);
    }
    
    //Importante si se quiere eliminar empleado o producto
    //ya que estas dos tablas tienen relacion con reabastecimiento
    //y renta
    public void eliminarReabastecimientoEmpleado(String id) throws SQLException{
        String query = "delete from sistema_motel.Reabastecimiento where Empleado_idEmpleado = "+
                id+";";
        statement = conexion.createStatement();
        statement.execute(query);
    }
    
    public void eliminarReabastecimientoProducto(String id) throws SQLException{
        String query = "delete from sistema_motel.Reabastecimiento where Producto_idProducto = "+
                id+";";
        statement = conexion.createStatement();
        statement.execute(query);
    }
    
    public void eliminarRentaEmpleado(String id) throws SQLException{
        String query = "delete from sistema_motel.Renta where Empleado_idEmpleado = "+
                id+";";
        statement = conexion.createStatement();
        statement.execute(query);
    }
    
    /**
     *
     * @return un ResultSet con la tabla de renta
     * @throws SQLException
     */
    public ResultSet renta() throws SQLException{
         ResultSet rs;
        String query = "select * from sistema_motel.Renta"
                + " group by fecha";
        rs = resultSetFromQuery(query);
        return rs;
    }
    
   

}
