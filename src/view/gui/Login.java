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

import javax.swing.JButton;

public class Login extends JFrame {
	private Coordinador coordinador;
	private JPanel panelLeft, panelRight;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JButton btnIniciar;
	
	private static final long serialVersionUID = 1L;

	public Login() {
        iniciarComponentes();
    }

    @SuppressWarnings("unused")
    private void iniciarComponentes() {
        try {
        	FlatArcOrangeIJTheme.setup();
        	// Paneles //
            panelLeft = new JPanel();
            panelLeft.setBackground(new Color(102, 102, 204));
            panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panelLeft.setBounds(0, 0, 220, 211);
            panelLeft.setLayout(null);
            
            panelRight = new JPanel();
            panelRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panelRight.setBounds(220, 0, 264, 211);
            panelRight.setLayout(null);
            
            // Etiquetas //
            JLabel lblLogin = new JLabel("Login");
            lblLogin.setFont(new Font("Consolas", Font.PLAIN, 14));
            lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
            lblLogin.setBounds(105, 14, 50, 25);
            panelRight.add(lblLogin);
            
            JLabel lblUsuario = new JLabel("Usuario");
            lblUsuario.setFont(new Font("Consolas", Font.PLAIN, 13));
            lblUsuario.setBounds(30, 59, 50, 25);
            panelRight.add(lblUsuario);
            
            JLabel lblContraseña = new JLabel("Contraseña");
            lblContraseña.setFont(new Font("Consolas", Font.PLAIN, 13));
            lblContraseña.setBounds(30, 109, 70, 25);
            panelRight.add(lblContraseña);
            
            // Campo de texto //
            txtUsuario = new JTextField();
            txtUsuario.setBounds(108, 54, 120, 30);
            panelRight.add(txtUsuario);
            
            // Campo Contraseña //
            passwordField = new JPasswordField();
            passwordField.setBounds(108, 106, 120, 30);
            panelRight.add(passwordField);
            
            // Botones //
            btnIniciar = new JButton("Iniciar");
            btnIniciar.setBounds(108, 156, 120, 25); 
            panelRight.add(btnIniciar);
            btnIniciar.addActionListener(e -> {
            	if(coordinador.verificaCamposVacios(txtUsuario.getText(), passwordField.getPassword())) {
                	if(coordinador.validarUsuarioContraseña(txtUsuario.getText(), passwordField.getPassword())) {
                		JOptionPane.showMessageDialog(null, "Bienvenido al Sistema", "Inicio", JOptionPane.INFORMATION_MESSAGE);
                	} else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
            	} else {
                    JOptionPane.showMessageDialog(null, "Los campos de usuario y contraseña no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            });
            
            setResizable(false);
            setVisible(true);
            setTitle("Login");
            setSize(500, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            getContentPane().setLayout(null);
            //setIconImage();
            getContentPane().add(panelLeft);
            getContentPane().add(panelRight);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al iniciar la interfaz: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}