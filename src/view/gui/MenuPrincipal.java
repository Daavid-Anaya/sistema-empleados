package view.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import controller.Coordinador;
import model.CargoTableModel;
import model.vo.VoCargo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame implements ActionListener{
    private Coordinador coordinador;
	private JPanel panelPrincipal, panelMenu, panelHome, panelUsuarios, panelEmpleados, panelCargo, panelArea;
	private JTabbedPane panelPestañas;
	private JButton btnUsuarios, btnEmpleados, btnArea, btnCargo, btnCerrar, btnRegistrarCargo, btnActualizarCargo;
    private JLabel lbl_IdCargo, lblNombreCargo;
    private JTextField txtFNombreCargo, txtFIdCargo;
    private DefaultTableModel modeloTablaCargos;
	private JTable tablaCargos;
	private JScrollPane scrollTablaCargos;
	
	private static final long serialVersionUID = 1L;

	public MenuPrincipal() {
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		// Paneles //
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 834, 511);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new Color(255, 255, 255));
        panelPrincipal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(panelPrincipal);
        
        panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 200, 511);
        panelMenu.setLayout(null);
        panelMenu.setBackground(new Color(102, 102, 204));
        panelMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panelPrincipal.add(panelMenu);
        
        // Panel de Pestañas //
        panelPestañas = new JTabbedPane(JTabbedPane.TOP);
        panelPestañas.setBackground(new Color(244, 244, 244));
        panelPestañas.setBounds(210, 11, 614, 489);
        panelPrincipal.add(panelPestañas);
        
        panelHome = new JPanel();
        panelHome.setBackground(new Color(255, 255, 255));
        panelPestañas.addTab("Home", null, panelHome, null);
        panelHome.setLayout(null);
        
        panelUsuarios = new JPanel();
        panelUsuarios.setBackground(new Color(255, 255, 255));
        panelPestañas.addTab("Usuarios", null, panelUsuarios, null);
        panelUsuarios.setLayout(null);
        
        panelEmpleados = new JPanel();
        panelEmpleados.setBackground(new Color(255, 255, 255));
        panelPestañas.addTab("Empleados", null, panelEmpleados, null);
        panelEmpleados.setLayout(null);
        
        panelArea = new JPanel();
        panelArea.setBackground(new Color(255, 255, 255));
        panelPestañas.addTab("Area", null, panelArea, null);
        panelArea.setLayout(null);
        
        panelCargo = new JPanel();
        panelCargo.setBackground(new Color(255, 255, 255));
        panelPestañas.addTab("Cargo", null, panelCargo, null);
        panelCargo.setLayout(null);

        // Etiquetas //
        // Etiquetas dentro de Canel Cargo
        lbl_IdCargo = new JLabel("ID:");
        lbl_IdCargo.setFont(new Font("Consolas", Font.BOLD, 13));
        lbl_IdCargo.setBounds(40, 37, 50, 20);
        panelCargo.add(lbl_IdCargo);

        lblNombreCargo = new JLabel("Nombre:");
        lblNombreCargo.setFont(new Font("Consolas", Font.BOLD, 13));
        lblNombreCargo.setBounds(40, 82, 50, 20);
        panelCargo.add(lblNombreCargo);

        // Campo de texto //
        // Campo texto dentro de Panel Cargo
        txtFNombreCargo = new JTextField();
        txtFNombreCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFNombreCargo.setBounds(100, 80, 120, 25);
        panelCargo.add(txtFNombreCargo);
        txtFNombreCargo.setColumns(10);
        
        txtFIdCargo = new JTextField();
        txtFIdCargo.setEditable(false);
        txtFIdCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFIdCargo.setBounds(100, 35, 120, 25);
        panelCargo.add(txtFIdCargo);
        txtFIdCargo.setColumns(10);
        
        // Botones //
        // Botones dentro del panel Menu
        btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setFont(new Font("Consolas", Font.BOLD, 13));
        btnUsuarios.setBounds(52, 120, 95, 30);
        btnUsuarios.setMnemonic('u');
        btnUsuarios.addActionListener(this);
        panelMenu.add(btnUsuarios);
        
        btnEmpleados = new JButton("Empleados");
        btnEmpleados.setFont(new Font("Consolas", Font.BOLD, 13));
        btnEmpleados.setBounds(52, 175, 95, 30);
        btnEmpleados.setMnemonic('e');
        btnEmpleados.addActionListener(this);
        panelMenu.add(btnEmpleados);
        
        btnArea = new JButton("Area");
        btnArea.setFont(new Font("Consolas", Font.BOLD, 13));
        btnArea.setBounds(52, 230, 95, 30);
        btnArea.setMnemonic('a');
        btnArea.addActionListener(this);
        panelMenu.add(btnArea);
        
        btnCargo = new JButton("Cargo");
        btnCargo.setFont(new Font("Consolas", Font.BOLD, 13));
        btnCargo.setBounds(52, 285, 95, 30);
        btnCargo.setMnemonic('c');
        btnCargo.addActionListener(this);
        panelMenu.add(btnCargo);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Consolas", Font.BOLD, 13));
        btnCerrar.setBounds(52, 340, 95, 30);
        btnCerrar.setMnemonic('e');
        btnCerrar.addActionListener(this);
        panelMenu.add(btnCerrar);

        // Botones dentro de panel Cargo
        btnRegistrarCargo = new JButton("Registrar");
        btnRegistrarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrarCargo.setBounds(90, 127, 120, 25);
        btnRegistrarCargo.setMnemonic('r');
        btnRegistrarCargo.addActionListener(this);
        panelCargo.add(btnRegistrarCargo);

        btnActualizarCargo = new JButton("Actualizar");
        btnActualizarCargo.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnActualizarCargo.setBounds(90, 163, 120, 25);
        btnActualizarCargo.setMnemonic('A');
        btnActualizarCargo.addActionListener(this);
        panelCargo.add(btnActualizarCargo);

        // Tablas
        // Tabla dentro de panel Cargo
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
        // Scroll dentro de panel Cargos
        scrollTablaCargos = new JScrollPane(tablaCargos);
        scrollTablaCargos.setBounds(230, 35, 350, 392);
        panelCargo.add(scrollTablaCargos);
        
        // Configuración de la ventana //
        setTitle("Menu Principal");
        //setIconImage();
		setSize(850, 550);
		setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public void limpiarDatosCargo() {
        txtFNombreCargo.setText("");
        txtFIdCargo.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUsuarios) {
			panelPestañas.setSelectedComponent(panelUsuarios);
        } else if (e.getSource() == btnEmpleados) {
        	panelPestañas.setSelectedComponent(panelEmpleados);
        } else if (e.getSource() == btnArea) {
        	panelPestañas.setSelectedComponent(panelArea);
        } else if (e.getSource() == btnCargo) {
        	panelPestañas.setSelectedComponent(panelCargo); 
            tablaCargos.setModel(new CargoTableModel(coordinador.cargaListaCargos()));
        } else if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == btnRegistrarCargo) {
            VoCargo cargo = new VoCargo();
        	cargo.setNombre(txtFNombreCargo.getText());
        	if (coordinador.insertarCargo(cargo)) {
                tablaCargos.setModel(new CargoTableModel(coordinador.cargaListaCargos()));
        		JOptionPane.showMessageDialog(this, "Cargo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		JOptionPane.showMessageDialog(this, "Error al registrar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
            limpiarDatosCargo();
        } else if (e.getSource() == btnActualizarCargo) {
            int fila = tablaCargos.getSelectedRow();
            if (fila != -1) {
                VoCargo cargo = new VoCargo();
                cargo.setId(Integer.parseInt(txtFIdCargo.getText()));
                cargo.setNombre(txtFNombreCargo.getText());
                if (coordinador.actualizarCargo(cargo)) {
                    tablaCargos.setModel(new CargoTableModel(coordinador.cargaListaCargos()));
                    limpiarDatosCargo();
                    JOptionPane.showMessageDialog(this, "Cargo actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un cargo para actualizar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}