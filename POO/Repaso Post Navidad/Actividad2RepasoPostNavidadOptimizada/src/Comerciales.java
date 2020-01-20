import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Comerciales {
    private ArrayList<Comercial> comerciales;

    public Comerciales (){
        comerciales = new ArrayList<Comercial>();
    }

    public List<Comercial> obtenerTodosComerciales() {
        return comerciales;
    }

    public void añadirComercial(Comercial comercial) {
        comerciales.add(comercial);
    }

    public List<Comercial> obtenerComercialesConVentas(int ventas) {
        ArrayList<Comercial> result = new ArrayList<>();
        Iterator<Comercial> it = comerciales.iterator();
        while (it.hasNext()) {
            Comercial com = it.next();
            if (com.tieneVenta(ventas)) {
                result.add(com);
            }
        }
        return result;
    }
}
