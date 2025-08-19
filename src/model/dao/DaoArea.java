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
import model.vo.VoArea;

public class DaoArea {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    // Método para verificar si existe un área por su nombre
    public boolean existeNombreArea(String nombre) {
        // Consulta SQL para verificar si existe un área por su nombre
        String sql = "SELECT COUNT(*) FROM areas WHERE nombre_area = ?";

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

    // Método para verificar si existe un área por su id
    public boolean existeIdArea(int id) {
        // Consulta SQL para verificar si existe un área por su ID
        String sql = "SELECT COUNT(*) FROM areas WHERE id_area = ?";

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

    // Método para buscar un área por su ID
    public VoArea buscarArea(String id) {
        // Consulta SQL para buscar el área por su ID
        String query = "SELECT * FROM areas WHERE id_area = ?";

        // Preparar la conexión y la consulta
        try(Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, Integer.parseInt(id));
            
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar el resultado
            if (resultSet.next()) {
                VoArea area = new VoArea();
                area.setId(resultSet.getInt("id_area"));
                area.setNombre(resultSet.getString("nombre_area"));
                return area;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Método para insertar un área
    public boolean insertarArea(String nombre) {
        // Consulta SQL para insertar el área
        String insertQuery = "INSERT INTO areas (nombre_area) VALUES (?)";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, nombre);

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            // Verificar si se insertó el área
            return rowsInserted > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para actualizar un área
    public boolean actualizarArea(VoArea a) {
        // Consulta SQL para actualizar el área
        String updateQuery = "UPDATE areas SET nombre_area = ? WHERE id_area = ?";

        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // Establecer los valores de los parámetros en la consulta
            statement.setString(1, a.getNombre());
            statement.setInt(2, a.getId());

            // Ejecutar la consulta
            int rowsUpdated = statement.executeUpdate();

            // Verificar si se actualizó el área
            return rowsUpdated > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para eliminar un área
    public boolean eliminarArea(int id) {
        // Consulta SQL para eliminar el área
        String deleteQuery = "DELETE FROM areas WHERE id_area = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);

            // Ejecutar la consulta
            int rowsDeleted = statement.executeUpdate();

            // Verificar si se eliminó el área
            return rowsDeleted > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar área: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para cargar la lista de áreas
	public List<VoArea> cargaListaAreas() {
        // Consulta SQL para obtener todas las áreas
        String selectQuery = "SELECT * FROM areas";
        
        List<VoArea> listaAreas = new ArrayList<>();

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Procesar el resultado
            while (resultSet.next()) {
                VoArea area = new VoArea();
                area.setId(resultSet.getInt("id_area"));
                area.setNombre(resultSet.getString("nombre_area"));
                listaAreas.add(area);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar áreas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaAreas;
	}
}