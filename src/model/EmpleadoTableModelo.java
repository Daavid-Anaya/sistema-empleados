package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.vo.VoEmpleado;

public class EmpleadoTableModelo extends AbstractTableModel{

   private static final long serialVersionUID = 1L;
    private List<VoEmpleado> empleados;
    private final String[] columnas = {"ID", "Nombre", "Apellido", "Tipo Doc", "Documento", "ID Area", "ID Cargo", "Telefono", "Correo"};

    public EmpleadoTableModelo(List<VoEmpleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VoEmpleado empleado = empleados.get(rowIndex);
        switch (columnIndex) {
            case 0: return empleado.getIdEmpleado();
            case 1: return empleado.getNombre();
            case 2: return empleado.getApellido();
            case 3: return empleado.getTipoDoc();
            case 4: return empleado.getDocumento();
            case 5: return empleado.getIdArea();
            case 6: return empleado.getIdCargo();
            case 7: return empleado.getTelefono();
            case 8: return empleado.getCorreo();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public void setEmpleados(List<VoEmpleado> nuevosEmpleados) {
        this.empleados = nuevosEmpleados;
        fireTableDataChanged(); // 🔄 Actualiza la vista
    }  
}