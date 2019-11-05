import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invitado {
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String fechaNacimientoConFormato;

    public Invitado(String apellidos, String nombre, String fechaNacimientoConFormato) throws ParseException {

        this.apellidos=apellidos;
        this.nombre=nombre;
        fechaNacimiento=formato.parse(fechaNacimientoConFormato);
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre +
                ", Apellidos= " + apellidos +
                ", Fecha de nacimiento= " + formato.format(fechaNacimiento) + "\n";
    }
}
