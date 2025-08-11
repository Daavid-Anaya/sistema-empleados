package view.gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import controller.Coordinador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class Login extends JFrame {
	private Coordinador coordinador;
	private JLayeredPane layeredPane;
	private JPanel panelLeft, panelRight;
	private JLabel lblLogin, lblUsuario, lblContraseña, lblIconEmp, lblSistemE;
	private JPasswordField passwordField;
	private JTextField txtUsuario;
	private JButton btnIniciar, btnCerrar;
	
	private static final long serialVersionUID = 1L;

	public Login() {
        iniciarComponentes();
    }

    @SuppressWarnings("unused")
    private void iniciarComponentes() {
        try {
        	FlatArcOrangeIJTheme.setup();
        	
        	// Panel de capas //
        	layeredPane = new JLayeredPane();
            layeredPane.setBounds(0, 0, 551, 220);
             
        	// Paneles //
            panelLeft = new JPanel();
            panelLeft.setBackground(new Color(102, 102, 204));
            panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panelLeft.setBounds(0, 0, 231, 221);
            panelLeft.setLayout(null);
            layeredPane.add(panelLeft);

            panelRight = new JPanel();
            panelRight.setBackground(new Color(244, 246, 247));
            panelRight.setBounds(230, 0, 321, 221);
            panelRight.setLayout(null);
            layeredPane.add(panelRight);
            
            // img //
            ImageIcon empleados = new ImageIcon("C:\\Users\\charly\\Programación\\Java\\Proyectos\\sistema-empleados\\resource\\empleados.png");
            Image imageEmpleados = empleados.getImage(); // Obtener el objeto Image
            Image resizedImageEmp = imageEmpleados.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH); // Redimensionar
            ImageIcon resizedIconEmp = new ImageIcon(resizedImageEmp); // Crear nuevo ImageIcon con la imagen redimensionada
            
            // Etiquetas //
            lblLogin = new JLabel("Login");
            lblLogin.setFont(new Font("Consolas", Font.BOLD, 18));
            lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
            lblLogin.setBounds(130, 20, 60, 25);
            panelRight.add(lblLogin);
            
            lblUsuario = new JLabel("Usuario");
            lblUsuario.setFont(new Font("Consolas", Font.BOLD, 13));
            lblUsuario.setBounds(30, 70, 50, 25);
            panelRight.add(lblUsuario);
            
            lblContraseña = new JLabel("Contraseña");
            lblContraseña.setFont(new Font("Consolas", Font.BOLD, 13));
            lblContraseña.setBounds(30, 120, 70, 25);
            panelRight.add(lblContraseña);
            
            lblSistemE = new JLabel("Sistema Empleados");
            lblSistemE.setHorizontalAlignment(SwingConstants.CENTER);
            lblSistemE.setFont(new Font("Consolas", Font.BOLD, 15));
            lblSistemE.setBounds(40, 196, 150, 14);
            panelLeft.add(lblSistemE);
            
            lblIconEmp = new JLabel(resizedIconEmp);
            lblIconEmp.setBounds(40, 30, 150, 150);
            panelLeft.add(lblIconEmp);
            
            // Campo de texto //
            txtUsuario = new JTextField();
            txtUsuario.setBounds(110, 65, 179, 30);
            txtUsuario.requestFocusInWindow();
            panelRight.add(txtUsuario);
            
            // Campo Contraseña //
            passwordField = new JPasswordField();
            passwordField.setBounds(110, 115, 179, 30);
            panelRight.add(passwordField);
            
            // Botones //
            btnIniciar = new JButton("Iniciar");
            btnIniciar.setBackground(new Color(135, 206, 250));
            btnIniciar.setForeground(Color.BLACK);
            btnIniciar.setFont(new Font("Consolas", Font.BOLD, 12));
            btnIniciar.setBounds(108, 165, 85, 30);
            btnIniciar.setMnemonic('i');
            panelRight.add(btnIniciar);
            btnIniciar.addActionListener(event -> {
            	if(coordinador.verificaCamposVacios(txtUsuario.getText(), passwordField.getPassword())) {
                	if(coordinador.validarUsuarioContraseña(txtUsuario.getText(), passwordField.getPassword())) {
                        JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
                        coordinador.menuPrincipalVisible();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
            	} else {
                    JOptionPane.showMessageDialog(null, "Los campos de usuario y contraseña no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            });
            
            btnCerrar = new JButton("Cerrar");
            btnCerrar.setBackground(new Color(255, 0, 0));
            btnCerrar.setForeground(Color.BLACK);
            btnCerrar.setFont(new Font("Consolas", Font.BOLD, 12));
            btnCerrar.setBounds(202, 165, 85, 30);
            btnCerrar.setMnemonic('c');   
            panelRight.add(btnCerrar);
            btnCerrar.addActionListener(event -> {
            	dispose();
            });
   
            // Configuración de la ventana //
            setUndecorated(true);
            setResizable(false);
            setVisible(true);
            //setTitle("Login");
            //setIconImage();
            setSize(551, 220);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            getContentPane().add(layeredPane);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al iniciar la interfaz: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}