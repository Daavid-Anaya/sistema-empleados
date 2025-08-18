package model.dao;

import java.util.List;

import controller.Coordinador;
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
        return false;
    }

    public boolean actualizarEmpleado(VoEmpleado emp) {

        return false;
    }

    public boolean eliminarEmpleado(int idEmpleado) {

        return false;
    }

    public List<VoEmpleado> listarEmpleados() {
        
        return null;
    }
}