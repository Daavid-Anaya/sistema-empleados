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

    // Método para verificar si existe un cargo por su nombre
    public boolean existeNombreCargo(String nombre) {
        // Consulta SQL para verificar si existe un cargo por su nombre
        String sql = "SELECT COUNT(*) FROM cargos WHERE nombre_cargo = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, nombre);

            // Ejecutar la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                // Procesar el resultado
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // Si hay al menos una coincidencia
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar nombre de área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    // Método para verificar si existe un cargo por su id
    public boolean existeIdCargo(int id) {
        // Consulta SQL para verificar si existe un cargo por su ID
        String sql = "SELECT COUNT(*) FROM cargos WHERE id_cargo = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);

            // Ejecutar la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                // Procesar el resultado
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // Si hay al menos una coincidencia
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar ID de área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    // Método para buscar un cargo por su ID
    public VoCargo buscarCargo(String id) {
        // Consulta SQL para buscar el cargo por su ID
        String query = "SELECT * FROM cargos WHERE id_cargo = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, Integer.parseInt(id));
            
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar el resultado
            if (resultSet.next()) {
                VoCargo cargo = new VoCargo();
                cargo.setId(resultSet.getInt("id_cargo"));
                cargo.setNombre(resultSet.getString("nombre_cargo"));
                cargo.setRemuneracion(resultSet.getDouble("remuneracion"));
                return cargo;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    // Método para insertar un cargo
    public boolean insertarCargo(String nombre, double remuneracion) {
        // Consulta SQL para insertar el cargo
        String insertQuery = "INSERT INTO cargos (nombre_cargo, remuneracion) VALUES (?, ?)";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, nombre);
            statement.setDouble(2, remuneracion);
        	
        	// Ejecutamos la consulta
            int rowsInserted = statement.executeUpdate();

            // Verificamos si la inserción fue exitosa
            return rowsInserted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para actualizar un cargo
    public boolean actualizarCargo(VoCargo c) {
        // Consulta SQL para actualizar cargo
    	String UpdateQuery = "UPDATE cargos SET nombre_cargo = ?, remuneracion = ? WHERE id_cargo = ? ";
    	
        // Preparar la conexión y la consulta
    	try (Connection connection = new Conexion().getConnection();
    	PreparedStatement statement = connection.prepareStatement(UpdateQuery)) {
    		// Establecer los valores de los parámetros en la consulta
            statement.setString(1, c.getNombre());
            statement.setDouble(2, c.getRemuneracion());
            statement.setInt(3, c.getId());

            // Ejecutar la consulta
            int rowsUpdated = statement.executeUpdate();

            // Verificar si se actualizó el cargo
            return rowsUpdated > 0;
    	} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    		return false;
    	}
    }

    // Método para eliminar un cargo
    public boolean eliminarCargo(int id) {
        // Consulta SQL para eliminar el cargo
        String deleteQuery = "DELETE FROM cargos WHERE id_cargo = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);

            // Ejecutar la consulta
            int rowsDeleted = statement.executeUpdate();

            // Verificar si se eliminó el cargo
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cargo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para cargar la lista de cargos
    public List<VoCargo> cargaListaCargos() {
        List<VoCargo> listaCargos = new ArrayList<>();

        // Consulta SQL para obtener todas los cargos
        String query = "SELECT * FROM cargos";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
        PreparedStatement statement = connection.prepareStatement(query)) {
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar el resultado
            while (resultSet.next()) {
                VoCargo cargo = new VoCargo();
                cargo.setId(resultSet.getInt("id_cargo"));
                cargo.setNombre(resultSet.getString("nombre_cargo"));
                cargo.setRemuneracion(resultSet.getDouble("remuneracion"));
                listaCargos.add(cargo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar lista de cargos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaCargos;
    }
}