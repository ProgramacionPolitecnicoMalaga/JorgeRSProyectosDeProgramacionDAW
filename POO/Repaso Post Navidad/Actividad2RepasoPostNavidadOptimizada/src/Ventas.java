import java.util.HashMap;
import java.util.Iterator;

public class Ventas {
    private String [] diasDeLaSemana={"lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
    private HashMap<String,Integer> ventas=new HashMap<>();

    public Ventas(int[] ventasDia){
        for(int i=0; i<(diasDeLaSemana.length); i++){
            ventas.put(diasDeLaSemana[i], ventasDia[i]);
        }
    }

    public boolean contiene(int venta) {
        return ventas.containsValue(venta);
    }

    public float promedio() {

        if (ventas.isEmpty()) {
            return 0;
        }
        float suma = 0;
        for (int venta: ventas.values()) {
            suma += venta;
        }
        return suma / ventas.size();
    }

    public int buscarMayorVenta(){
        int ventaMasAlta=-1;
        Iterator<Integer> it= ventas.values().iterator();
        while (it.hasNext()){
            int ventaComercial=it.next();
            if (ventaMasAlta<ventaComercial){
                ventaMasAlta=ventaComercial;
            }
        }
        return ventaMasAlta;
    }
}
