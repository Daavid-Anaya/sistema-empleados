package model.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.vo.VoNomina;

public class NominaTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private List<VoNomina> nominas;
    private final String[] columnas = {"ID Nomina", "Fecha", "ID Emp", "Nombre", "Documento", "ID Cargo", "Nombre Cargo", "Remuneración", "Días", "Total"};

    public NominaTableModel(List<VoNomina> nominas) {
        this.nominas = nominas;
    }

    @Override
    public int getRowCount() {
        return nominas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VoNomina nomina = nominas.get(rowIndex);
        switch (columnIndex) {
            case 0: return nomina.getId();
            case 1: return nomina.getFecha();
            case 2: return nomina.getIdEmpleado();
            case 3: return nomina.getNombreEmpleado();
            case 4: return nomina.getDocumentoEmpleado();
            case 5: return nomina.getIdCargo();
            case 6: return nomina.getNombreCargo();
            case 7: return nomina.getRemuneracion();
            case 8: return nomina.getDiasLaborados();
            case 9: return nomina.getTotal();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public void setNominas(List<VoNomina> nuevosNominas) {
        this.nominas = nuevosNominas;
        fireTableDataChanged(); // 🔄 Actualiza la vista
    }
}
