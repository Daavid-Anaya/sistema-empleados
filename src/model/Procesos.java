package model;

import controller.Coordinador;

public class Procesos {
	@SuppressWarnings("unused")
	private Coordinador coordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public boolean verificaCamposVacios(String usuario, char[] password) {
		if (!usuario.isEmpty() && password.length > 0) {
			return true;
        } else {
            return false;
        }
	}

}