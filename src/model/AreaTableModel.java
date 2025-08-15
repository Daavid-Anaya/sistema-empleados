package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.vo.VoArea;

public class AreaTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private List<VoArea> areas;
    private final String[] columnas = {"ID", "Nombre Area"};

    public AreaTableModel(List<VoArea> areas) {
        this.areas = areas;
    }

    @Override
    public int getRowCount() {
        return areas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VoArea area = areas.get(rowIndex);
        return columnIndex == 0 ? area.getId() : area.getNombre();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    public void setAreas(List<VoArea> nuevosAreas) {
        this.areas = nuevosAreas;
        fireTableDataChanged(); // 🔄 Actualiza la vista
    }
}