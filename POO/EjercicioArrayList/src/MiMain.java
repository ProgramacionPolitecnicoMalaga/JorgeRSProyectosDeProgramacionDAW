import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class MiMain {

    public static int difAños (Invitado invitado, Date fecha){
        int diferenciaAños= (int) ((fecha.getTime()-invitado.getFechaNacimiento().getTime()) / (60 * 60 * 1000 * 24 * 30.41666666 * 12));
        return diferenciaAños;
    }

    public static boolean mayoriaEdad (int diferenciaAños){
        if (diferenciaAños<18) {
            return true;
        }else return false;
    }
    public static void main(String[] args) {
        Date fechaActual=new Date();
        try {
            ArrayList<Invitado> listaInvitados = new ArrayList<>();
            listaInvitados.add(new Invitado("Macias Perez", "Noelia", "12/12/1986"));
            listaInvitados.add(new Invitado("Lopez Gutierrez", "Pablo", "12/12/1980"));
            listaInvitados.add(new Invitado("Garcia Ruano", "Celia", "12/12/2010"));

            listaInvitados.removeIf(inv -> mayoriaEdad(difAños(inv, fechaActual)));
            listaInvitados.sort(new ComparadorAlfabetico());
            Iterator<Invitado> iterador = listaInvitados.iterator();
            while (iterador.hasNext()) {
                Invitado invitadotemp = iterador.next();
                System.out.println(invitadotemp);
            }

        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
