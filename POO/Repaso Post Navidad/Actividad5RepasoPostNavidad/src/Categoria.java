import java.util.ArrayList;

public class Categoria {

    private String nombre;
    private ArrayList<Tarea> tareas;

    public Categoria (String nombre){
        this.nombre=nombre;
        tareas=new ArrayList<Tarea>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirTareaACategoria(Tarea tarea){
        tareas.add(tarea);
    }

    public ArrayList<Tarea> getTareas (){
        return tareas;
    }

    @Override
    public String toString() {
        return "Categoria " + nombre + " tiene las siguientes tareas: " + tareas;
    }
}
