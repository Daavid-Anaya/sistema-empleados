package view.gui.Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.Coordinador;
import model.tablas.NominaTableModel;
import model.vo.VoCargo;
import model.vo.VoEmpleado;
import model.vo.VoNomina;

public class PanelNomina extends JPanel {
	private Coordinador coordinador;
    private JPanel panelEmp, panelNomina, panelAcciones;
    private JLabel lblDocEmp, lblIdEmp, lblNombreEmp, lblApellidoEmp, lblIdCargo, lblCargo, lblRemune;
    private JLabel lblFecha, lblDias, lblTotal, lblIdNomina, lbl_Id;
    private JTextField txtDocEmp, txtIdEmp, txtNomEmp, txtApellEmp, txtIdCargo, txtCargo, txtRemune;
    private JTextField txtDias, txtTotal, txtIdNomina, txtId;
	private JTable tablaNom;
    private DefaultTableModel modeloTablaNom;
    private JScrollPane scrollTablaNom;
	private JButton btnRegistrar, btnModificar, btnEliminar, btnBuscar, btnLimpiarTxt, btnCalcular, btnBuscarEmp;
    private JDateChooser fecha;

    private static final long serialVersionUID = 1L;

    public PanelNomina() {
        iniciarComponentes();
    }

	private void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        //// Panel datos de Empleados ////
        panelEmp = new JPanel();
        panelEmp.setBackground(new Color(255, 255, 255));
        panelEmp.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelEmp.setBounds(5, 15, 275, 211);
        panelEmp.setLayout(null);
        add(panelEmp);

        // Etiquetas //    
        lblDocEmp = new JLabel("Documento");
        lblDocEmp.setBounds(10, 24, 70, 15);
        lblDocEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        panelEmp.add(lblDocEmp);
        
        lblIdEmp = new JLabel("ID");
        lblIdEmp.setBounds(10, 50, 42, 15);
        lblIdEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        panelEmp.add(lblIdEmp);

        lblNombreEmp = new JLabel("Nombre");
        lblNombreEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblNombreEmp.setBounds(10, 76, 56, 15);
        panelEmp.add(lblNombreEmp);
        
        lblApellidoEmp = new JLabel("Apellido");
        lblApellidoEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblApellidoEmp.setBounds(10, 102, 56, 15);
        panelEmp.add(lblApellidoEmp);
        
        lblIdCargo = new JLabel("Id Cargo");
        lblIdCargo.setFont(new Font("Consolas", Font.BOLD, 12));
        lblIdCargo.setBounds(10, 128, 63, 15);
        panelEmp.add(lblIdCargo);
        
        lblCargo = new JLabel("Cargo");
        lblCargo.setFont(new Font("Consolas", Font.BOLD, 12));
        lblCargo.setBounds(10, 154, 56, 15);
        panelEmp.add(lblCargo);
        
        lblRemune = new JLabel("Remuneración");
        lblRemune.setFont(new Font("Consolas", Font.BOLD, 12));
        lblRemune.setBounds(10, 180, 85, 15);
        panelEmp.add(lblRemune);

        // Campos de texto //
        txtDocEmp = new JTextField();
        txtDocEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDocEmp.setColumns(10);
        txtDocEmp.setBounds(80, 19, 100, 20);
        panelEmp.add(txtDocEmp);
        
        txtIdEmp = new JTextField();
        txtIdEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdEmp.setBounds(80, 45, 175, 20);
        txtIdEmp.setColumns(10);
        txtIdEmp.setEnabled(false);
        panelEmp.add(txtIdEmp);
        
        txtNomEmp = new JTextField();
        txtNomEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtNomEmp.setColumns(10);
        txtNomEmp.setBounds(80, 71, 175, 20);
        txtNomEmp.setEnabled(false);
        panelEmp.add(txtNomEmp);
        
