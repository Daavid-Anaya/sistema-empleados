package controller;

import java.util.List;

import model.Validaciones;
import model.dao.DaoArea;
import model.dao.DaoCargo;
import model.dao.DaoEmpleado;
import model.dao.DaoNomina;
import model.dao.DaoUsuario;
import model.vo.VoArea;
import model.vo.VoCargo;
import model.vo.VoEmpleado;
import model.vo.VoNomina;
import view.gui.Login;
import view.gui.VentanaPrincipal;

public class Coordinador {
	@SuppressWarnings("unused")
	private Login login;
	private VentanaPrincipal ventanaPrincipal;
	private DaoUsuario daoUsuario;
	private DaoArea daoArea;
	private DaoCargo daoCargo;
	private DaoEmpleado daoEmpleado;
	private DaoNomina daoNomina;
	private Validaciones validaciones;
	
	public void setLogin(Login login) {
		this.login = login;
	}

	public void setVentanaPrincipal(VentanaPrincipal menuPrincipal) {
        this.ventanaPrincipal = menuPrincipal;
    }

	public void setDaoUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public void setDaoArea(DaoArea daoArea) {
		this.daoArea = daoArea;
	}

	public void setDaoCargo(DaoCargo daoCargo) {
		this.daoCargo = daoCargo;	
	}

	public void setDaoEmpleado(DaoEmpleado daoEmpleado) {
		this.daoEmpleado = daoEmpleado;
	}

	public void setDaoNomina(DaoNomina daoNomina) {
		this.daoNomina = daoNomina;
	}

	public void setValidaciones(Validaciones validaciones) {
		this.validaciones = validaciones;
	}

	public void menuPrincipalVisible() {
		ventanaPrincipal.setVisible(true);
	}
	
	public boolean validarUsuarioContraseña(String usuario, char[] contraseña) {
		return daoUsuario.validarUsuarioContraseña(usuario, contraseña);
	}

	public boolean verificaCamposVacios(String usuario, char[] contraseña) {
		return validaciones.verificaCamposVacios(usuario, contraseña);
	}

	public boolean verificaCamposVaciosEmpleado(String nombre, String apellido, String documento,
	String idArea, String idCargo, String telefono, String correo) {
		return validaciones.verificaCamposVaciosEmpleado(nombre, apellido, documento, idArea, idCargo, telefono, correo);
	}

	public boolean verificaCamposVaciosCargo(String id, String nombre, String remuneracion) {
		return validaciones.verificaCamposVaciosCargo(id, nombre, remuneracion);
	}

	public boolean verificarCamposVaciosNomina(String dias, String total, String idEmpleado, String idCargo) {
		return validaciones.verificarCamposVaciosNomina(dias, total, idEmpleado, idCargo);
	}

	public boolean existeIdEmpleado(int id) {
        return daoEmpleado.existeIdEmpleado(id);
    }

	public boolean existeNombreArea(String nombre) {
		return daoArea.existeNombreArea(nombre);
	}

	public boolean existeIdArea(int id) {
		return daoArea.existeIdArea(id);
	}

	public boolean existeNombreCargo(String nombre) {
		return daoCargo.existeNombreCargo(nombre);
	}

	public boolean existeIdCargo(int id) {
		return daoCargo.existeIdCargo(id);
	}

	public void irArea() {
		ventanaPrincipal.panelPestañas.setSelectedComponent(ventanaPrincipal.panelAreas);
		ventanaPrincipal.panelAreas.btnEnviar.setEnabled(true);
		ventanaPrincipal.panelAreas.mostrarTablaAreas();
	}
	
	public void irCargo() {
		ventanaPrincipal.panelPestañas.setSelectedComponent(ventanaPrincipal.panelCargos);
		ventanaPrincipal.panelCargos.btnEnviar.setEnabled(true);
		ventanaPrincipal.panelCargos.mostrarTablaCargos();
	}

    public List<VoCargo> cargaListaCargos() {
		return daoCargo.cargaListaCargos();
    }

	public VoCargo buscarCargo(String id) {
		return daoCargo.buscarCargo(id);
	}

	public boolean insertarCargo(String nombre, double remuneracion) {
		return daoCargo.insertarCargo(nombre, remuneracion);
	}

    public boolean actualizarCargo(VoCargo cargo) {
        return daoCargo.actualizarCargo(cargo);
    }

    public boolean eliminarCargo(int id) {
        return daoCargo.eliminarCargo(id);
    }

	public List<VoArea> cargaListaAreas() {
		return daoArea.cargaListaAreas();
    }

	public VoArea buscarArea(String id) {
		return daoArea.buscarArea(id);
	}

	public boolean insertarArea(String nombre) {
		return daoArea.insertarArea(nombre);
	}

    public boolean actualizarArea(VoArea a) {
        return daoArea.actualizarArea(a);
    }

    public boolean eliminarArea(int id) {
        return daoArea.eliminarArea(id);
    }

	public void enviarArea(VoArea area) {
    	ventanaPrincipal.panelEmpleados.txtIdArea.setText(String.valueOf(area.getId()));
    	ventanaPrincipal.panelEmpleados.txtArea.setText(area.getNombre());
    	ventanaPrincipal.panelPestañas.setSelectedComponent(ventanaPrincipal.panelEmpleados);
		ventanaPrincipal.panelAreas.limpiarDatosArea();
	}
    
    public void enviarCargo(VoCargo cargo) {
    	ventanaPrincipal.panelEmpleados.txtIdCargo.setText(cargo.getId()+"");
    	ventanaPrincipal.panelEmpleados.txtCargo.setText(cargo.getNombre());
    	ventanaPrincipal.panelPestañas.setSelectedComponent(ventanaPrincipal.panelEmpleados);
		ventanaPrincipal.panelCargos.limpiarDatosCargo();
	}

	public List<VoEmpleado> cargaListaEmpleados() {
		return daoEmpleado.cargaListEmpleados();
    }

	public VoEmpleado buscarEmpleado(int id) {
		return daoEmpleado.buscarEmpleado(id);
	}

	public VoEmpleado buscarEmpleadoDoc(String documento) {
		return daoEmpleado.buscarEmpleadoDoc(documento);
	}

	public boolean insertarEmpleado(VoEmpleado e) {
		return daoEmpleado.insertarEmpleado(e);
	}

    public boolean actualizarEmpleado(VoEmpleado e) {
        return daoEmpleado.actualizarEmpleado(e);
    }

    public boolean eliminarEmpleado(int id) {
        return daoEmpleado.eliminarEmpleado(id);
    }

	public boolean insertarNomina(VoNomina nomina) {
		return daoNomina.insertarNomina(nomina);
	}

	public boolean actualizarNomina(VoNomina nomina) {
		return daoNomina.actualizarNomina(nomina);
	}

    public List<VoNomina> cargaListaNominas() {
        return daoNomina.cargaListaNominas();
    }
}