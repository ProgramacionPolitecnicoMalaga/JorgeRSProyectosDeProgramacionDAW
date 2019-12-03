import java.util.ArrayList;

public class ListaActividades {

    private static ArrayList<Actividad> listaActividades;

    public ListaActividades(){
        listaActividades=new ArrayList<>();
    }

    public void introducirActividad(Actividad actividad){
        listaActividades.add(actividad);
    }

    public ArrayList<Actividad> getListaActividades() {
        return listaActividades;
    }
}
