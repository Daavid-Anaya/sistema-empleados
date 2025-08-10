package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Coordinador;
import model.connection.Conexion;

public class DaoUsuario {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
    	String cs = new String(contraseña);
        String consultQuery = "SELECT * FROM usuarios WHERE BINARY usuario = ? AND contraseña = ?";

        try (Connection connection = new Conexion().getConnection();
        	PreparedStatement statement = connection.prepareStatement(consultQuery)) {

        	statement.setString(1, usuario);
            statement.setString(2, cs);

            // Ejecutar la consulta
            try (ResultSet resultSet = statement.executeQuery()) {
            	// Si el ResultSet tiene algún resultado, significa que el usuario y la contraseña coinciden
            	return resultSet.next();
            }

        } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Error en el login: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
               return false;
        }
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}