public class JefeDeOperaciones extends Empleado {
    public JefeDeOperaciones(String dni, String nombre) {
        super(dni, nombre);
        super.setSueldoBase(3500.0);
    }
}
