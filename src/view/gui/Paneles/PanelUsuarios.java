package view.gui.Paneles;

import javax.swing.JPanel;

import controller.Coordinador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUsuarios extends JPanel implements ActionListener {
    @SuppressWarnings("unused")
    private Coordinador coordinador;

    private static final long serialVersionUID = 1L;

    public PanelUsuarios() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setBackground(new Color(255, 255, 255));
        setLayout(null);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
