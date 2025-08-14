package view.gui.Paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import controller.Coordinador;
import model.CargoTableModel;
import model.vo.VoCargo;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCargos extends JPanel {
    private Coordinador coordinador;
    private JButton btnRegistrarCargo, btnActualizarCargo, btnEliminarCargo;
    private JLabel lbl_IdCargo, lblNombreCargo;
    private JTextField txtFNombreCargo, txtFIdCargo;
    private DefaultTableModel modeloTablaCargos;
	private JTable tablaCargos;
	private JScrollPane scrollTablaCargos;

    private static final long serialVersionUID = 1L;

    public PanelCargos() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
		setLayout(null);

        // Etiquetas //
        lbl_IdCargo = new JLabel("ID:");
        lbl_IdCargo.setFont(new Font("Consolas", Font.BOLD, 14));
        lbl_IdCargo.setBounds(20, 37, 60, 20);
        add(lbl_IdCargo);

        lblNombreCargo = new JLabel("Nombre:");
        lblNombreCargo.setFont(new Font("Consolas", Font.BOLD, 14));
        lblNombreCargo.setBounds(20, 82, 60, 20);
        add(lblNombreCargo);

        // Campo de texto //
        txtFNombreCargo = new JTextField();
        txtFNombreCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFNombreCargo.setBounds(80, 80, 120, 25);
        txtFNombreCargo.setColumns(10);
        add(txtFNombreCargo);
        
        txtFIdCargo = new JTextField();
        txtFIdCargo.setEditable(false);
        txtFIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFIdCargo.setBounds(80, 35, 120, 25);
        add(txtFIdCargo);
        txtFIdCargo.setColumns(10);

        // Botones //
        btnRegistrarCargo = new JButton("Registrar");
        btnRegistrarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrarCargo.setBounds(80, 127, 120, 28);
        btnRegistrarCargo.setMnemonic('r');
        btnRegistrarCargo.addActionListener(new ManejadorBotonRegistrar());
        add(btnRegistrarCargo);

        btnActualizarCargo = new JButton("Actualizar");
        btnActualizarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnActualizarCargo.setBounds(80, 170, 120, 28);
        btnActualizarCargo.setMnemonic('A');
        btnActualizarCargo.addActionListener(new ManejarBotonActuralizar());
        add(btnActualizarCargo);

        btnEliminarCargo = new JButton("Eliminar");
        btnEliminarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEliminarCargo.setBounds(80, 213, 120, 28);
        btnEliminarCargo.setMnemonic('e');
        btnEliminarCargo.addActionListener(new ManejarBotonEliminar());
        add(btnEliminarCargo);

        // Tablas //
        modeloTablaCargos = new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Nombre Cargo"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tablaCargos = new JTable(modeloTablaCargos);
        tablaCargos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        tablaCargos.setFont(new Font("Consolas", Font.PLAIN, 13));
        tablaCargos.getTableHeader().setReorderingAllowed(false);
        tablaCargos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaCargos.getSelectedRow();
                if (fila != -1) {
                    txtFIdCargo.setText(tablaCargos.getValueAt(fila, 0).toString());
                    txtFNombreCargo.setText(tablaCargos.getValueAt(fila, 1).toString());
                }
            }
        });
        
        // Scrolls //
        scrollTablaCargos = new JScrollPane(tablaCargos);
        scrollTablaCargos.setBounds(230, 35, 350, 392);
        add(scrollTablaCargos);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
	
	public void limpiarDatosCargo() {
        txtFNombreCargo.setText("");
        txtFIdCargo.setText("");
    }
	
	public void mostrarTablaCargos() {
		tablaCargos.setModel(new CargoTableModel(coordinador.cargaListaCargos()));
    }

    // Clases interna que implementa ActionListener
	// Registrar Cargo
    private class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	if (!txtFNombreCargo.getText().isEmpty() && coordinador.insertarCargo(new VoCargo(txtFNombreCargo.getText()))) {
        		mostrarTablaCargos();
        		JOptionPane.showMessageDialog(null, "Cargo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		JOptionPane.showMessageDialog(null, "Error al registrar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
           limpiarDatosCargo();
        }
    }
    
    // Actualizar Cargo
    private class ManejarBotonActuralizar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int fila = tablaCargos.getSelectedRow();
            if (fila != -1) {;
                if (coordinador.actualizarCargo(new VoCargo(Integer.parseInt(txtFIdCargo.getText()), txtFNombreCargo.getText()))) {
                    mostrarTablaCargos();
                    limpiarDatosCargo();
                    JOptionPane.showMessageDialog(null, "Cargo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un cargo para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
		}
    }
	
    // Eliminar Cargo
    private class ManejarBotonEliminar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int fila = tablaCargos.getSelectedRow();
            if (fila != -1 && !txtFIdCargo.getText().isEmpty()) {
                boolean confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el cargo seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                if (confirmacion && coordinador.eliminarCargo(new VoCargo(Integer.parseInt(txtFIdCargo.getText())))) {
                    mostrarTablaCargos();
                    limpiarDatosCargo();
                    JOptionPane.showMessageDialog(null, "Cargo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se eliminó el cargo.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un cargo para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }  
		}
    }
}