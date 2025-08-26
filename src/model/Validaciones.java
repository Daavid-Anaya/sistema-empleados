package model;

import java.util.stream.Stream;

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

	public boolean verificaCamposVaciosEmpleado(String nombre, String apellido, String documento,
	String idArea, String idCargo, String telefono, String correo) {
		return Stream.of(nombre, apellido, documento, idArea, idCargo, telefono, correo).allMatch(s -> s != null && !s.trim().isEmpty());
	}

	public boolean verificaCamposVaciosCargo(String id, String nombre, String remuneracion) {
		return !id.isEmpty() && !nombre.isEmpty() && !remuneracion.isEmpty() && Double.parseDouble(remuneracion) > 0;
	}

	public boolean verificarCamposVaciosNomina(String dias, String total, String idEmpleado, String idCargo) {
		return Stream.of(dias, total, idEmpleado, idCargo).allMatch(s -> s != null && !s.trim().isEmpty());
	}
}