package controller;

import model.Procesos;
import model.dao.DaoCargo;
import model.dao.DaoUsuario;
import view.gui.Login;
import view.gui.VentanaPrincipal;

public class App {
    
    public void iniciarSistema() {
        // Instanciar Clases
    	Login login = new Login();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Coordinador coordinador = new Coordinador();
		Procesos procesos = new Procesos();
		DaoUsuario daoUsuario = new DaoUsuario();
		DaoCargo daoCargo = new DaoCargo();
		
		// Relacionar clases con el coordinador
		login.setCoordinador(coordinador);
		ventanaPrincipal.setCoordinador(coordinador);
		procesos.setCoordinador(coordinador);
		daoUsuario.setCoordinador(coordinador);
		daoCargo.setCoordinador(coordinador);
		
		// Relacionar el coordinador con las clases
		coordinador.setLogin(login);
		coordinador.setVentanaPrincipal(ventanaPrincipal);
		coordinador.setDaoU(daoUsuario);
		coordinador.setProcesos(procesos);
		coordinador.setDaoCargo(daoCargo);
    }
}