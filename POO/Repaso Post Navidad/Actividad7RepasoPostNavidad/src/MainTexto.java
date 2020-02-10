import java.util.Scanner;

public class MainTexto {

    private static Cafeteria cafeteria;
    private static Scanner lectorTeclado;

    public static void main(String[] args) {

       cafeteria=new Cafeteria();
       cafeteria.inicializar();
       lectorTeclado=new Scanner(System.in).useDelimiter("\n");
       mostrarMenu();
       int opcion;
       opcion=lectorTeclado.nextInt();
       while (opcion!=0){
           switch(opcion){
               case 1:
                   System.out.println(cafeteria.getMesasAbiertas().toString());
                   break;
               case 2:
                   System.out.println(cafeteria.getMesasCerradas().toString());
                   break;
               case 3:
                   double total;
                   total=cafeteria.contarTotalCaja();
                   System.out.println(cafeteria.getCaja().toString() + "\n-------------------" + "\n Total del cierre de caja = " + total);
                   break;
               case 4:
                   pedirNombreProducto();
                   String nombreProducto=lectorTeclado.next();
                   pedirPrecioProducto();
                   double precioProducto=Double.parseDouble(lectorTeclado.next());
                   cafeteria.addProducto(nombreProducto, precioProducto);
                   break;
               case 5:
                   pedirNombreProducto();
                   String nombreProductoAEliminar=lectorTeclado.next();
                   cafeteria.borrarProductoPorNombre(nombreProductoAEliminar);
                   break;
               case 6:
                   System.out.println(cafeteria.cartaToString());
                   break;
               case 7:
                   pedirNumeroMesa();
                   int numMesa;
                   numMesa=lectorTeclado.nextInt();
                   pedirNombreProducto();
                   String nombreProductoAAñadir;
                   nombreProductoAAñadir=lectorTeclado.next();
                   cafeteria.addProductoAMesa(numMesa, nombreProductoAAñadir);
                   break;
               case 8:
                   pedirNumeroMesa();
                   int numMesaACerrar=lectorTeclado.nextInt();
                   cafeteria.cobrarCuenta(cafeteria.cerrarMesa(numMesaACerrar));
                   break;
           }
           mostrarMenu();
           opcion=lectorTeclado.nextInt();
       }

    }

    public static void mostrarMenu (){
        System.out.println("Opciones:\n" +
                "1. Consultar mesas abiertas.\n" +
                "2. Consultar mesas cerradas.\n" +
                "3. Consultar el recuento de caja.\n" +
                "4. Añadir productos a la carta.\n" +
                "5. Eliminar producto de la carta.\n" +
                "6. Mostrar carta.\n" +
                "7. Añadir producto a una mesa.\n" +
                "8. Cobrar mesa.\n" +
                "0. Salir.\n" +
                "Opción: ");
    }

    public static void pedirNombreProducto(){
        System.out.println("Por favor, introduce el nombre del producto: ");
    }

    public static void pedirPrecioProducto(){
        System.out.println("Indica el precio del producto: ");
    }

    public static void pedirNumeroMesa(){
        System.out.println("Por favor, indica el numero de la mesa: ");
    }
}
