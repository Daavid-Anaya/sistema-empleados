package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Coordinador;
import model.connection.Conexion;
import model.vo.VoEmpleado;

public class DaoEmpleado {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    // Método para buscar un Empleado por su ID
    public VoEmpleado buscarEmpleado(VoEmpleado emp) {
        return null;
    }

    // Método para insertar un Empleado
    public boolean insertarEmpleado(VoEmpleado emp) {
        // Consulta SQL para insertar un empleado
        String insertQuery = "INSERT INTO empleados (nombre, apellido, tipo_documento, documento, id_area, id_cargo, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, emp.getNombre());
            statement.setString(2, emp.getApellido());
            statement.setString(3, emp.getTipoDoc());
            statement.setString(4, emp.getDocumento());
            statement.setInt(5, emp.getIdArea());
            statement.setInt(6, emp.getIdCargo());
            statement.setString(7, emp.getTelefono());
            statement.setString(8, emp.getCorreo());

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            // Verificar si se insertó el empleado
            return rowsInserted > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean actualizarEmpleado(VoEmpleado emp) {

        return false;
    }

    public boolean eliminarEmpleado(VoEmpleado emp) {

        return false;
    }

    public List<VoEmpleado> listarEmpleados() {
        
        return null;
    }
}