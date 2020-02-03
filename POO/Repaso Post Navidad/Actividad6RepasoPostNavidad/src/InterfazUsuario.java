import java.util.Scanner;

public class InterfazUsuario {

    public final static int NUEVO_VEHICULO = 1;
    public final static int NUEVO_CLIENTE = 2;
    public final static int REALIZAR_VENTA = 3;
    public final static int REALIZAR_COMPRA = 4;
    public final static int OBTENER_BALANCE = 5;
    public final static int TERMINAR = 0;
    private Scanner lectorTeclado;

    public InterfazUsuario (){
        lectorTeclado=new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("Opciones:\n" +
                "1. Introducir un nuevo vehículo.\n" +
                "2. Introducir un nuevo cliente.\n" +
                "3. Realizar una venta.\n" +
                "4. Realizar una compra.\n" +
                "5. Obtener balance económico con un cliente.\n" +
                "0. Salir.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public String solicitarMarca() {
        System.out.println("Introduce la marca del vehículo: ");
        return lectorTeclado.next();
    }
    public String solicitarModelo() {
        System.out.println("Introduce el modelo del vehículo: ");
        return lectorTeclado.next();
    }
    public String solicitarColor() {
        System.out.println("Introduce el color del vehículo: ");
        return lectorTeclado.next();
    }
    public String solicitarAño() {
        System.out.println("Introduce el año de matriculación del vehículo: ");
        return lectorTeclado.next();
    }
    public String solicitarTipoCombustible() {
        System.out.println("Introduce si el vehículo es gasolina o diesel: ");
        return lectorTeclado.next();
    }
    public String solicitarEstado() {
        System.out.println("Introduce el estado del vehículo (Nuevo, Usado o Desguace): ");
        return lectorTeclado.next();
    }
    public String solicitarPrecioVenta() {
        System.out.println("Introduce el precio de venta del vehículo: ");
        return lectorTeclado.next();
    }
    public String solicitarBastidor() {
        System.out.println("Introduce el número de bastidor del vehículo: ");
        return lectorTeclado.next();
    }

    public String[] crearVehiculo(){
        String [] camposVehiculo= new String [8];
        camposVehiculo[0]=solicitarMarca();
        camposVehiculo[1]=solicitarModelo();
        camposVehiculo[2]=solicitarColor();
        camposVehiculo[3]=solicitarAño();
        camposVehiculo[4]=solicitarTipoCombustible();
        camposVehiculo[5]=solicitarEstado();
        camposVehiculo[6]=solicitarPrecioVenta();
        camposVehiculo[7]=solicitarBastidor();
        return camposVehiculo;
    }

    public String solicitarNombreCliente() {
        System.out.println("Introduce el nombre del cliente:");
        return lectorTeclado.next();
    }

    public String solicitarApellidosCliente() {
        System.out.println("Introduce los apellidos del cliente: ");
        return lectorTeclado.next();
    }

    public String solicitarDniCliente() {
        System.out.println("Introducir DNI del cliente: ");
        return lectorTeclado.next();
    }

    public String solicitarCuentaBancariaCliente() {
        System.out.println("Introduce la cuenta bancaria del cliente: ");
        return lectorTeclado.next();
    }

    public String[] crearCliente(){
        String[] camposCliente=new String[4];
        camposCliente[0]=solicitarNombreCliente();
        camposCliente[1]=solicitarApellidosCliente();
        camposCliente[2]=solicitarDniCliente();
        camposCliente[3]=solicitarCuentaBancariaCliente();
        return camposCliente;
    }

    public void mostrarBalance(String mensaje) {
        System.out.println("El balance económico con el cliente es: " + mensaje);
    }

    public double solicitarPrecioVentaVehiculo() {
        System.out.println("Introduce la cantidad por la que se ha vendido el vehículo: ");
        return lectorTeclado.nextDouble();
    }
    public double solicitarPrecioCompraVehiculo() {
        System.out.println("Introduce la cantidad por la que se ha comprado el vehículo al cliente: ");
        return lectorTeclado.nextDouble();
    }
}
