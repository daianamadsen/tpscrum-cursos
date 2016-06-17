package entidades;

public class Tema {
    
    private int id;
    private String sigla;
    private String nombre;
    private String descripcion;
    
    public Tema() {
    }

    public Tema(String sigla, String nombre) {
        this.sigla = sigla;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
