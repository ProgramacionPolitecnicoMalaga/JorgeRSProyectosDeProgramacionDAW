public class Proyecto {
    private String nombre;
    private String departamento;
    private double factProductividad;
    private String descripcion;

    public Proyecto(String nombre, String departamento, double factProductividad, String descripcion) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.factProductividad = factProductividad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getFactProductividad() {
        return factProductividad;
    }

    public void setFactProductividad(double factProductividad) {
        this.factProductividad = factProductividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
