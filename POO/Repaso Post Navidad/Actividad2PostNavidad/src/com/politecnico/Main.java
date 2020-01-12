package com.politecnico;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectorTeclado=new Scanner(System.in).useDelimiter("\n");
        InterfazUsuario interfazUsuario=new InterfazUsuario();
        ListadoComerciales listadoComerciales=new ListadoComerciales();
        Comercial comercial1=new Comercial("Isabel", "Castillo", new int[]{7, 7, 10, 6, 4});
        Comercial comercial2=new Comercial("Vicente", "Calzado", new int[]{4, 7, 5, 4, 5});
        listadoComerciales.añadirComercialAListado(comercial1);
        listadoComerciales.añadirComercialAListado(comercial2);
        interfazUsuario.menuPrincipal();
        int opcion=lectorTeclado.nextInt();
        while (opcion != 5) {
            switch (opcion){
                case 1:
                    interfazUsuario.opcionnumVentasABuscar();
                    int numVentas = lectorTeclado.nextInt();
                    interfazUsuario.comercialesConVentas(numVentas);
                    Iterator<Comercial>it=listadoComerciales.getListadoDeComerciales().iterator();
                    while (it.hasNext()){
                        Comercial comercialTemp=it.next();
                        if(comercialTemp.buscarSiVendieronUnidades(numVentas)){
                            System.out.println(comercialTemp.toString());
                        }
                    }
                    interfazUsuario.menuPrincipal();
                    opcion=lectorTeclado.nextInt();
                    break;
                case 2:
                    interfazUsuario.opcionCalculoPromedios();
                    Iterator<Comercial>it2=listadoComerciales.getListadoDeComerciales().iterator();
                    double promedio;
                    while (it2.hasNext()){
                        Comercial comercialTemp = it2.next();
                        promedio=comercialTemp.calculoPromedioVentas();
                        System.out.println(comercialTemp.toString()+"                        "+promedio);
                    }
                    interfazUsuario.menuPrincipal();
                    opcion=lectorTeclado.nextInt();
                    break;
                case 3:
                    int mayorVenta=listadoComerciales.buscarMayorVentaEnUnDia();
                    listadoComerciales.listaDeComercialesConMayorVenta();
                    Iterator<Comercial>it3=listadoComerciales.getListadoDeComerciales().iterator();
                    while (it3.hasNext()){
                        System.out.println("\n"+it3.next().getNombre()
                                        +" es el/la comercial comercial de la semana con "
                                        + mayorVenta +" items en un día");
                    }
                    interfazUsuario.menuPrincipal();
                    opcion =  lectorTeclado.nextInt();
                    break;
                case 4:
                    interfazUsuario.registrarNombreEmpleado();
                    String nombre=lectorTeclado.next();
                    interfazUsuario.registrarApellidoEmpleado();
                    String apellido=lectorTeclado.next();
                    interfazUsuario.registrarVentasEmpleado();
                    int[] ventas=new int[5];
                    System.out.println("Venta número 1:");
                    ventas[0] = lectorTeclado.nextInt();
                    System.out.println("Venta número 2:");
                    ventas[1] = lectorTeclado.nextInt();
                    System.out.println("Venta número 3:");
                    ventas[2] = lectorTeclado.nextInt();
                    System.out.println("Venta número 4:");
                    ventas[3] = lectorTeclado.nextInt();
                    System.out.println("Venta número 5:");
                    ventas[4] = lectorTeclado.nextInt();
                    Comercial comercial=new Comercial(nombre, apellido, ventas);
                    interfazUsuario.registradoConExito();
                    interfazUsuario.menuPrincipal();
                    opcion=lectorTeclado.nextInt();
                    break;
            }
        }
    }
}
