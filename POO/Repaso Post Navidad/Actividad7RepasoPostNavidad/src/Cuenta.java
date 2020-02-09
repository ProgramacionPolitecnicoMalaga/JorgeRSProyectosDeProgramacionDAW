import java.util.ArrayList;

public class Cuenta {

    private int numCuenta;
    private int numMesa;
    private double total;
    private ArrayList<Producto> productosConsumidos;

    public Cuenta (Mesa mesaACobrar, int numCuenta){
        numMesa=mesaACobrar.getNumMesa();
        productosConsumidos=(ArrayList<Producto>)mesaACobrar.getProductosConsumidos().clone();
        this.numCuenta=numCuenta;
        total= mesaACobrar.calcularTotalCuenta();
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "\n \t Cuenta " + numCuenta +
                "\n \t Numero de mesa: " + numMesa +
                "\n \t ---------------------------" +
                "\n \t Consumido: " + productosConsumidos +
                "\n \t ---------------------------" +
                "\n \t Total=" + total + "\n";
    }
}
