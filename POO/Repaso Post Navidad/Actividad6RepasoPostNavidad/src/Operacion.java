public class Operacion {

    private String tipo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double precioAcordado;

    public Operacion (Cliente cliente, Vehiculo vehiculo) {
        tipo=null;
        this.cliente=cliente;
        this.vehiculo=vehiculo;
        precioAcordado=0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPrecioAcordado() {
        return precioAcordado;
    }

    public void setPrecioAcordado(double precioAcordado) {
        this.precioAcordado = precioAcordado;
    }
}
