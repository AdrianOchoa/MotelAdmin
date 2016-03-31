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

    public DataBaseHelper() {
        this("jdbc:mysql://localhost/sistema_motel", "3306", "root", "");
    }

    public DataBaseHelper(String usuario, String pass) {
        this("jdbc:mysql://localhost/sistema_motel", "3306", usuario, pass);
    }

    public DataBaseHelper(String puerto, String usuario, String pass) {
        this("jdbc:mysql://localhost/sistema_motel", puerto, usuario, pass);
    }

    public DataBaseHelper(String servidor, String puerto, String usuario, String pass) {
        conexion = null;
        statement = null;
        this.servidor = servidor;
        this.puerto = puerto;
        this.usuario = usuario;
        this.pass = pass;
    }

    public boolean iniciarConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
        return true;
    }

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
    
    public boolean altaProducto (String nombreProducto, String marca, 
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

    public boolean executeQuery(String query) throws SQLException {
        statement = conexion.createStatement();
        statement.execute(query);
        return true;
    }

    public String executeQueryRS(String query) throws SQLException {
        String r = "";
        statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            r += rs.getString(1);
        }
        return r;
    }
    
    public ResultSet resultSetFromQuery(String query) throws SQLException{
        statement = conexion.createStatement();
        return statement.executeQuery(query);
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

}
