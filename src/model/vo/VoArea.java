package model.vo;

public class VoArea {
    private int id;
    private String nombre;

    // Constructores
    public VoArea() {
        
    }

    public VoArea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public VoArea(String nombre) {
        this.nombre = nombre;
    }
    
    public VoArea(int id) {
        this.id = id;
    }

    // Métodos getters and setters
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