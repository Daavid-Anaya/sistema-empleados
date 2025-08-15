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

    // Método para buscar un área por su ID
    public VoArea buscarArea(VoArea a) {
        // Consulta SQL para buscar el área por su ID
        String query = "SELECT * FROM areas WHERE id_area = ?";

        // Preparar la conexión y la consulta
        try(Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, a.getId());
            
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
    public boolean insertarArea(VoArea a) {
        // Consulta SQL para insertar el área
        String insertQuery = "INSERT INTO areas (nombre_area) VALUES (?)";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, a.getNombre());

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
    public boolean eliminarArea(VoArea a) {
        // Consulta SQL para eliminar el área
        String deleteQuery = "DELETE FROM areas WHERE id_area = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, a.getId());

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
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery()) {

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
