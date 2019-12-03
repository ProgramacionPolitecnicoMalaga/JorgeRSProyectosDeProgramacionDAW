public class JefeDeProyecto extends Empleado {

    public JefeDeProyecto(String dni, String nombre) {
        super(dni, nombre);
        super.setSueldoBase(2500.0);
    }
}
