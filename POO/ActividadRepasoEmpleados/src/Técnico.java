public class Técnico extends Empleado {
    public Técnico(String dni, String nombre) {
        super(dni, nombre);
        super.setSueldoBase(900.0);
    }
}
