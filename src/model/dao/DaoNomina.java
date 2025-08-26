package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Coordinador;
import model.connection.Conexion;
import model.vo.VoNomina;

public class DaoNomina {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    // Método para insertar una nómina
    public boolean insertarNomina(VoNomina nomina) {
        // Consulta SQL para insertar la nómina
        String insertQuery = "INSERT INTO nominas (fecha, dias_laborados, total, id_empleado, id_cargo) VALUES (?, ?, ?, ?, ?)";

        // Preparar la conexión y la consulta
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            // Establecer el valor del parámetro en la consulta
            statement.setDate(1, nomina.getFecha());
            statement.setInt(2, nomina.getDiasLaborados());
            statement.setDouble(3, nomina.getTotal());
            statement.setInt(4, nomina.getIdEmpleado());
            statement.setInt(5, nomina.getIdCargo());

            // Ejecutar la consulta
            int rowsInserted = statement.executeUpdate();

            // Verificar si se insertó el área
            return rowsInserted > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar nomina: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para cargar lista de Nominas
    public List<VoNomina> cargaListaNominas() {
        List<VoNomina> nominas = new ArrayList<>();

        // Consulta SQL para listar empleados
        String selectQuery = "SELECT n.id, n.fecha, n.id_empleado, e.nombre, e.documento,\n" +
                            "n.id_cargo, c.nombre_cargo, c.remuneracion, n.dias_laborados, n.total\n" +
                            "FROM nominas n\n" +
                            "INNER JOIN empleados e ON n.id_empleado = e.id_empleado\n"+
                            "INNER JOIN cargos c ON e.id_cargo = c.id_cargo";
        try (Connection connection = new Conexion().getConnection();
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery()) {

            // Procesar el resultado
            while (resultSet.next()) {
                VoNomina nom = new VoNomina();
                nom.setId(resultSet.getInt("id"));
                nom.setFecha(resultSet.getDate("fecha"));
                nom.setIdEmpleado(resultSet.getInt("id_empleado"));
                nom.setNombreEmpleado(resultSet.getString("nombre"));
                nom.setDocumentoEmpleado(resultSet.getString("documento"));
                nom.setIdCargo(resultSet.getInt("id_cargo"));
                nom.setNombreCargo(resultSet.getString("nombre_cargo"));
                nom.setRemuneracion(resultSet.getDouble("remuneracion"));
                nom.setDiasLaborados(resultSet.getInt("dias_laborados"));
                nom.setTotal(resultSet.getDouble("total"));
                nominas.add(nom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar nominas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nominas;
    }
}