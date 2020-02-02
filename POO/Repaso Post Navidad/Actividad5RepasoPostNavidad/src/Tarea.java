import java.time.LocalDate;

public class Tarea {

    private String nombre;
    private LocalDate fechaLimite;
    private String descripcion;

    public Tarea (String nombre, LocalDate fechaLimite, String descripcion){
        this.nombre=nombre;
        this.fechaLimite=fechaLimite;
        this.descripcion=descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nTarea " + nombre + "/" + fechaLimite +
                "/" + descripcion;
    }
}
