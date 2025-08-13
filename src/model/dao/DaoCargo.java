package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean insertarCargo(VoCargo c) {
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

    public List<VoCargo> cargaListaCargos() {
        List<VoCargo> listaCargos = new ArrayList<>();
        String query = "SELECT * FROM cargos";

        try (Connection connection = new Conexion().getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                VoCargo cargo = new VoCargo();
                cargo.setId(resultSet.getInt("id_cargo"));
                cargo.setNombre(resultSet.getString("nombre_cargo"));
                listaCargos.add(cargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar lista de cargos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaCargos;
    }

    public boolean actualizarCargo(VoCargo c) {
    	String UpdateQuery = "UPDATE cargos SET nombre_cargo = ? WHERE id_cargo = ? ";
    	
    	try (Connection connection = new Conexion().getConnection();
    	PreparedStatement statement = connection.prepareStatement(UpdateQuery)) {
    		// Asignamos los valores a los parámetros
            statement.setString(1, c.getNombre());
            statement.setInt(2, c.getId());

            // Ejecutamos la actualización
            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
    	} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    }

    public boolean eliminarCargo(VoCargo c) {
        String deleteQuery = "DELETE FROM cargos WHERE id_cargo = ?";

        try (Connection connection = new Conexion().getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            // Asignamos el valor del ID del cargo a eliminar
            statement.setInt(1, c.getId());

            // Ejecutamos la eliminación
            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}