        txtApellEmp = new JTextField();
        txtApellEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtApellEmp.setColumns(10);
        txtApellEmp.setBounds(80, 97, 175, 20);
        txtApellEmp.setEnabled(false);
        panelEmp.add(txtApellEmp);
        
        txtIdCargo = new JTextField();
        txtIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdCargo.setColumns(10);
        txtIdCargo.setBounds(80, 123, 175, 20);
        txtIdCargo.setEnabled(false);
        panelEmp.add(txtIdCargo);
        
        txtCargo = new JTextField();
        txtCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtCargo.setColumns(10);
        txtCargo.setBounds(80, 149, 175, 20);
        txtCargo.setEnabled(false);
        panelEmp.add(txtCargo);
        
        txtRemune = new JTextField();
        txtRemune.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtRemune.setColumns(10);
        txtRemune.setBounds(100, 175, 155, 20);
        txtRemune.setEnabled(false);
        panelEmp.add(txtRemune);

        // Boton //
        btnBuscarEmp = new JButton("Buscar");
        btnBuscarEmp.setFont(new Font("Consolas", Font.PLAIN, 11));
        btnBuscarEmp.setBounds(185, 20, 70, 20);
        btnBuscarEmp.addActionListener(new ManejarBotonBuscarEmp());
        panelEmp.add(btnBuscarEmp);

        //// Panel datos Nomina ////
        panelNomina = new JPanel();
        panelNomina.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Nomina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelNomina.setBackground(Color.WHITE);
        panelNomina.setBounds(290, 15, 470, 114);
        panelNomina.setLayout(null);
        add(panelNomina);
        
