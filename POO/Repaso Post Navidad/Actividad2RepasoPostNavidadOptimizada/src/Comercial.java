import java.util.ArrayList;

public class Comercial {
    private String nombre;
    private String apellidos;
    private Ventas ventasSemanales;

    public Comercial(String nombre, String apellidos, Ventas ventasSemanales){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.ventasSemanales=ventasSemanales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean tieneVenta(int venta) {
        return ventasSemanales.contiene(venta);
    }

    public float getPromedioVentas() {
        return ventasSemanales.promedio();
    }

    public Ventas getVentasSemanales(){
        return ventasSemanales;
    }

}
