import java.util.Comparator;

public class ComparadorAlfabetico implements Comparator<Invitado> {

    public int compare(Invitado invitado, Invitado inv){
        return invitado.getApellidos().compareTo(inv.getApellidos());
    }
}
