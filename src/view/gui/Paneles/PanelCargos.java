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
import model.tablas.CargoTableModel;
import model.vo.VoCargo;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCargos extends JPanel {
    private Coordinador coordinador;
    private JButton btnBuscarCargo, btnRegistrarCargo, btnActualizarCargo, btnEliminarCargo, btnLimpiarTxt;
    public JButton btnEnviar;
    private JLabel lbl_Id, lbl_IdCargo, lblNombreCargo;
    private JTextField txtFId, txtFIdCargo, txtFNombreCargo;
    private DefaultTableModel modeloTablaCargos;
	private JTable tablaCargos;
	private JScrollPane scrollTablaCargos;
    private JSeparator separador1, separador2;

    private static final long serialVersionUID = 1L;

    public PanelCargos() {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
		setLayout(null);

        // Etiquetas //
        lbl_Id = new JLabel("Ingrese el ID del Cargo a consultar:");
		lbl_Id.setFont(new Font("Consolas", Font.BOLD, 14));
	    lbl_Id.setBounds(80, 30, 290, 20);
	    add(lbl_Id);

        lbl_IdCargo = new JLabel("ID:");
        lbl_IdCargo.setFont(new Font("Consolas", Font.BOLD, 14));
        lbl_IdCargo.setBounds(20, 100, 60, 20);
        add(lbl_IdCargo);

        lblNombreCargo = new JLabel("Nombre:");
        lblNombreCargo.setFont(new Font("Consolas", Font.BOLD, 14));
        lblNombreCargo.setBounds(20, 145, 60, 20);
        add(lblNombreCargo);

        // Campo de texto //
        txtFId = new JTextField();
	   	txtFId.setFont(new Font("Consolas", Font.PLAIN, 13));
	    txtFId.setBounds(370, 28, 120, 25);
	    txtFId.setColumns(10);
	    add(txtFId);

        txtFIdCargo = new JTextField();
        txtFIdCargo.setEnabled(false);
        txtFIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFIdCargo.setBounds(80, 98, 150, 25);
        txtFIdCargo.setColumns(10);
        add(txtFIdCargo);

        txtFNombreCargo = new JTextField();
        txtFNombreCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFNombreCargo.setBounds(80, 143, 150, 25);
        txtFNombreCargo.setColumns(10);
        add(txtFNombreCargo);

        // Botones //
        btnBuscarCargo = new JButton("Buscar");
        btnBuscarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnBuscarCargo.setBounds(500, 26, 140, 30);
        btnBuscarCargo.setMnemonic('b');
        btnBuscarCargo.addActionListener(new ManejadorBotonBuscar());
        add(btnBuscarCargo);

        btnRegistrarCargo = new JButton("Registrar");
        btnRegistrarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrarCargo.setBounds(93, 213, 140, 30);
        btnRegistrarCargo.setMnemonic('r');
        btnRegistrarCargo.addActionListener(new ManejadorBotonRegistrar());
        add(btnRegistrarCargo);

        btnActualizarCargo = new JButton("Actualizar");
        btnActualizarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnActualizarCargo.setBounds(93, 256, 140, 30);
        btnActualizarCargo.setMnemonic('a');
        btnActualizarCargo.addActionListener(new ManejarBotonActuralizar());
        add(btnActualizarCargo);

        btnEliminarCargo = new JButton("Eliminar");
        btnEliminarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEliminarCargo.setBounds(93, 299, 140, 30);
        btnEliminarCargo.setMnemonic('e');
        btnEliminarCargo.addActionListener(new ManejarBotonEliminar());
        add(btnEliminarCargo);

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
                    tablaCargos.clearSelection();
                }
            }
        });
        
        // Scrolls //
        scrollTablaCargos = new JScrollPane(tablaCargos);
        scrollTablaCargos.setBounds(330, 80, 420, 370);
        add(scrollTablaCargos);

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
	
	public void limpiarDatosCargo() {
        txtFIdCargo.setText("");
        txtFNombreCargo.setText("");
    }
	
	public void mostrarTablaCargos() {
		tablaCargos.setModel(new CargoTableModel(coordinador.cargaListaCargos()));
    }

    // Clases internas que implementa ActionListener
    // Buscar Cargo
    private class ManejadorBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String idCargo = txtFId.getText().trim();
                if (idCargo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del cargo a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    VoCargo cargo = coordinador.buscarCargo(idCargo);
                    if (cargo != null) {
                        txtFIdCargo.setText(String.valueOf(cargo.getId()));
                        txtFNombreCargo.setText(cargo.getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cargo no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                txtFId.setText("");
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
                txtFId.setText("");
            }
        }
    }

	// Registrar Cargo
    private class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idCargo = txtFIdCargo.getText().trim();
            String nombreCargo = txtFNombreCargo.getText().trim();
            if (idCargo.isEmpty() && !nombreCargo.isEmpty() && !coordinador.existeNombreCargo(nombreCargo)) {
                if (coordinador.insertarCargo(nombreCargo)) {
        		    mostrarTablaCargos();
        		    JOptionPane.showMessageDialog(null, "Cargo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	    } else {
        		    JOptionPane.showMessageDialog(null, "Error al registrar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
        	    }
                limpiarDatosCargo();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, complete el campo Nombre o verifique que no exista el nombre y el campo ID este vacio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    // Actualizar Cargo
    private class ManejarBotonActuralizar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String idCargo = txtFIdCargo.getText().trim();
            String nombreCargo = txtFNombreCargo.getText().trim();
            if (!nombreCargo.isEmpty() && !idCargo.isEmpty()) {
                int id = Integer.parseInt(idCargo);
                if (coordinador.existeIdCargo(id) && !coordinador.existeNombreCargo(nombreCargo)) {
                    if (coordinador.actualizarCargo(new VoCargo(id, nombreCargo))) {
                        limpiarDatosCargo();
                        mostrarTablaCargos();
                        JOptionPane.showMessageDialog(null, "Cargo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el Cargo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } else {
                    JOptionPane.showMessageDialog(null, "ID de cargo no encontrado o nombre ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
		}
    }
	
    // Eliminar Cargo
    private class ManejarBotonEliminar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String idCargo = txtFIdCargo.getText().trim();
            if (!idCargo.isEmpty()) {
                boolean confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el cargo seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                if (confirmacion && coordinador.eliminarCargo(Integer.parseInt(idCargo))) {
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

    // Limpiar Campos
    public class ManejarBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarDatosCargo();
        }
    }

    // Enviar datos a panel empleados
    public class ManejarBotonEnviar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            String idCargo = txtFIdCargo.getText().trim();
            String nombreCargo = txtFNombreCargo.getText().trim();
            if (!nombreCargo.isEmpty() && !idCargo.isEmpty()) {
				VoCargo cargo = new VoCargo(Integer.parseInt(idCargo), nombreCargo);
				coordinador.enviarCargo(cargo);
                limpiarDatosCargo();
                btnEnviar.setEnabled(false);
        	} else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID y nombre del cargo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
			
		}
    }
}