public class Producto {

    private int id;
    private String nombre;
    private String tipo;
    private String descripcion;
    private double precio;

    public Producto(int id, String nombre, String tipo, String descripcion, double precio){
        this.id=id;
        this.nombre=nombre;
        this.tipo=tipo;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + descripcion + " - " + precio;
    }
}
