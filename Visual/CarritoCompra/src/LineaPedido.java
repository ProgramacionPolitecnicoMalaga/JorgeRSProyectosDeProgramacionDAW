public class LineaPedido {
    private int cantidad;
    private Producto producto;

    public LineaPedido (int cantidad, Producto producto){
        this.cantidad=cantidad;
        this.producto=producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double CalcularTotal(){
        double total=0;
        return (producto.getPrecio()*cantidad);
    }

    @Override
    public String toString() {
        return "Unds: " + cantidad + " --- Producto: " + producto + " // Total precio de articulo seleccionado: " + CalcularTotal();
    }
}
