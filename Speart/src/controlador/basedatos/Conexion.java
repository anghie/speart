package controlador.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {

    public static Connection CONEXION;
    private static Statement sentencia;
    static ResultSet rs;
    public static String host_bd = "";
    public static String user = "";
    public static String clave = "";

    public static Connection conectate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            CONEXION = DriverManager.getConnection("jdbc:mysql://" + host_bd + ":3306/speiess", user, clave);
        } catch (ClassNotFoundException | SQLException ex) {
//           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CONEXION;
    }
    public static int creaBaseDatos() {
        int r=-1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            CONEXION = DriverManager.getConnection("jdbc:mysql://localhost/?", user, clave);
            sentencia = CONEXION.createStatement();
            r = sentencia.executeUpdate("CREATE DATABASE IF NOT EXISTS speiess");
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
