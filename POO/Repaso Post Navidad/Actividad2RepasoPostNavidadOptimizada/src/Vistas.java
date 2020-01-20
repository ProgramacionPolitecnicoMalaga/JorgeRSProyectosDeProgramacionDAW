import java.util.*;

public class Vistas {

    public void listadoComerciales(List<Comercial> comerciales) {
        Iterator<Comercial> it = comerciales.iterator();
        while (it.hasNext()) {
            Comercial com = it.next();
            System.out.println("- " + com.getNombre());
        }
    }

    public void listadoPromedios(HashMap<String, Float> comPromedio) {
        List<Float> ventas = new ArrayList<>(comPromedio.values());
        Collections.sort(ventas);
        for (String comercial: comPromedio.keySet()) {
            float promedio = comPromedio.get(comercial);
            System.out.println(comercial + "\t\t\t" + promedio + ((promedio == ventas.get(ventas.size() - 1)) ? "\t\t\t*" : ""));
        }
    }

    public void listadoMejorVendedor(ArrayList<Comercial> listadoMejorVendedor, int mayorVenta){
        Iterator<Comercial> it = listadoMejorVendedor.iterator();
        while (it.hasNext()){
            Comercial com = it.next();
            System.out.println(com.getNombre() + "es el vendedor/a de la semana con " + mayorVenta + " items en un día.");
        }
    }
}
