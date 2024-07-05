package cl.praxis.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexion {
    private static Connection conn = null;

    private BDConexion() { }

    private static synchronized void initConnection() {
        try {
            System.out.println("Cargando el driver de PostgreSQL.");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado exitosamente.");

            System.out.println("Estableciendo conexión con la base de datos.");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/desafio_proveedores?characterEncoding=UTF-8", "carmen", "Fechita1");
                System.out.println("Conexión establecida exitosamente.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la base de datos.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        initConnection();
        return conn;
    }
}
