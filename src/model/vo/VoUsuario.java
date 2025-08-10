package model.vo;

public class VoUsuario {
    // Atributos
    private int idUsuario;
    private String nombreUsuario;
    private String usuario;
    private String contrasena;

    // Constructores
    public VoUsuario() {

    }

    public VoUsuario(int idUsuario, String nombreUsuario, String usuario, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Metodos getters and setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}