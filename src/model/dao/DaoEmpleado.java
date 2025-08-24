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
import model.vo.VoEmpleado;

public class DaoEmpleado {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    // Método para verificar si existe un empleado por su id
    public boolean existeIdEmpleado(int id) {
        // Consulta SQL para verificar si existe un empleado por su ID
        String sql = "SELECT COUNT(*) FROM empleados WHERE id_empleado = ?";

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
            JOptionPane.showMessageDialog(null, "Error al verificar ID de empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    // Método para buscar un Empleado por su ID
    public VoEmpleado buscarEmpleado(int id) {
        // Consulta SQL para buscar un empleado por su ID
        String query = "SELECT * FROM empleados WHERE id_empleado = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setInt(1, id);

            // Ejecutar la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                // Procesar el resultado
                if (resultSet.next()) {
                    // Crear un objeto VoEmpleado con los datos del ResultSet
                    VoEmpleado empleado = new VoEmpleado();
                    empleado.setIdEmpleado(resultSet.getInt("id_empleado"));
                    empleado.setNombre(resultSet.getString("nombre"));
                    empleado.setApellido(resultSet.getString("apellido"));
                    empleado.setTipoDoc(resultSet.getString("tipo_documento"));
                    empleado.setDocumento(resultSet.getString("documento"));
                    empleado.setIdArea(resultSet.getInt("id_area"));
                    empleado.setIdCargo(resultSet.getInt("id_cargo"));
                    empleado.setTelefono(resultSet.getString("telefono"));
                    empleado.setCorreo(resultSet.getString("correo"));
                    return empleado;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

     // Método para actualizar un empleado
    public boolean actualizarEmpleado(VoEmpleado emp) {
        // Consulta SQL para actualizar el empleado
        String updateQuery = "UPDATE empleados SET nombre = ?, apellido = ?, tipo_documento = ?, " +
        "documento = ?, id_area = ?, id_cargo = ?, telefono = ?, correo = ? WHERE id_empleado = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
        PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // Establecer los valores de los parámetros en la consulta
            statement.setString(1, emp.getNombre());
            statement.setString(2, emp.getApellido());
            statement.setString(3, emp.getTipoDoc());
            statement.setString(4, emp.getDocumento());
            statement.setInt(5, emp.getIdArea());
            statement.setInt(6, emp.getIdCargo());
            statement.setString(7, emp.getTelefono());
            statement.setString(8, emp.getCorreo());
            statement.setInt(9, emp.getIdEmpleado());

            // Ejecutar la consulta
            int rowsUpdated = statement.executeUpdate();

            // Verificar si se actualizó el área
            return rowsUpdated > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para eliminar un empleado
    public boolean eliminarEmpleado(int id) {
         // Consulta SQL para eliminar el empleado
        String deleteQuery = "DELETE FROM empleados WHERE id_empleado = ?";

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
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para cargar lista de empleados
    public List<VoEmpleado> cargaListEmpleados() {
        List<VoEmpleado> empleados = new ArrayList<>();

        // Consulta SQL para listar empleados
        String selectQuery = "SELECT e.id_empleado, e.nombre, e.apellido, e.tipo_documento, e.documento,\n" + //
                        "e.id_area, a.nombre_area, e.id_cargo, c.nombre_cargo, e.telefono, e.correo\n" + //
                        "FROM empleados e\n" + //
                        "INNER JOIN areas a\n" + //
                        "ON e.id_area = a.id_area\n" + //
                        "INNER JOIN cargos c\n" + //
                        "ON e.id_cargo = c.id_cargo;";

        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery()) {

            // Procesar el resultado
            while (resultSet.next()) {
                VoEmpleado emp = new VoEmpleado();
                emp.setIdEmpleado(resultSet.getInt("id_empleado"));
                emp.setNombre(resultSet.getString("nombre"));
                emp.setApellido(resultSet.getString("apellido"));
                emp.setTipoDoc(resultSet.getString("tipo_documento"));
                emp.setDocumento(resultSet.getString("documento"));
                emp.setIdArea(resultSet.getInt("id_area"));
                emp.setNombreArea(resultSet.getString("nombre_area"));
                emp.setIdCargo(resultSet.getInt("id_cargo"));
                emp.setNombreCargo(resultSet.getString("nombre_cargo"));
                emp.setTelefono(resultSet.getString("telefono"));
                emp.setCorreo(resultSet.getString("correo"));
                empleados.add(emp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return empleados;
    }

    // Método para buscar un Empleado por su Documento
    public VoEmpleado buscarEmpleadoDoc(String documento) {
        // Consulta SQL para buscar un empleado por su Documento
        String query = "SELECT * FROM empleados WHERE documento = ?";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            // Establecer el valor del parámetro en la consulta
            statement.setString(1, documento);

            // Ejecutar la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
                // Procesar el resultado
                if (resultSet.next()) {
                    // Crear un objeto VoEmpleado con los datos del ResultSet
                    VoEmpleado empleado = new VoEmpleado();
                    empleado.setIdEmpleado(resultSet.getInt("id_empleado"));
                    empleado.setNombre(resultSet.getString("nombre"));
                    empleado.setApellido(resultSet.getString("apellido"));
                    empleado.setTipoDoc(resultSet.getString("tipo_documento"));
                    empleado.setDocumento(resultSet.getString("documento"));
                    empleado.setIdArea(resultSet.getInt("id_area"));
                    empleado.setIdCargo(resultSet.getInt("id_cargo"));
                    empleado.setTelefono(resultSet.getString("telefono"));
                    empleado.setCorreo(resultSet.getString("correo"));
                    return empleado;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}