package controller;

import java.util.List;

import model.Procesos;
import model.dao.DaoCargo;
import model.dao.DaoUsuario;
import model.vo.VoCargo;
import view.gui.Login;
import view.gui.MenuPrincipal;

public class Coordinador {
	@SuppressWarnings("unused")
	private Login login;
	private MenuPrincipal menuPrincipal;
	private DaoUsuario daoUsuario;
	private DaoCargo daoCargo;
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

	public void setDaoCargo(DaoCargo daoCargo) {
		this.daoCargo = daoCargo;
		
	}
	
	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}
	
	public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
		return daoUsuario.validarUsuarioContraseña(usuario, contraseña);
	}

	public boolean insertarCargo(VoCargo c) {
		return daoCargo.insertarCargo(c);
	}

	public boolean verificaCamposVacios(String usuario, char[] contraseña) {
		return procesos.verificaCamposVacios(usuario, contraseña);
	}

	public void menuPrincipalVisible() {
		menuPrincipal.setVisible(true);
	}

    public List<VoCargo> cargaListaCargos() {
		return daoCargo.cargaListaCargos();
    }

    public boolean actualizarCargo(VoCargo cargo) {
        return daoCargo.actualizarCargo(cargo);
    }
}