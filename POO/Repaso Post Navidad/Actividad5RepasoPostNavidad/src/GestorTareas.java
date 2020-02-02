import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class GestorTareas {
    public ArrayList<Categoria> listaDeCategoriasConTareas;
    public ArrayList<Tarea> listaTareasCompletadas;

    public GestorTareas(){
        listaTareasCompletadas = new ArrayList<Tarea>();
        listaDeCategoriasConTareas = new ArrayList<Categoria>();
    }

    public void completarTarea(String nombre){
        listaTareasCompletadas.add(buscarTareaPorNombre(nombre));
        int indiceABorrar=-1;
        Tarea tareaTemporal;
        Categoria categoria=null;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            Iterator<Tarea> it2=categoriaTemporal.getTareas().iterator();
            while (it2.hasNext()){
                tareaTemporal=it2.next();
                if(tareaTemporal.getNombre().equals(nombre)){
                    indiceABorrar=categoriaTemporal.getTareas().indexOf(tareaTemporal);
                    categoria=categoriaTemporal;
                }
            }
        }
        categoria.getTareas().remove(indiceABorrar);
    }

    public ArrayList<Tarea> tareasEnUnaFecha(LocalDate fecha){
        ArrayList<Tarea> tareasEnFechaBuscada = new ArrayList<>();
        Tarea tareaTemporal;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            Iterator<Tarea> it2=categoriaTemporal.getTareas().iterator();
            while (it2.hasNext()){
                tareaTemporal=it2.next();
                if(tareaTemporal.getFechaLimite().equals(fecha)){
                    tareasEnFechaBuscada.add(tareaTemporal);
                }
            }
        }
        return tareasEnFechaBuscada;
    }

    public ArrayList<Tarea> tareasEnTiempo(){
        LocalDate fechaActual = LocalDate.now();
        ArrayList<Tarea> tareasEnTiempo = new ArrayList<>();
        Tarea tareaTemporal;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            Iterator<Tarea> it2=categoriaTemporal.getTareas().iterator();
            while (it2.hasNext()){
                tareaTemporal=it2.next();
                if(tareaTemporal.getFechaLimite().compareTo(fechaActual) > -1){
                    tareasEnTiempo.add(tareaTemporal);
                }
            }
        }
        return tareasEnTiempo;
    }

    public ArrayList<Tarea> tareasRetrasadas(){
        LocalDate fechaActual = LocalDate.now();
        ArrayList<Tarea> tareasRetrasadas = new ArrayList<>();
        Tarea tareaTemporal;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            Iterator<Tarea> it2=categoriaTemporal.getTareas().iterator();
            while (it2.hasNext()){
                tareaTemporal=it2.next();
                if(tareaTemporal.getFechaLimite().compareTo(fechaActual) < 0){
                    tareasRetrasadas.add(tareaTemporal);
                }
            }
        }
        return tareasRetrasadas;
    }

    public void añadirCategoria(String nombre){
        if(buscarCategoriaPorNombre(nombre)==null){
            listaDeCategoriasConTareas.add(new Categoria(nombre));
        }
        else {
            System.out.println("La categoría ya existe y por tanto no se creará una nueva");
        }
    }

    public Categoria buscarCategoriaPorNombre(String nombre){
        Categoria categoria=null;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            if(categoriaTemporal.getNombre().equals(nombre)){
                categoria=categoriaTemporal;
            }
        }
        return categoria;
    }

    public Tarea buscarTareaPorNombre(String nombre){
        Tarea tarea=null;
        Tarea tareaTemporal;
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            Iterator<Tarea> it2=categoriaTemporal.getTareas().iterator();
            while (it2.hasNext()){
                tareaTemporal=it2.next();
                if(tareaTemporal.getNombre().equals(nombre)){
                    tarea=tareaTemporal;
                }
            }
        }
        return tarea;
    }

    public String listaNombreCategoriasToString() {
        String mensaje="";
        Categoria categoriaTemporal;
        Iterator<Categoria> it= listaDeCategoriasConTareas.iterator();
        while (it.hasNext()){
            categoriaTemporal=it.next();
            mensaje = mensaje + ("- " + categoriaTemporal.getNombre() + "\n");
        }
        return mensaje;
    }

    public String listaTareasDeTodasLasCategoriasToString(){
        return listaDeCategoriasConTareas.toString();
    }

}
