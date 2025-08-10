package controller;

import model.Procesos;
import model.dao.DaoUsuario;

public class Coordinador {
	private Procesos procesos;
	private DaoUsuario daoUsuario;
	
	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}

	public void setDaoU(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
		return daoUsuario.validarUsuarioContraseña(usuario, contraseña);
	}

	public boolean verificaCamposVacios(String usuario, char[] contraseña) {
		return procesos.verificaCamposVacios(usuario, contraseña);
	}
}