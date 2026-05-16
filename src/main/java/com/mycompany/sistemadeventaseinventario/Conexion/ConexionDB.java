package com.mycompany.sistemadeventaseinventario.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Frank
 */
public class ConexionDB {

    /*
    //Conexion CloudSQL
    protected Connection conectar = null;

    String ipPublica = "35.239.202.69";
    String nombreDB = "DbSistemaDeVentas";
    String usuarioDB = "sqlserver"; 
    String passDB = "admin123";

    String connectionUrl = "jdbc:sqlserver://" + ipPublica + ":1433"
            + ";databaseName=" + nombreDB
            + ";encrypt=true;trustServerCertificate=true;";

    public Connection establecerConexionDB() {

        try {

            this.conectar = DriverManager.getConnection(connectionUrl, usuarioDB, passDB);
            System.out.println("¡Conexión exitosa a la base de datos en la nube!");
        } catch (SQLException e) {

            System.out.println("Fallo la conexion con la base de datos" + e.toString());
        }

        return conectar;

    }

    public void cerrarConexionDB() throws SQLException {

        if (conectar != null) {
            if (!conectar.isClosed()) {
                conectar.close();
            }
        }

    }*/
    //Conexion Local
    protected Connection conectar = null;
    String user = "fvelasquezl";
    String pasword = "admin123";
    String ip = "localhost";
    String puerto = "1433";
    String database = "DbSistemaDeVentas";
    String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + database
            + ";encrypt=true;trustServerCertificate=true;";

    public Connection establecerConexionDB() {

        try {

            conectar = DriverManager.getConnection(url, user, pasword);
            System.out.println("Conexion con la base de datos establecida");

        } catch (SQLException e) {

            System.out.println("Fallo la conexion con la base de datos" + e.toString());
        }

        return conectar;

    }

    public void cerrarConexionDB() throws SQLException {

        if (conectar != null) {
            if (!conectar.isClosed()) {
                conectar.close();
            }
        }

    }
}
