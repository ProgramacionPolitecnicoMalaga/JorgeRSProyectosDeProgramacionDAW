import java.util.*;

public class Controlador {

    private Comerciales comerciales;
    private Vistas vistas;
    private Scanner lectorTeclado;

    public Controlador(Comerciales comerciales, Vistas vistas) {
        this.comerciales = comerciales;
        this.vistas = vistas;
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public void procesar() {
        int opcion=menuPrincipal();
        do {
            switch (opcion) {
                case 1:
                    mostrarOpcionComercialConVentas();
                    break;
                case 2:
                    opcionCalculoPromedios();
                    break;
                case 3:
                    obtenerMejorVendedorEnUnDia();
                    break;
                case 4:
                    insertarComercial();
                    break;
                default:
                    System.out.println("No ha elegido una opcion valida, por favor vuelva a introducirla.");
            }
            opcion=menuPrincipal();
        }
        while(opcion!=5);
        return;
    }

    public int menuPrincipal (){
        System.out.println("¿Qué operación desea realizar?\n" +
                "1. Empleados que vendieron un número de items.\n" +
                "2. Obtener el promedio de ventas de cada uno\n" +
                "3. Averiguar quién ha conseguido el mayor número de ventas en un día\n" +
                "4. Insertar un nuevo empleado y sus ventas\n" +
                "5. Salir\n" +
                "Elige una opción: ");
        return lectorTeclado.nextInt();
    }

    public int opcionnumVentasABuscar(){
        System.out.println("Indique el numero de ventas que desea buscar: ");
        return lectorTeclado.nextInt();
    }

    public void comercialesConVentas(int numVentas){
        System.out.println("Los comerciales que vendieron "+numVentas+" items fueron: ");
    }

    public void mostrarOpcionComercialConVentas(){
        int numVentasBuscar=opcionnumVentasABuscar();
        comercialesConVentas(numVentasBuscar);
        vistas.listadoComerciales(comerciales.obtenerComercialesConVentas(numVentasBuscar));
    }

    public void opcionCalculoPromedios(){
        System.out.println("Los promedios de ventas son: \n");
        HashMap<String, Float> comPromedio = new HashMap<>();
        Iterator<Comercial> it = comerciales.obtenerTodosComerciales().iterator();
        while (it.hasNext()) {
            Comercial com = it.next();
            comPromedio.put(com.getNombre(), com.getPromedioVentas());
        }
        vistas.listadoPromedios(comPromedio);
    }

    public void obtenerMejorVendedorEnUnDia(){
        int mayorVenta=-1;
        ArrayList<Comercial>listadoComercialesConMayorVenta=new ArrayList<>();
        Iterator<Comercial> it= comerciales.obtenerTodosComerciales().iterator();
        while (it.hasNext()){
            Comercial com = it.next();
            int ventaComercial=com.getVentasSemanales().buscarMayorVenta();
            if(mayorVenta<ventaComercial){
                listadoComercialesConMayorVenta.clear();
                mayorVenta=ventaComercial;
            }
            if (mayorVenta<=ventaComercial) {
                listadoComercialesConMayorVenta.add(com);
            }
        }
        vistas.listadoMejorVendedor(listadoComercialesConMayorVenta, mayorVenta);
    }

    public String registrarNombreEmpleado(){
        System.out.println("Indique el nombre del Empleado:");
        return lectorTeclado.next();
    }

    public String registrarApellidosEmpleado(){
        System.out.println("Indique el apellido del Empleado:");
        return lectorTeclado.next();
    }

    public int[] registrarVentasEmpleado(){
        int []ventasDia = new int[5];
        int i=0;
        System.out.println("Indique el numero de ventas realizadas por el empleado: \nVenta lunes: ");
        ventasDia[i]=lectorTeclado.nextInt();
        i++;
        System.out.println("Venta martes: ");
        ventasDia[i]=lectorTeclado.nextInt();
        i++;
        System.out.println("Venta miercoles: ");
        ventasDia[i]=lectorTeclado.nextInt();
        i++;
        System.out.println("Venta jueves: ");
        ventasDia[i]=lectorTeclado.nextInt();
        i++;
        System.out.println("Venta viernes: ");
        ventasDia[i]=lectorTeclado.nextInt();
        i++;
        return ventasDia;
    }

    public void registradoConExito(){
        System.out.println("Comercial registrado correctamente.");
    }

    public void insertarComercial(){
        String nombre;
        String apellidos;
        Ventas ventasEmpleado;
        Comercial comercial;
        nombre=registrarNombreEmpleado();
        apellidos=registrarApellidosEmpleado();
        ventasEmpleado=new Ventas(registrarVentasEmpleado());
        comercial=new Comercial(nombre, apellidos, ventasEmpleado);
        comerciales.añadirComercial(comercial);
        registradoConExito();
    }
}
