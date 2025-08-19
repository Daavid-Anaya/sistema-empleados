package view.gui.Paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import controller.Coordinador;
import model.AreaTableModel;
import model.vo.VoArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAreas extends JPanel {
    private Coordinador coordinador;
    private JButton btnBuscarArea, btnRegistrarArea, btnActualizarArea, btnEliminarArea, btnLimpiarTxt;
    public JButton btnEnviar;
    private JLabel lbl_Id, lbl_IdArea, lblNombreArea;
    private JTextField txtFId, txtFIdArea, txtFNombreArea;
    private DefaultTableModel modeloTablaAreas;
	private JTable tablaAreas;
	private JScrollPane scrollTablaAreas;
    private JSeparator separador1, separador2;

    private static final long serialVersionUID = 1L;

    public PanelAreas() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        // Etiquetas //
        lbl_Id = new JLabel("Ingrese el ID del Area a consultar:");
		lbl_Id.setFont(new Font("Consolas", Font.BOLD, 14));
	    lbl_Id.setBounds(80, 30, 290, 20);
	    add(lbl_Id);

        lbl_IdArea = new JLabel("ID:");
        lbl_IdArea.setFont(new Font("Consolas", Font.BOLD, 14));
        lbl_IdArea.setBounds(20, 100, 60, 20);
        add(lbl_IdArea);

        lblNombreArea = new JLabel("Nombre:");
        lblNombreArea.setFont(new Font("Consolas", Font.BOLD, 14));
        lblNombreArea.setBounds(20, 145, 60, 20);
        add(lblNombreArea);

        // Campo de texto //
        txtFId = new JTextField();
	   	txtFId.setFont(new Font("Consolas", Font.PLAIN, 13));
	    txtFId.setBounds(370, 28, 120, 25);
	    txtFId.setColumns(10);
	    add(txtFId);

        txtFIdArea = new JTextField();
        txtFIdArea.setEditable(false);
        txtFIdArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFIdArea.setBounds(80, 98, 150, 25);
        txtFIdArea.setColumns(10);
        add(txtFIdArea);

        txtFNombreArea = new JTextField();
        txtFNombreArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFNombreArea.setBounds(80, 143, 150, 25);
        txtFNombreArea.setColumns(10);
        add(txtFNombreArea);

        // Botones //
        btnBuscarArea = new JButton("Buscar");
        btnBuscarArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnBuscarArea.setBounds(500, 26, 140, 30);
        btnBuscarArea.setMnemonic('b');
        btnBuscarArea.addActionListener(new ManejadorBotonBuscar());
        add(btnBuscarArea);

        btnRegistrarArea = new JButton("Registrar");
        btnRegistrarArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrarArea.setBounds(93, 213, 140, 30);
        btnRegistrarArea.setMnemonic('r');
        btnRegistrarArea.addActionListener(new ManejadorBotonRegistrar());
        add(btnRegistrarArea);

        btnActualizarArea = new JButton("Actualizar");
        btnActualizarArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnActualizarArea.setBounds(93, 256, 140, 30);
        btnActualizarArea.setMnemonic('a');
        btnActualizarArea.addActionListener(new ManejarBotonActualizar());
        add(btnActualizarArea);

        btnEliminarArea = new JButton("Eliminar");
        btnEliminarArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEliminarArea.setBounds(93, 299, 140, 30);
        btnEliminarArea.setMnemonic('e');
        btnEliminarArea.addActionListener(new ManejarBotonEliminar());
        add(btnEliminarArea);

        btnLimpiarTxt = new JButton("Limpiar");
        btnLimpiarTxt.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnLimpiarTxt.setBounds(93, 342, 140, 30);
        btnLimpiarTxt.setMnemonic('l');
        btnLimpiarTxt.addActionListener(new ManejarBotonLimpiar());
        add(btnLimpiarTxt);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEnviar.setBounds(93, 385, 140, 30);
        btnEnviar.setMnemonic('v');
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(new ManejarBotonEnviar());
        add(btnEnviar);

        // Tablas //
        modeloTablaAreas = new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Nombre Area"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaAreas = new JTable(modeloTablaAreas);
        tablaAreas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        tablaAreas.setFont(new Font("Consolas", Font.PLAIN, 13));
        tablaAreas.getTableHeader().setReorderingAllowed(false);
        tablaAreas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaAreas.getSelectedRow();
                if (fila != -1) {
                    txtFIdArea.setText(tablaAreas.getValueAt(fila, 0).toString());
                    txtFNombreArea.setText(tablaAreas.getValueAt(fila, 1).toString());
                }
            }
        });
        
        // Scrolls //
        scrollTablaAreas = new JScrollPane(tablaAreas);
        scrollTablaAreas.setBounds(330, 80, 420, 370);
        add(scrollTablaAreas);

        // Separadores //
	    separador1 = new JSeparator();
	    separador1.setBounds(10, 80, 310, 10);
        add(separador1);
        
        separador2 = new JSeparator();
	    separador2.setBounds(10, 190, 310, 10);
        add(separador2);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void limpiarDatosArea() {
        txtFIdArea.setText("");
        txtFNombreArea.setText("");
    }

    public void mostrarTablaAreas() {
		tablaAreas.setModel(new AreaTableModel(coordinador.cargaListaAreas()));
    }

    // Clases internas que implementa ActionListener
    // Buscar Area
    private class ManejadorBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (txtFId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del área a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                VoArea area = coordinador.buscarArea(new VoArea(Integer.parseInt(txtFId.getText())));
                if (area != null) {
                    txtFIdArea.setText(String.valueOf(area.getId()));
                    txtFNombreArea.setText(area.getNombre());
                } else {
                    JOptionPane.showMessageDialog(null, "Área no encontrada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            txtFId.setText("");
        }
    }

	// Registrar Cargo
    private class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!txtFNombreArea.getText().isEmpty()) {
                if (coordinador.insertarArea(new VoArea(txtFNombreArea.getText()))) {
        		mostrarTablaAreas();
        		JOptionPane.showMessageDialog(null, "Área registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		JOptionPane.showMessageDialog(null, "Error al registrar el área.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
            limpiarDatosArea();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del área.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Actualizar Área
    private class ManejarBotonActualizar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int fila = tablaAreas.getSelectedRow();
            if (fila != -1) {
                if (coordinador.actualizarArea(new VoArea(Integer.parseInt(txtFIdArea.getText()), txtFNombreArea.getText()))) {
                    mostrarTablaAreas();
                    limpiarDatosArea();
                    JOptionPane.showMessageDialog(null, "Área actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el Área.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un área para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
		}
    }
	
    // Eliminar Cargo
    private class ManejarBotonEliminar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int fila = tablaAreas.getSelectedRow();
            if (fila != -1 && !txtFIdArea.getText().isEmpty()) {
                boolean confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el área seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                if (confirmacion && coordinador.eliminarArea(new VoArea(Integer.parseInt(txtFIdArea.getText())))) {
                    mostrarTablaAreas();
                    limpiarDatosArea();
                    JOptionPane.showMessageDialog(null, "Cargo eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se eliminó el cargo.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un cargo para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }  
		}
    }

    // Limpiar Campos
    public class ManejarBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarDatosArea();
        }
    }

    // Enviar datos a panel empleados
    public class ManejarBotonEnviar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!txtFNombreArea.getText().isEmpty() && !txtFIdArea.getText().isEmpty()) {
				VoArea area = new VoArea(Integer.parseInt(txtFIdArea.getText()), txtFNombreArea.getText());
				coordinador.enviarArea(area);
        	} 
			limpiarDatosArea();
            btnEnviar.setEnabled(false);
		}
    }
}