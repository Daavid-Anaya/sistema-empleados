package model.vo;

import java.sql.Date;

public class VoNomina {
    int id;
    Date fecha;
    int diasLaborados;
    double total;
    int idEmpleado;
    String nombreEmpleado;
    String apellidoEmpleado;
    String documentoEmpleado;
    int idCargo;
    String nombreCargo;
    double remuneracion;

    public VoNomina() {

    }

    public VoNomina(int id, Date fecha, int diasLaborados, double total, int idEmpleado, int idCargo) {
        this.id = id;
        this.fecha = fecha;
        this.diasLaborados = diasLaborados;
        this.total = total;
        this.idEmpleado = idEmpleado;
        this.idCargo = idCargo;
    }

    public VoNomina(int id, Date fecha, int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String documentoEmpleado, int idCargo, String nombreCargo, double remuneracion, int diasLaborados, double total) {
        this.id = id;
        this.fecha = fecha;
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.documentoEmpleado = documentoEmpleado;
        this.idCargo = idCargo;
        this.nombreCargo = nombreCargo;
        this.remuneracion = remuneracion;
        this.diasLaborados = diasLaborados;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public double getTotal() {
        return total;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public String getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public int getIdCargo() {
        return idCargo;
    }   

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public void setDocumentoEmpleado(String documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
}
