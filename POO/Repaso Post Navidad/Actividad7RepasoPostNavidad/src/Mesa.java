import java.util.ArrayList;
import java.util.Iterator;

public class Mesa {

    private int numMesa;
    private boolean cerrada;
    private ArrayList<Producto> productosConsumidos;

    public Mesa(int numMesa) {
        this.numMesa = numMesa;
        cerrada = true;
        productosConsumidos= new ArrayList<>();
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public boolean getCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    public ArrayList<Producto> getProductosConsumidos() {
        return productosConsumidos;
    }

    public void setProductosConsumidos() {
       productosConsumidos = new ArrayList<Producto>();
    }

    public void addProductoConsumido(Producto producto) {
        productosConsumidos.add(producto);
        cerrada=false;
    }

    public double calcularTotalCuenta(){
        double total=0;
        ArrayList<Producto> productosACobrar=getProductosConsumidos();
        Iterator<Producto> it= productosACobrar.iterator();
        while(it.hasNext()){
            Producto producto=it.next();
            total= total+producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "\nMesa " + numMesa +
                "\nProductosConsumidos: " + productosConsumidos;
    }
}
