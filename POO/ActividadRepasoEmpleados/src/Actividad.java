public class Actividad {
    double horasRealizadas;
    String descripcion;
    Empleado empleado;
    Proyecto proyecto;

    public Actividad(double horasRealizadas, String descripcion, Empleado empleado, Proyecto proyecto) {
        this.horasRealizadas = horasRealizadas;
        this.descripcion = descripcion;
        this.empleado=empleado;
        this.proyecto=proyecto;
    }

    public double getHorasRealizadas() {
        return horasRealizadas;
    }

    public void setHorasRealizadas(double horasRealizadas) {
        this.horasRealizadas = horasRealizadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
