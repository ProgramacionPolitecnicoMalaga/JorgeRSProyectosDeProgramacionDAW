public class Administrador extends Empleado {
    public Administrador(String dni, String nombre) {
        super(dni, nombre);
        super.setSueldoBase(1400.0);
    }
}
