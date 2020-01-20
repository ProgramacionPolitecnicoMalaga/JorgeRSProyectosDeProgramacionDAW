package com.politecnico;

import java.util.Scanner;

public class InterfazUsuario {
    private Scanner lectorTeclado;
    private String unidad;

    public InterfazUsuario (){
        lectorTeclado=new Scanner(System.in).useDelimiter("\n");
        unidad="";
    }

    public void menuMedidas (){
        System.out.println("¿Qué unidad desea ultilizar?\n"
                        + "1. mm \n"
                        + "2. cm \n"
                        + "3. m \n"
                        + "Introduzca una opción: ");
    }

    public void leerOpcionMedida (){
        int opcionUnidad=lectorTeclado.nextInt();
        switch (opcionUnidad){
            case 1: unidad="mm";
            break;
            case 2: unidad="cm";
            break;
            case 3: unidad="m";
            break;
            default:
                System.out.println("Unidad de medida no válida. Por favor, vuelva a introducir un valor correcto.\n");
                opcionUnidad=Integer.parseInt(lectorTeclado.next());
                leerOpcionMedida();
        }
    }

    public void menuOperacion (){
        System.out.println("¿Qué operación desea realizar?\n" +
                "1. Calcular la hipotenusa de un triángulo a aprtir de sus catetos.\n" +
                "2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa\n" +
                "3. Calcular el área de un triángulo a partir un cateto y la hipotenusa\n" +
                "4. Caluclar el área de un triángulo a partir de dos catetos.\n" +
                "Elige una opción: ");
    }

    public void realizarOperacion (){
        int opcionOperacion=lectorTeclado.nextInt();
        Operaciones operacionARealizar=new Operaciones();
        switch (opcionOperacion){
            case 1: System.out.println("La longitud de la hipotenusa es " +
                                        operacionARealizar.operacion1() + " " + unidad);
                break;
            case 2: System.out.println("La longitud del segundo cateto es " +
                                        operacionARealizar.operacion2() + " " + unidad);
                break;
            case 3: System.out.println("El área del triángulo es " +
                                        operacionARealizar.operacion3() + " " + unidad);
                break;
            case 4: System.out.println("El área del triángulo es " +
                                        operacionARealizar.operacion4() + " " + unidad);
            default:
                System.out.println("Operación no válida. Por favor, vuelva a introducir un valor correcto.\n");
                menuOperacion();
                realizarOperacion();
        }
    }



}
