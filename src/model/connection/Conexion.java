package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
    // Conexión a MySQL
    private String url = "jdbc:mysql://localhost:3306/empleados_db";
    private String usuario = "root";
    private String contrasena = "";
    private Connection conexion = null;

    // Constructor
    public Conexion() {
    	try {
            // Establecemos la conexión
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection()  {
        return conexion;
    }

    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos: " + e.getMessage(), "Error de desconexión", JOptionPane.ERROR_MESSAGE);
        }
    }
}