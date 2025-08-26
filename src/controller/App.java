package controller;

import model.Validaciones;
import model.dao.DaoArea;
import model.dao.DaoCargo;
import model.dao.DaoEmpleado;
import model.dao.DaoNomina;
import model.dao.DaoUsuario;
import view.gui.Login;
import view.gui.VentanaPrincipal;

public class App {
    
    public void iniciarSistema() {
        // Instanciar Clases
    	Login login = new Login();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Coordinador coordinador = new Coordinador();
		Validaciones validaciones = new Validaciones();
		DaoUsuario daoUsuario = new DaoUsuario();
		DaoArea daoArea = new DaoArea();
		DaoCargo daoCargo = new DaoCargo();
		DaoEmpleado daoEmpleado = new DaoEmpleado();
		DaoNomina daoNomina = new DaoNomina();

		// Relacionar clases con el coordinador
		login.setCoordinador(coordinador);
		ventanaPrincipal.setCoordinador(coordinador);
		validaciones.setCoordinador(coordinador);
		daoUsuario.setCoordinador(coordinador);
		daoArea.setCoordinador(coordinador);
		daoCargo.setCoordinador(coordinador);
		daoEmpleado.setCoordinador(coordinador);
		daoNomina.setCoordinador(coordinador);
		
		// Relacionar el coordinador con las clases
		coordinador.setLogin(login);
		coordinador.setVentanaPrincipal(ventanaPrincipal);
		coordinador.setValidaciones(validaciones);
		coordinador.setDaoUsuario(daoUsuario);
		coordinador.setDaoArea(daoArea);
		coordinador.setDaoCargo(daoCargo);
		coordinador.setDaoEmpleado(daoEmpleado);
		coordinador.setDaoNomina(daoNomina);
    }
}