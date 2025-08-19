package view.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import controller.Coordinador;
import view.gui.Paneles.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    @SuppressWarnings("unused")
    private Coordinador coordinador;
	private JPanel panelPrincipal, panelMenu;
	public JTabbedPane panelPestañas;
	private JButton btnUsuarios, btnEmpleados, btnArea, btnCargo, btnCerrar;
    private PanelHome panelHome;
    private PanelUsuarios panelUsuarios;
    public PanelEmpleados panelEmpleados;
    public PanelAreas panelAreas;
    public PanelCargos panelCargos;
	
	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		// Panel Principal //
        panelPrincipal = new JPanel();
        panelPrincipal.setBounds(0, 0, 984, 511);
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new Color(255, 255, 255));
        panelPrincipal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        getContentPane().add(panelPrincipal);

        // Panel de Pestañas //
        panelPestañas = new JTabbedPane(JTabbedPane.TOP);
        panelPestañas.setBackground(new Color(244, 244, 244));
        panelPestañas.setBounds(205, 11, 769, 489);
        panelPrincipal.add(panelPestañas);
        
        // Paneles //
        panelMenu = new JPanel();
        panelMenu.setBounds(0, 0, 200, 511);
        panelMenu.setLayout(null);
        panelMenu.setBackground(new Color(102, 102, 204));
        panelMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panelPrincipal.add(panelMenu);
        
        panelHome = new PanelHome();
        panelPestañas.addTab("Home", null, panelHome, null);
        
        panelUsuarios = new PanelUsuarios();
        panelPestañas.addTab("Usuarios", null, panelUsuarios, null);

        panelEmpleados = new PanelEmpleados();
        panelPestañas.addTab("Empleados", null, panelEmpleados, null);
        
        panelAreas = new PanelAreas();
        panelPestañas.addTab("Area", null, panelAreas, null);
        
        panelCargos = new PanelCargos();
        panelPestañas.addTab("Cargo", null, panelCargos, null);

        // Etiquetas //
        
        // Botones //
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

        // Configuración de la ventana //
        setTitle("Menu Principal");
        //setIconImage();
		setSize(1000, 550);
		setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        panelHome.setCoordinador(coordinador);
        panelUsuarios.setCoordinador(coordinador);
        panelEmpleados.setCoordinador(coordinador);
        panelAreas.setCoordinador(coordinador);
        panelCargos.setCoordinador(coordinador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUsuarios) {
			panelPestañas.setSelectedComponent(panelUsuarios);
        } else if (e.getSource() == btnEmpleados) {
        	panelPestañas.setSelectedComponent(panelEmpleados);
        } else if (e.getSource() == btnArea) {
        	panelPestañas.setSelectedComponent(panelAreas);
            panelAreas.mostrarTablaAreas();
            panelAreas.limpiarDatosArea();
        } else if (e.getSource() == btnCargo) {
        	panelPestañas.setSelectedComponent(panelCargos); 
            panelCargos.mostrarTablaCargos();
            panelCargos.limpiarDatosCargo();
        } else if (e.getSource() == btnCerrar) {
            dispose();
        }
    }
}