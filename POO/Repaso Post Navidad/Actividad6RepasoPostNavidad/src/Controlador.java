public class Controlador {

    private InterfazUsuario iu;

    public void inicializarVista() {
        GestionOperaciones gestionOperaciones = new GestionOperaciones();
        iu = new InterfazUsuario();
        int opcion;
        opcion = iu.mostrarMenu();
        while (opcion != InterfazUsuario.TERMINAR) {
            switch (opcion) {
                case InterfazUsuario.NUEVO_VEHICULO:
                    String [] datosVehiculo=iu.crearVehiculo();
                    Vehiculo vehiculoACrear= new Vehiculo(datosVehiculo[0],datosVehiculo[1],datosVehiculo[2],Integer.parseInt(datosVehiculo[3]),datosVehiculo[4],datosVehiculo[5],Double.parseDouble(datosVehiculo[6]),datosVehiculo[7]);
                    gestionOperaciones.añadirVehiculoALista(vehiculoACrear);
                    break;
                case InterfazUsuario.NUEVO_CLIENTE:
                    String [] datosCliente=iu.crearCliente();
                    Cliente clienteACrear= new Cliente(datosCliente[0],datosCliente[1],datosCliente[2],datosCliente[3]);
                    gestionOperaciones.añadirClienteALista(clienteACrear);
                    break;
                case InterfazUsuario.REALIZAR_VENTA:
                    String dniVenta = iu.solicitarDniCliente();
                    String bastidorVenta = iu.solicitarBastidor();
                    double precioVenta = iu.solicitarPrecioVentaVehiculo();
                    Cliente cliente= gestionOperaciones.buscarClientePorDni(dniVenta);
                    Vehiculo vehiculo= gestionOperaciones.buscarVehiculoPorBastidor(bastidorVenta);
                    gestionOperaciones.añadirOperacionALista(gestionOperaciones.generarOperacion(InterfazUsuario.REALIZAR_VENTA, cliente, vehiculo, precioVenta));
                    break;
                case InterfazUsuario.REALIZAR_COMPRA:
                    String dniCompra = iu.solicitarDniCliente();
                    String bastidorCompra = iu.solicitarBastidor();
                    double precioCompra = iu.solicitarPrecioCompraVehiculo();
                    Cliente clienteCompra= gestionOperaciones.buscarClientePorDni(dniCompra);
                    Vehiculo vehiculoCompra= gestionOperaciones.buscarVehiculoPorBastidor(bastidorCompra);
                    gestionOperaciones.añadirOperacionALista(gestionOperaciones.generarOperacion(InterfazUsuario.REALIZAR_COMPRA, clienteCompra, vehiculoCompra, precioCompra));
                    break;
                case InterfazUsuario.OBTENER_BALANCE:
                    String dniClienteABuscar = iu.solicitarDniCliente();
                    iu.mostrarBalance(String.valueOf(gestionOperaciones.calcularBalanceDeCliente(dniClienteABuscar)));
                    break;
            }
            opcion = iu.mostrarMenu();
        }
    }
}