        // Etiquetas //
        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 24, 42, 17);
        lblFecha.setFont(new Font("Consolas", Font.BOLD, 12));
        panelNomina.add(lblFecha);

        lblDias = new JLabel("Dias laborados:");
        lblDias.setFont(new Font("Consolas", Font.BOLD, 11));
        lblDias.setBounds(12, 50, 120, 17);
        panelNomina.add(lblDias);
        
        lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Consolas", Font.BOLD, 12));
        lblTotal.setBounds(270, 24, 50, 15);
        panelNomina.add(lblTotal);
        
        lblIdNomina = new JLabel("ID:");
        lblIdNomina.setFont(new Font("Consolas", Font.BOLD, 12));
        lblIdNomina.setBounds(270, 54, 60, 15);
        panelNomina.add(lblIdNomina);
     
        // Campos de texto //     
        txtDias = new JTextField();
        txtDias.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDias.setBounds(102, 45, 150, 20);
        txtDias.setColumns(10);
        panelNomina.add(txtDias);
        
        txtTotal = new JTextField();
        txtTotal.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtTotal.setColumns(10);
        txtTotal.setBounds(315, 19, 140, 20);
        txtTotal.setEnabled(false);
        panelNomina.add(txtTotal);
        
        txtIdNomina = new JTextField();
        txtIdNomina.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdNomina.setColumns(10);
        txtIdNomina.setBounds(315, 45, 140, 20);
        txtIdNomina.setEnabled(false);
        panelNomina.add(txtIdNomina);

        // Fecha //
        fecha = new JDateChooser();
        fecha.setBounds(60, 19, 140, 20);
        panelNomina.add(fecha);
        
        // Boton //  
        btnCalcular = new JButton("Calcular");
        btnCalcular.setFont(new Font("Consolas", Font.PLAIN, 12));
        btnCalcular.setBounds(335, 75, 120, 25);
        btnCalcular.addActionListener(new ManejarBotonTotal());
        panelNomina.add(btnCalcular);

        //// Panel Acciones ////
        panelAcciones = new JPanel();
        panelAcciones.setBackground(new Color(255, 255, 255));
        panelAcciones.setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelAcciones.setBounds(290, 134, 470, 92);
        panelAcciones.setLayout(null);
        add(panelAcciones);
        
        lbl_Id = new JLabel("Ingrese ID de la nomina a buscar:");
		lbl_Id.setFont(new Font("Consolas", Font.BOLD, 11));
	    lbl_Id.setBounds(20, 52, 220, 25);
	    panelAcciones.add(lbl_Id);
	    
	    txtId = new JTextField();
	   	txtId.setFont(new Font("Consolas", Font.PLAIN, 13));
	    txtId.setBounds(240, 50, 100, 25);
	    txtId.setColumns(10);
	    panelAcciones.add(txtId);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrar.setBounds(20, 20, 100, 25);
        btnRegistrar.addActionListener(new ManejadorBotonRegistrar());
        panelAcciones.add(btnRegistrar);
        
        btnModificar = new JButton("Editar");
        btnModificar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnModificar.setBounds(130, 20, 100, 25);
        btnModificar.addActionListener(new ManejarBotonActualizar());
        panelAcciones.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEliminar.setBounds(240, 20, 100, 25);
        btnEliminar.addActionListener(new ManejarBotonEliminar());
        panelAcciones.add(btnEliminar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnBuscar.setBounds(350, 50, 100, 25);
        btnBuscar.addActionListener(new ManejadorBotonBuscar());
        panelAcciones.add(btnBuscar);

        btnLimpiarTxt = new JButton("Limpiar");
        btnLimpiarTxt.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnLimpiarTxt.setBounds(350, 20, 100, 25);
        btnLimpiarTxt.setMnemonic('l');
        btnLimpiarTxt.addActionListener(new ManejarBotonLimpiar());
        panelAcciones.add(btnLimpiarTxt);
        
        // Tablas //
        modeloTablaNom = new DefaultTableModel(new Object[][] {}, new String[] {"ID Nomina", "Fecha", "ID Emp", "Nombre", "Documento", "ID Cargo", "Nombre Cargo", "Remuneración", "Días", "Total"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaNom = new JTable(modeloTablaNom);
        tablaNom.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        tablaNom.setFont(new Font("Consolas", Font.PLAIN, 10));
        tablaNom.getTableHeader().setReorderingAllowed(false);
        tablaNom.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaNom.getSelectedRow();
                if (fila != -1 && tablaNom.getValueAt(fila, 0) != null) {
                    txtIdNomina.setText(tablaNom.getValueAt(fila, 0).toString());
                    fecha.setDate(Date.valueOf(tablaNom.getValueAt(fila, 1).toString()));
                    txtIdEmp.setText(tablaNom.getValueAt(fila, 2).toString());
                    txtNomEmp.setText(tablaNom.getValueAt(fila, 3).toString());
                    txtDocEmp.setText(tablaNom.getValueAt(fila, 4).toString());
                    txtIdCargo.setText(tablaNom.getValueAt(fila, 5).toString());
                    txtCargo.setText(tablaNom.getValueAt(fila, 6).toString());
                    txtRemune.setText(tablaNom.getValueAt(fila, 7).toString());
                    txtDias.setText(tablaNom.getValueAt(fila, 8).toString());
                    txtTotal.setText(tablaNom.getValueAt(fila, 9).toString());
                    tablaNom.clearSelection();
                }
            }
        });
        
        // Scrolls //
        scrollTablaNom = new JScrollPane(tablaNom);
        scrollTablaNom.setBounds(5, 234, 752, 218);
        add(scrollTablaNom);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void limpiarDatos() {
    	txtDocEmp.setText("");
    	txtIdEmp.setText("");
    	txtNomEmp.setText("");
    	txtApellEmp.setText("");
    	txtIdCargo.setText("");
    	txtCargo.setText("");
    	txtRemune.setText("");
    	fecha.setDate(null);
        txtDias.setText("");
        txtTotal.setText("");
        txtIdNomina.setText("");
        txtTotal.setText("");
        txtId.setText("");
    }

    public void mostrarTablaNomina() {
    	tablaNom.setModel(new NominaTableModel(coordinador.cargaListaNominas()));
    }
    
 // Clases internas que implementa ActionListener
    // Buscar Nomina
    private class ManejadorBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

	// Registrar Nomina
    private class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String dias = txtDias.getText();
            String total = txtTotal.getText();
            String idEmp = txtIdEmp.getText();
            String idCargo = txtIdCargo.getText();

            try {
                if (txtIdNomina.getText().trim().isEmpty() && coordinador.verificarCamposVaciosNomina(dias, total, idEmp, idCargo)) { // 
                    VoNomina nomina = new VoNomina();
                    Calendar cal = fecha.getCalendar();
                    if (cal != null) {
                        nomina.setFecha(new Date(cal.getTimeInMillis()));
                    }
                    nomina.setDiasLaborados(Integer.parseInt(dias));
                    nomina.setTotal(Double.parseDouble(total));
                    nomina.setIdEmpleado(Integer.parseInt(idEmp));
                    nomina.setIdCargo(Integer.parseInt(idCargo));
                    if (coordinador.insertarNomina(nomina)) {
                        JOptionPane.showMessageDialog(null, "Nómina registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al registrar la nómina.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos y verifique el campo ID este vacio.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                limpiarDatos();
                mostrarTablaNomina();
            }
        }
    }

    // Actualizar Nomina
    private class ManejarBotonActualizar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            String dias = txtDias.getText();
            String total = txtTotal.getText();
            String idEmp = txtIdEmp.getText();
            String idCargo = txtIdCargo.getText();
            String idNomina = txtIdNomina.getText().trim();
            Calendar cal = fecha.getCalendar();

            try {
                if (!idNomina.isEmpty() && coordinador.verificarCamposVaciosNomina(dias, total, idEmp, idCargo)) { // 
                    VoNomina nomina = new VoNomina();
                    nomina.setId(Integer.parseInt(idNomina));
                    if (cal != null) {
                        nomina.setFecha(new Date(cal.getTimeInMillis()));
                    }
                    nomina.setDiasLaborados(Integer.parseInt(dias));
                    nomina.setTotal(Double.parseDouble(total));
                    nomina.setIdEmpleado(Integer.parseInt(idEmp));
                    nomina.setIdCargo(Integer.parseInt(idCargo));
                    if (coordinador.actualizarNomina(nomina)) {
                        JOptionPane.showMessageDialog(null, "Nómina actualizada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar la nómina.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos y verifique el campo ID este vacio.", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                limpiarDatos();
                mostrarTablaNomina();
            }
		}
    }
	
    // Eliminar Nomina
    private class ManejarBotonEliminar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            
		}
    }
	
    // Calcular pago total
    private class ManejarBotonTotal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            try {
                double dias = 0.0, remuneracion = 0.0, total = 0.0;
                dias = Double.parseDouble(txtDias.getText().trim());
                remuneracion = Double.parseDouble(txtRemune.getText().trim());
                total = dias * remuneracion;
                txtTotal.setText(String.valueOf(total));
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
		}
    }
    
    // Limpiar Campos
    public class ManejarBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarDatos();
        }
    }

    // Buscar Empleado
    public class ManejarBotonBuscarEmp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String docEmp = txtDocEmp.getText().trim();
            if (docEmp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el Documento del empleado a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                VoEmpleado empleado = coordinador.buscarEmpleadoDoc(docEmp);
                if (empleado != null) {
                    txtIdEmp.setText(String.valueOf(empleado.getIdEmpleado()));
                    txtNomEmp.setText(empleado.getNombre());
                    txtApellEmp.setText(empleado.getApellido());
                    txtDocEmp.setText(empleado.getDocumento());
                    txtIdCargo.setText(String.valueOf(empleado.getIdCargo()));
                    VoCargo cargo = coordinador.buscarCargo(String.valueOf(empleado.getIdCargo()));
                    if (cargo != null) {
                        txtCargo.setText(cargo.getNombre());
                        txtRemune.setText(String.valueOf(cargo.getRemuneracion()));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                }
            }
        }
    }
}