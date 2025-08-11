package controller;

import model.Procesos;
import model.dao.DaoUsuario;
import view.gui.Login;
import view.gui.MenuPrincipal;

public class App {
    
    public void iniciarSistema() {
        // Instanciar Clases
    	Login login = new Login();
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		Coordinador coordinador = new Coordinador();
		Procesos procesos = new Procesos();
		DaoUsuario daoUsuario = new DaoUsuario();	
		
		// Relacionar clases con el coordinador
		login.setCoordinador(coordinador);
		menuPrincipal.setCoordinador(coordinador);
		procesos.setCoordinador(coordinador);
		daoUsuario.setCoordinador(coordinador);
		
		// Relacionar el coordinador con las clases
		coordinador.setLogin(login);
		coordinador.setMenuPrincipal(menuPrincipal);
		coordinador.setDaoU(daoUsuario);
		coordinador.setProcesos(procesos);
    }
}