import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Cafeteria {

    private final int NUMEROMESASTOTAL=10;
    private TreeMap<Integer,Mesa> mesas;
    private TreeMap<String, Producto> carta;
    private Caja caja;
    private int numCuenta=1;

    public Cafeteria(){
        mesas=new TreeMap<>();
        carta=new TreeMap<>();
        caja=new Caja();
    }

    public void addMesa (int numMesa){
        mesas.put(numMesa,new Mesa(numMesa));
    }

    public void addProducto(String nombreProducto, double precio){
        Producto producto=new Producto(nombreProducto, precio);
        carta.put(nombreProducto,producto);
    }

    public void addProductoAMesa (int numMesa, String nombreProducto){
        Mesa mesa = mesas.get(numMesa);
        Producto producto=carta.get(nombreProducto);
        if(mesa!=null&&producto!=null){
            mesa.addProductoConsumido(producto);
        }
    }

    public ArrayList<Mesa> getMesasAbiertas(){
        ArrayList<Mesa> mesasAbiertas=new ArrayList<>();
        for(Map.Entry<Integer, Mesa> entry:mesas.entrySet()){
            if(!entry.getValue().getCerrada()){
                mesasAbiertas.add(entry.getValue());
            }
        }
        return mesasAbiertas;
    }

    public ArrayList<Mesa> getMesasCerradas(){
        ArrayList<Mesa> mesasCerradas=new ArrayList<>();
        for(Map.Entry<Integer, Mesa> entry:mesas.entrySet()){
            if(entry.getValue().getCerrada()){
                mesasCerradas.add(entry.getValue());
            }
        }
        return mesasCerradas;
    }

    public double contarTotalCaja(){
        double totalCaja=0;
        Iterator<Cuenta> it=caja.getCuentasCobradas().iterator();
        while (it.hasNext()){
            Cuenta cuenta=it.next();
            totalCaja=totalCaja+cuenta.getTotal();
        }
        return totalCaja;
    }

    public Mesa getMesaPorNumero(int numMesa){
        return mesas.get(numMesa);
    }

    public Cuenta cerrarMesa(int numMesa){
        Cuenta cuenta=null;
        ArrayList<Mesa> mesasAbiertas=getMesasAbiertas();
        Iterator<Mesa> it=mesasAbiertas.iterator();
        while (it.hasNext()){
            Mesa mesaTemp=it.next();
            if(mesaTemp.getNumMesa()==numMesa){
                cuenta=new Cuenta(mesaTemp, numCuenta);
                numCuenta=numCuenta+1;
                getMesaPorNumero(numMesa).setProductosConsumidos();
                getMesaPorNumero(numMesa).setCerrada(true);
            }
        }
        return cuenta;
    }

    public Producto borrarProductoPorNombre(String nombreProducto){
        return carta.remove(nombreProducto);
    }

    public void cobrarCuenta(Cuenta cuenta){
        caja.addCuentaCobrada(cuenta);
    }

    public void inicializar(){
        for(int i=1; i<=NUMEROMESASTOTAL;i++) {
            addMesa(i);
        }
        addProducto("Pinta", 3.5);
        addProducto("Cafe", 1.1);
        addProducto("Colacao", 1.4);
        addProducto("Sandwich Mixto", 1.2);
        addProducto("Bocadillo Tortilla", 1.8);
        addProducto("Tapa rusa", 1);
    }

    public TreeMap<String, Producto> getCarta(){
        return carta;
    }

    public String cartaToString (){
        String mensaje="";
        for (String key : carta.keySet()) {
            mensaje=mensaje+ carta.get(key).toString();
        }
        return mensaje;
    }

    public Caja getCaja(){
        return caja;
    }
}
