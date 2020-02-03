import java.util.ArrayList;
import java.util.Iterator;

public class GestionOperaciones {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Operacion> listaOperaciones;

    public GestionOperaciones(){
        listaVehiculos=new ArrayList<>();
        listaClientes=new ArrayList<>();
        listaOperaciones=new ArrayList<>();
    }

    public void añadirVehiculoALista(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }
    public void añadirClienteALista(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void añadirOperacionALista(Operacion operacion){
        listaOperaciones.add(operacion);
    }

    public Cliente buscarClientePorDni(String dni){
        Cliente cliente=null;
        Iterator<Cliente> it=listaClientes.iterator();
        while (it.hasNext()){
            Cliente clienteTemporal=it.next();
            if (clienteTemporal.getDni().equals(dni)){
                cliente=clienteTemporal;
            }
        }
        return cliente;
    }

    public Vehiculo buscarVehiculoPorBastidor(String bastidor){
        Vehiculo vehiculo=null;
        Iterator<Vehiculo> it=listaVehiculos.iterator();
        while (it.hasNext()){
            Vehiculo vehiculoTemporal=it.next();
            if (vehiculoTemporal.getBastidor().equals(bastidor)){
                vehiculo=vehiculoTemporal;
            }
        }
        return vehiculo;
    }

    public ArrayList<Operacion> operacionesDeUnCliente(String dni){
        ArrayList<Operacion> operacionesDeCliente=new ArrayList<>();
        Iterator<Operacion> it= listaOperaciones.iterator();
        while (it.hasNext()){
            Operacion operacionTemporal= it.next();
            Cliente clienteTemporal=operacionTemporal.getCliente();
            if (clienteTemporal.getDni().equals(dni)){
                operacionesDeCliente.add(operacionTemporal);
            }
        }
        return operacionesDeCliente;
    }

    public double calcularBalanceDeCliente(String dni){
        ArrayList<Operacion> operacionesCliente=operacionesDeUnCliente(dni);
        double balanceTotal=0;
        Iterator<Operacion> it=operacionesCliente.iterator();
        while (it.hasNext()){
            Operacion operacionTemporal=it.next();
            balanceTotal+=operacionTemporal.getPrecioAcordado();
        }
        return balanceTotal;
    }

    public Operacion generarOperacion (int tipo, Cliente cliente, Vehiculo vehiculo, double precio){
        Operacion operacion=null;
        switch (tipo) {
            case InterfazUsuario.REALIZAR_VENTA:
                operacion = new CrearOperacionVenta().CrearOperacion(cliente, vehiculo, precio);
                break;
            case InterfazUsuario.REALIZAR_COMPRA:
                operacion = new CrearOperacionCompra().CrearOperacion(cliente, vehiculo, precio);
                break;
        }
        return operacion;
    }
}
