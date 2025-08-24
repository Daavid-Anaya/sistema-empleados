package view.gui.Paneles;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import model.tablas.EmpleadoTableModel;
import model.vo.VoArea;
import model.vo.VoCargo;
import model.vo.VoEmpleado;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEmpleados extends JPanel {
    private Coordinador coordinador;
    private JPanel panelEmp, panelArea, panelCargo, panelAcciones;
    private JLabel lblIdEmp, lblNombreEmp, lblApellidoEmp, lblTipoDocEmp, lblDocumentoEmp, lblTelefonoEmp, lblCorreoEmp;
    private JLabel lbl_Id, lblIdArea, lblArea, lblIdCargo, lblCargo;
    private JTextField txtId, txtIdEmp, txtNomEmp, txtApellEmp, txtDocEmp, txtTelEmp, txtCorreoEmp;
	public JTextField txtIdArea, txtArea, txtIdCargo, txtCargo;
    private JComboBox<String> ComboDoc;
	private JTable tablaEmp;
    private DefaultTableModel modeloTablaEmp;
    private JScrollPane scrollTablaEmp;
	private JButton btnRegistrar, btnModificar, btnEliminar, btnBuscar, btnBuscarArea, btnBuscarCargo, btnLimpiarTxt;

    private static final long serialVersionUID = 1L;

    public PanelEmpleados() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);

        //// Panel de Empleados ////
        panelEmp = new JPanel();
        panelEmp.setBackground(new Color(255, 255, 255));
        panelEmp.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelEmp.setBounds(5, 15, 275, 211);
        panelEmp.setLayout(null);
        add(panelEmp);

        // Etiquetas //    
        lblIdEmp = new JLabel("ID");
        lblIdEmp.setBounds(10, 24, 14, 15);
        lblIdEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        panelEmp.add(lblIdEmp);

        lblNombreEmp = new JLabel("Nombre");
        lblNombreEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblNombreEmp.setBounds(10, 50, 42, 15);
        panelEmp.add(lblNombreEmp);
        
        lblApellidoEmp = new JLabel("Apellido");
        lblApellidoEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblApellidoEmp.setBounds(10, 76, 56, 15);
        panelEmp.add(lblApellidoEmp);
        
        lblTipoDocEmp = new JLabel("Tipo Doc");
        lblTipoDocEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblTipoDocEmp.setBounds(10, 102, 56, 15);
        panelEmp.add(lblTipoDocEmp);
        
        lblDocumentoEmp = new JLabel("Documento");
        lblDocumentoEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblDocumentoEmp.setBounds(10, 128, 63, 15);
        panelEmp.add(lblDocumentoEmp);
        
        lblTelefonoEmp = new JLabel("Telefono");
        lblTelefonoEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblTelefonoEmp.setBounds(10, 154, 56, 15);
        panelEmp.add(lblTelefonoEmp);
        
        lblCorreoEmp = new JLabel("Correo");
        lblCorreoEmp.setFont(new Font("Consolas", Font.BOLD, 12));
        lblCorreoEmp.setBounds(10, 180, 56, 15);
        panelEmp.add(lblCorreoEmp);

        // Campos de texto //
        txtIdEmp = new JTextField();
        txtIdEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdEmp.setBounds(80, 19, 175, 20);
        txtIdEmp.setColumns(10);
        txtIdEmp.setEnabled(false);
        panelEmp.add(txtIdEmp);
        
        txtNomEmp = new JTextField();
        txtNomEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtNomEmp.setColumns(10);
        txtNomEmp.setBounds(80, 45, 175, 20);
        panelEmp.add(txtNomEmp);
        
        txtApellEmp = new JTextField();
        txtApellEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtApellEmp.setColumns(10);
        txtApellEmp.setBounds(80, 71, 175, 20);
        panelEmp.add(txtApellEmp);
        
        txtDocEmp = new JTextField();
        txtDocEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDocEmp.setColumns(10);
        txtDocEmp.setBounds(80, 123, 175, 20);
        panelEmp.add(txtDocEmp);
        
        txtTelEmp = new JTextField();
        txtTelEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtTelEmp.setColumns(10);
        txtTelEmp.setBounds(80, 149, 175, 20);
        panelEmp.add(txtTelEmp);
        
        txtCorreoEmp = new JTextField();
        txtCorreoEmp.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtCorreoEmp.setColumns(10);
        txtCorreoEmp.setBounds(80, 175, 175, 20);
        panelEmp.add(txtCorreoEmp);

        // Cuadro combinado //
        ComboDoc = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"INE", "Pasaporte", "Carnet"})); 
        ComboDoc.setFont(new Font("Consolas", Font.PLAIN, 13));
        ComboDoc.setBounds(80, 97, 175, 20);
        panelEmp.add(ComboDoc);

        //// Panel de Areas ////
        panelArea = new JPanel();
        panelArea.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Area", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelArea.setBackground(Color.WHITE);
        panelArea.setBounds(290, 15, 230, 114);
        panelArea.setLayout(null);
        add(panelArea);
        
        // Etiquetas //
        lblIdArea = new JLabel("ID");
        lblIdArea.setBounds(10, 24, 14, 15);
        lblIdArea.setFont(new Font("Consolas", Font.BOLD, 12));
        panelArea.add(lblIdArea);
        
        lblArea = new JLabel("Area");
        lblArea.setFont(new Font("Consolas", Font.BOLD, 12));
        lblArea.setBounds(10, 54, 42, 15);
        panelArea.add(lblArea);
        
        txtIdArea = new JTextField();
        txtIdArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdArea.setColumns(10);
        txtIdArea.setBounds(57, 19, 153, 20);
        txtIdArea.setEnabled(false);
        panelArea.add(txtIdArea);
        
        txtArea = new JTextField();
        txtArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtArea.setColumns(10);
        txtArea.setBounds(57, 51, 153, 20);
        txtArea.setEnabled(false);
        panelArea.add(txtArea);
        
        btnBuscarArea = new JButton("Seleccionar");
        btnBuscarArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnBuscarArea.setBounds(57, 79, 120, 23);
        btnBuscarArea.addActionListener(new ManejadorBotonAreas());
        panelArea.add(btnBuscarArea);

        //// Panel Cargos ////
        panelCargo = new JPanel();
        panelCargo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cargo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panelCargo.setBackground(Color.WHITE);
        panelCargo.setBounds(530, 15, 230, 114);
        panelCargo.setLayout(null);
        add(panelCargo);

        lblIdCargo = new JLabel("ID");
        lblIdCargo.setFont(new Font("Consolas", Font.BOLD, 12));
        lblIdCargo.setBounds(10, 24, 14, 15);
        panelCargo.add(lblIdCargo);
        
        lblCargo = new JLabel("Cargo");
        lblCargo.setFont(new Font("Consolas", Font.BOLD, 12));
        lblCargo.setBounds(10, 54, 42, 15);
        panelCargo.add(lblCargo);
        
        txtIdCargo = new JTextField();
        txtIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtIdCargo.setColumns(10);
        txtIdCargo.setBounds(57, 19, 153, 20);
        txtIdCargo.setEnabled(false);
        panelCargo.add(txtIdCargo);
        
        txtCargo = new JTextField();
        txtCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtCargo.setColumns(10);
        txtCargo.setBounds(57, 51, 153, 20);
        txtCargo.setEnabled(false);
        panelCargo.add(txtCargo);
        
        btnBuscarCargo = new JButton("Seleccionar");
        btnBuscarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnBuscarCargo.setBounds(57, 79, 120, 23);
        btnBuscarCargo.addActionListener(new ManejadorBotonCargos());
        panelCargo.add(btnBuscarCargo);

        // Tablas //
        modeloTablaEmp = new DefaultTableModel(new Object[][] {}, new String[] {"ID", "Nombre", "Tipo Doc", "Documento", "Area", "Cargo", "Telefono", "Correo"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaEmp = new JTable(modeloTablaEmp);
        tablaEmp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        tablaEmp.setFont(new Font("Consolas", Font.PLAIN, 10));
        tablaEmp.getTableHeader().setReorderingAllowed(false);
        tablaEmp.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tablaEmp.getSelectedRow();
                if (fila != -1 && tablaEmp.getValueAt(fila, 0) != null) {
                    txtIdEmp.setText(tablaEmp.getValueAt(fila, 0).toString());
                    txtNomEmp.setText(tablaEmp.getValueAt(fila, 1).toString());
                    txtApellEmp.setText(tablaEmp.getValueAt(fila, 2).toString());
                    ComboDoc.setSelectedItem(tablaEmp.getValueAt(fila, 3).toString());
                    txtDocEmp.setText(tablaEmp.getValueAt(fila, 4).toString());
                    txtArea.setText(tablaEmp.getValueAt(fila, 5).toString());
                    txtCargo.setText(tablaEmp.getValueAt(fila, 6).toString());
                    txtTelEmp.setText(tablaEmp.getValueAt(fila, 7).toString());
                    txtCorreoEmp.setText(tablaEmp.getValueAt(fila, 8).toString());
                    tablaEmp.clearSelection(); // Limpia la selección para evitar que se mantenga resaltada
                }
            }
        });

        // Scrolls //
        scrollTablaEmp = new JScrollPane(tablaEmp);
        scrollTablaEmp.setBounds(5, 234, 752, 218);
        add(scrollTablaEmp);

        //// Panel Acciones ////
        panelAcciones = new JPanel();
        panelAcciones.setBackground(new Color(255, 255, 255));
        panelAcciones.setBorder(new TitledBorder(null, "Acciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelAcciones.setBounds(290, 134, 470, 92);
        panelAcciones.setLayout(null);
        add(panelAcciones);
        
        lbl_Id = new JLabel("Ingrese ID del Empleado a buscar:");
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
        
        btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnModificar.setBounds(130, 20, 100, 25);
        btnModificar.addActionListener(new ManejadorBotonActualizar());
        panelAcciones.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnEliminar.setBounds(240, 20, 100, 25);
        btnEliminar.addActionListener(new ManejadorBotonEliminar());
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
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void limpiarDatos() {
        txtId.setText("");
    	txtIdEmp.setText("");
    	txtNomEmp.setText("");
    	txtApellEmp.setText("");
    	txtDocEmp.setText("");
    	txtTelEmp.setText("");
    	txtCorreoEmp.setText("");
    	txtIdArea.setText("");
    	txtArea.setText("");
    	txtIdCargo.setText("");
    	txtCargo.setText("");
    }

    public void mostrarTablaEmpleados() {
    	tablaEmp.setModel(new EmpleadoTableModel(coordinador.cargaListaEmpleados()));
    }

    // Clases internas que implementa ActionListener
    // Boton para seleccionar area
    public class ManejadorBotonAreas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            coordinador.irArea();
        }
    }

    // Boton para seleccionar cargo
    public class ManejadorBotonCargos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            coordinador.irCargo();
        }
    }

    // Registrar Empleado
    public class ManejadorBotonRegistrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idEmp = txtIdEmp.getText().trim();
            String nombreEmp = txtNomEmp.getText();
            String apellEmp = txtApellEmp.getText();
            String tipoDoc = ComboDoc.getSelectedItem().toString();
            String docEmp = txtDocEmp.getText();
            String idArea = txtIdArea.getText();
            String idCargo = txtIdCargo.getText();
            String telEmp = txtTelEmp.getText();
            String correoEmp = txtCorreoEmp.getText();
            

            if (idEmp.isEmpty() && coordinador.verificaCamposVaciosEmpleado(nombreEmp, apellEmp, docEmp, idArea, idCargo, telEmp, correoEmp)) { // 
        		VoEmpleado nuevoEmpleado = new VoEmpleado(nombreEmp, tipoDoc, apellEmp, docEmp, Integer.parseInt(idArea), Integer.parseInt(idCargo), telEmp, correoEmp);
                if (coordinador.insertarEmpleado(nuevoEmpleado)) {
                    mostrarTablaEmpleados();
                    limpiarDatos();
        		    JOptionPane.showMessageDialog(null, "Empleado registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);    
                } else {
        		    JOptionPane.showMessageDialog(null, "Error al registrar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
        	    }
            } else {
        		JOptionPane.showMessageDialog(null, "Ingrese todos los campos y verifique el campo ID este vacio.", "Error", JOptionPane.WARNING_MESSAGE);
        	}
        }
    }

    // Actualizar Empleado
    public class ManejadorBotonActualizar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idEmp = txtIdEmp.getText().trim();
            String nombreEmp = txtNomEmp.getText();
            String apellEmp = txtApellEmp.getText();
            String tipoDoc = ComboDoc.getSelectedItem().toString();
            String documento = txtDocEmp.getText();
            String idArea = txtIdArea.getText();
            String nombreArea = txtArea.getText();
            String idCargo = txtIdCargo.getText();
            String nombreCargo = txtCargo.getText();
            String telEmp = txtTelEmp.getText();
            String correoEmp = txtCorreoEmp.getText();

            if (!idEmp.isEmpty() && coordinador.verificaCamposVaciosEmpleado(nombreEmp, apellEmp, documento, idArea, idCargo, telEmp, correoEmp)) {
                int id = Integer.parseInt(idEmp);
                if (coordinador.existeIdEmpleado(id)) {
                    if (coordinador.actualizarEmpleado(new VoEmpleado(id, nombreEmp, apellEmp, tipoDoc, documento, Integer.parseInt(idArea), nombreArea, Integer.parseInt(idCargo), nombreCargo, telEmp, correoEmp))) {
                        limpiarDatos();
                        mostrarTablaEmpleados();
                        JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El ID del empleado no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique que no haya campos vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Eliminar Empleado
    public class ManejadorBotonEliminar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idEmp = txtIdEmp.getText().trim();
            if (!idEmp.isEmpty()) {
                boolean confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el empleado seleccionada?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
                if (confirmacion && coordinador.eliminarEmpleado(Integer.parseInt(idEmp))) {
                    limpiarDatos();
                    mostrarTablaEmpleados();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se eliminó el empleado.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);  
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un empleado para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // Buscar Empleado
    public class ManejadorBotonBuscar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idEmp = txtId.getText().trim();
            try {
                if (idEmp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el ID del empleado a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    VoEmpleado empleado = coordinador.buscarEmpleado(Integer.parseInt(idEmp));
                    if (empleado != null) {
                        txtIdEmp.setText(String.valueOf(empleado.getIdEmpleado()));
                        txtNomEmp.setText(empleado.getNombre());
                        txtApellEmp.setText(empleado.getApellido());
                        ComboDoc.setSelectedItem(empleado.getTipoDoc());
                        txtDocEmp.setText(empleado.getDocumento());
                        txtIdArea.setText(String.valueOf(empleado.getIdArea()));
                        txtIdCargo.setText(String.valueOf(empleado.getIdCargo()));
                        txtTelEmp.setText(empleado.getTelefono());
                        txtCorreoEmp.setText(empleado.getCorreo());
                        
                        VoArea area = coordinador.buscarArea(String.valueOf(empleado.getIdArea()));
                        if (area != null) {
                            txtArea.setText(area.getNombre());
                        }
                        VoCargo cargo = coordinador.buscarCargo(String.valueOf(empleado.getIdCargo()));
                        if (cargo != null) {
                            txtCargo.setText(cargo.getNombre());
                        }
                         
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: La cadena no es un entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                txtId.setText("");
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
}