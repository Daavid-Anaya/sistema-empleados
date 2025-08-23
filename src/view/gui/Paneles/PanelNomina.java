package view.gui.Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import controller.Coordinador;

public class PanelNomina extends JPanel {
	private Coordinador coordinador;
    private JPanel panelEmp, panelNomina, panelAcciones;
    private JLabel lblDocEmp, lblIdEmp, lblNombreEmp, lblApellidoEmp, lblIdCargo, lblCargo, lblRemune;
    private JLabel lblFecha, lblDias, lblTotal, lblIdNomina, lbl_Id;
    private JTextField txtDocEmp, txtIdEmp, txtNomEmp, txtApellEmp, txtIdCargo, txtCargo, txtRemune;
    private JTextField txtFecha, txtDias, txtTotal, txtIdNomina, txtId;
	private JTable tablaEmp;
    private DefaultTableModel modeloTablaNom;
    private JScrollPane scrollTablaNom;
	private JButton btnRegistrar, btnModificar, btnEliminar, btnBuscar, btnLimpiarTxt, btnFecha, btnCalcular;

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
        lblDocEmp.setBounds(10, 24, 56, 15);
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
        lblRemune.setBounds(10, 180, 56, 15);
        panelEmp.add(lblRemune);

        // Campos de texto //
        txtDocEmp = new JTextField();
        txtDocEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDocEmp.setColumns(10);
        txtDocEmp.setBounds(80, 19, 175, 20);
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
        panelEmp.add(txtNomEmp);
        
        txtApellEmp = new JTextField();
        txtApellEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtApellEmp.setColumns(10);
        txtApellEmp.setBounds(80, 97, 175, 20);
        panelEmp.add(txtApellEmp);
        
        txtIdCargo = new JTextField();
        txtIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdCargo.setColumns(10);
        txtIdCargo.setBounds(80, 123, 175, 20);
        panelEmp.add(txtIdCargo);
        
        txtCargo= new JTextField();
        txtCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtCargo.setColumns(10);
        txtCargo.setBounds(80, 149, 175, 20);
        panelEmp.add(txtCargo);
        
        txtRemune = new JTextField();
        txtRemune.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtRemune.setColumns(10);
        txtRemune.setBounds(80, 175, 175, 20);
        panelEmp.add(txtRemune);

        //// Panel datos Nomina ////
        panelNomina = new JPanel();
        panelNomina.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Nomina", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelNomina.setBackground(Color.WHITE);
        panelNomina.setBounds(290, 15, 470, 114);
        panelNomina.setLayout(null);
        add(panelNomina);
        
        // Etiquetas //
        lblFecha = new JLabel("Fecha:");
        lblFecha.setBounds(10, 24, 42, 15);
        lblFecha.setFont(new Font("Consolas", Font.BOLD, 12));
        panelNomina.add(lblFecha);
        
        lblDias = new JLabel("Dias laborados:");
        lblDias.setFont(new Font("Consolas", Font.BOLD, 11));
        lblDias.setBounds(10, 50, 120, 15);
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
        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFecha.setColumns(10);
        txtFecha.setBounds(60, 19, 115, 20);
        panelNomina.add(txtFecha);
        
        txtDias = new JTextField();
        txtDias.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDias.setBounds(105, 45, 150, 20);
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
        
        // Botones //
        btnFecha = new JButton("Fecha");
        btnFecha.setFont(new Font("Consolas", Font.PLAIN, 10));
        btnFecha.setBounds(180, 19, 75, 20);
        btnFecha.addActionListener(new ManejarBotonFecha());
        panelNomina.add(btnFecha);
        
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
        modeloTablaNom = new DefaultTableModel(new Object[][] {}, new String[] {"ID Nomina", "Fecha", "ID Emp", "Nombre", "Apellido", "Documento", "ID Cargo", "Remuneración", "Cant", "Total"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaEmp = new JTable(modeloTablaNom);
        tablaEmp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        tablaEmp.setFont(new Font("Consolas", Font.PLAIN, 10));
        tablaEmp.getTableHeader().setReorderingAllowed(false);
        tablaEmp.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaEmp.getSelectedRow();
                if (fila != -1 && tablaEmp.getValueAt(fila, 0) != null) {
                    
                }
            }
        });
        
        // Scrolls //
        scrollTablaNom = new JScrollPane(tablaEmp);
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
        txtFecha.setText("");
        txtDias.setText("");
        txtTotal.setText("");
        txtIdNomina.setText("");
        txtTotal.setText("");
        txtId.setText("");
    }
    
 // Clases internas que implementa ActionListener
    // Buscar Area
    private class ManejadorBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                
            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

	// Registrar Cargo
    private class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        
        }
    }

    // Actualizar Área
    private class ManejarBotonActualizar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            
		}
    }
	
    // Eliminar Cargo
    private class ManejarBotonEliminar implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            
		}
    }
    
    // Seleccionar Fecha
    private class ManejarBotonFecha implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            
		}
    }
	
    // Calcular pago total
    private class ManejarBotonTotal implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
            
		}
    }
    
 // Limpiar Campos
    public class ManejarBotonLimpiar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarDatos();
        }
    }
}