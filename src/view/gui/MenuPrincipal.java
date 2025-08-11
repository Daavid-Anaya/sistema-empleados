package view.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controller.Coordinador;
import model.vo.VoCargo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MenuPrincipal extends JFrame implements ActionListener{
    private Coordinador coordinador;
	private JPanel panelPrincipal, panelMenu, panelHome, panelUsuarios, panelEmpleados, panelCargo, panelArea;
	private JTabbedPane panelPestañas;
	private JButton btnUsuarios, btnEmpleados, btnArea, btnCargo, btnCerrar, btnRegistrar;
    private JLabel lbl_Id, lblNombre;
    private JTextField txtFNombre, txtFId;
	
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
        lbl_Id = new JLabel("ID:");
        lbl_Id.setFont(new Font("Consolas", Font.BOLD, 13));
        lbl_Id.setBounds(40, 37, 50, 20);
        panelCargo.add(lbl_Id);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Consolas", Font.BOLD, 13));
        lblNombre.setBounds(40, 82, 50, 20);
        panelCargo.add(lblNombre);

        // Campo de texto //
        // Campo texto dentro de Panel Cargo
        txtFNombre = new JTextField();
        txtFNombre.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFNombre.setBounds(100, 80, 120, 25);
        panelCargo.add(txtFNombre);
        txtFNombre.setColumns(10);
        
        txtFId = new JTextField();
        txtFId.setEditable(false);
        txtFId.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtFId.setBounds(100, 35, 120, 25);
        panelCargo.add(txtFId);
        txtFId.setColumns(10);
        
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
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setFont(new Font("Consolas", Font.PLAIN, 13));
        btnRegistrar.setBounds(118, 127, 100, 25);
        btnRegistrar.setMnemonic('r');
        btnRegistrar.addActionListener(this);
        panelCargo.add(btnRegistrar);
        
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
        txtFNombre.setText("");
        txtFId.setText("");
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
        } else if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == btnRegistrar) {
            VoCargo cargo = new VoCargo();
        	cargo.setNombre(txtFNombre.getText());
        	if (coordinador.insertar(cargo)) {
        		JOptionPane.showMessageDialog(this, "Cargo registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		JOptionPane.showMessageDialog(this, "Error al registrar el cargo.", "Error", JOptionPane.ERROR_MESSAGE);
        	}
            limpiarDatosCargo();
        }
    }
}