package controller;

import model.Procesos;
import model.dao.DaoUsuario;
import view.gui.Login;
import view.gui.MenuPrincipal;

public class Coordinador {
	@SuppressWarnings("unused")
	private Login login;
	private MenuPrincipal menuPrincipal;
	private DaoUsuario daoUsuario;
	private Procesos procesos;
	
	public void setLogin(Login login) {
		this.login = login;
	}

	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }

	public void setDaoU(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}
	
	public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
		return daoUsuario.validarUsuarioContraseña(usuario, contraseña);
	}

	public boolean verificaCamposVacios(String usuario, char[] contraseña) {
		return procesos.verificaCamposVacios(usuario, contraseña);
	}

	public void menuPrincipalVisible() {
		menuPrincipal.setVisible(true);
	}
}