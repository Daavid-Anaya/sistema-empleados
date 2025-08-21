package model.tablas;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.vo.VoCargo;

public class CargoTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private List<VoCargo> cargos;
    private final String[] columnas = {"ID", "Nombre Cargo"};

    public CargoTableModel(List<VoCargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public int getRowCount() {
        return cargos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VoCargo c = cargos.get(rowIndex);
        return columnIndex == 0 ? c.getId() : c.getNombre();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public void setCargos(List<VoCargo> nuevosCargos) {
        this.cargos = nuevosCargos;
        fireTableDataChanged(); // 🔄 Actualiza la vista
    }
}