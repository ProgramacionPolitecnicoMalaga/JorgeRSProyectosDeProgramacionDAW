public class Programador extends Empleado {
    public Programador(String dni, String nombre) {
        super(dni, nombre);
        super.setSueldoBase(1800.0);
    }
}
