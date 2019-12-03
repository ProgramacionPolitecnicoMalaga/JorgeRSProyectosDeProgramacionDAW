import java.util.ArrayList;
import java.util.Iterator;

public abstract class Empleado {
    private String dni;
    private String nombre;
    private double sueldoBase;
    private ListaActividades listaActividades;

    public Empleado(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBase=0.0;
        listaActividades = new ListaActividades();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getProductividad(ArrayList<Actividad> listaActividades){
        Iterator<Actividad> it = listaActividades.iterator();
        double productividad = 0;
        while (it.hasNext()) {
            Actividad actividad = it.next();
            if (actividad.getEmpleado() == this) {
                productividad += actividad.getProyecto().getFactProductividad()*actividad.getHorasRealizadas();
            }
        }
        return productividad;
    }

}