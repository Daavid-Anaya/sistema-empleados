package controller;

import java.util.List;

import model.Procesos;
import model.dao.DaoCargo;
import model.dao.DaoUsuario;
import model.vo.VoCargo;
import view.gui.Login;
import view.gui.VentanaPrincipal;

public class Coordinador {
	@SuppressWarnings("unused")
	private Login login;
	private VentanaPrincipal ventanaPrincipal;
	private DaoUsuario daoUsuario;
	private DaoCargo daoCargo;
	private Procesos procesos;
	
	public void setLogin(Login login) {
		this.login = login;
	}

	public void setVentanaPrincipal(VentanaPrincipal menuPrincipal) {
        this.ventanaPrincipal = menuPrincipal;
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

	public void menuPrincipalVisible() {
		ventanaPrincipal.setVisible(true);
	}
	
	public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
		return daoUsuario.validarUsuarioContraseña(usuario, contraseña);
	}

	public boolean verificaCamposVacios(String usuario, char[] contraseña) {
		return procesos.verificaCamposVacios(usuario, contraseña);
	}

    public List<VoCargo> cargaListaCargos() {
		return daoCargo.cargaListaCargos();
    }

	public VoCargo buscarCargo(VoCargo cargo) {
		return daoCargo.buscarCargo(cargo);
	}

	public boolean insertarCargo(VoCargo c) {
		return daoCargo.insertarCargo(c);
	}

    public boolean actualizarCargo(VoCargo cargo) {
        return daoCargo.actualizarCargo(cargo);
    }

    public boolean eliminarCargo(VoCargo cargo) {
        return daoCargo.eliminarCargo(cargo);
    }
}