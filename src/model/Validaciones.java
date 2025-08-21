package model;

import controller.Coordinador;

public class Validaciones {
	@SuppressWarnings("unused")
	private Coordinador coordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public boolean verificaCamposVacios(String usuario, char[] password) {
		return !usuario.isEmpty() && password.length > 0;
	}

	public boolean verificaCamposVaciosEmpleado(String id, String nombre, String apellido, String tipoDoc, String documento,
	String idArea, String idCargo, String telefono, String correo) {
		return id.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !tipoDoc.isEmpty() && 
		!documento.isEmpty() && !idArea.isEmpty() && !idCargo.isEmpty() && !telefono.isEmpty() && !correo.isEmpty();
	}
}