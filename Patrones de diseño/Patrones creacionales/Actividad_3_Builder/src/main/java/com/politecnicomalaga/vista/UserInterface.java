package com.politecnicomalaga.vista;

import java.util.Scanner;

public class UserInterface {

    public final static int GENERAR_PACK_BASICO = 1;
    public final static int GENERAR_PACK_ROMANCE = 2;
    public final static int GENERAR_PACK_FAMILIAR = 3;
    public final static int GENERAR_PACK_PADRES_RELAJADOS = 4;
    public final static int GENERAR_PACK_DELUXE = 5;
    public final static int GENERAR_PACK_DELUXE_FAMILIAR = 6;
    public final static int TERMINAR = 0;

    private Scanner lectorTeclado;

    public UserInterface (){
        lectorTeclado=new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("¿Qué pack de estancia del hotel desea contratar?\n" +
                "1. Pack básico.\n" +
                "2. Pack romance.\n" +
                "3. Pack familiar.\n" +
                "4. Pack padres relajados.\n" +
                "5. Pack deluxe.\n" +
                "6. Pack deluxe familiar.\n" +
                "0. Salir.\n" +
                "Introduzca una opción: ");
        return lectorTeclado.nextInt();
    }
}

