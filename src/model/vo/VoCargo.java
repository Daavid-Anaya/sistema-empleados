package model.vo;

public class VoCargo {
    private int id;
    private String nombre;
    private double remuneracion;

    // Constructores
    public VoCargo() {

    }

    public VoCargo(int id, String nombre, double remuneracion) {
        this.id = id;
        this.nombre = nombre;
        this.remuneracion = remuneracion;
    }

    // Metodos getters and setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRemuneracion(double remuneracion) {
        this.remuneracion = remuneracion;
    }
}