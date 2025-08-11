package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Coordinador;
import model.connection.Conexion;
import model.vo.VoCargo;

public class DaoCargo {
	@SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    public boolean insertar(VoCargo c) {
    	// Consulta SQL para insertar los datos en la tabla Pacientes
        String insertQuery = "INSERT INTO cargos (nombre_cargo) VALUES (?)";
    	
        // Usar try-with-resources para asegurarse de que los recursos se cierren automáticamente
        try (Connection connection = new Conexion().getConnection();
            	PreparedStatement statement = connection.prepareStatement(insertQuery)) {   
        	// Asignamos los valores a los parámetros
        	statement.setString(1, c.getNombre());
        	
        	// Ejecutamos la consulta
            int rowsInserted = statement.executeUpdate();

            // Verificamos si la inserción fue exitosa
            if (rowsInserted > 0) {
               return true;
            } else {
            	return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}