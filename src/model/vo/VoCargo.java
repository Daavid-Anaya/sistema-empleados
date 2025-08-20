package model.vo;

public class VoCargo {
    private int id;
    private String nombre;

    // Constructores
    public VoCargo() {

    }

    public VoCargo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Metodos getters and setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}