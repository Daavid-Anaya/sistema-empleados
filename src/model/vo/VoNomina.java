package model.vo;

import java.sql.Date;

public class VoNomina {
    int id;
    Date fecha;
    int diasLaborados;
    double total;
    int idEmpleado;
    int idCargo;

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

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
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

    public int getIdCargo() {
        return idCargo;
    }   

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
}
