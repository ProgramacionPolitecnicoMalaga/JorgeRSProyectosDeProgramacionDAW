public class CrearOperacionCompra implements CrearOperacion {

    @Override
    public Operacion CrearOperacion(Cliente cliente, Vehiculo vehiculo, double precioAcordado) {
        Operacion operacion=new Operacion(cliente, vehiculo);
        operacion.setTipo("Compra");
        operacion.setPrecioAcordado(-precioAcordado);
        return operacion;
    }
}
