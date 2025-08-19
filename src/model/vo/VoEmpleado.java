package model.vo;

public class VoEmpleado {
    // Atributos
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private String documento;
    private int idArea;
    private int idCargo;
    private String telefono;
    private String correo;

    // Constructores
    public VoEmpleado() {

    }

    public VoEmpleado(String nombre, String apellido, String tipoDoc, String documento, int idArea, int idCargo, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.idArea = idArea;
        this.idCargo = idCargo;
        this.telefono = telefono;
        this.correo = correo;
    }

    public VoEmpleado(int idEmpleado, String nombre, String apellido, String tipoDoc, String documento, int idArea, int idCargo, String telefono, String correo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.idArea = idArea;
        this.idCargo = idCargo;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Metodos getters and setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public int getIdArea() {
        return idArea;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}