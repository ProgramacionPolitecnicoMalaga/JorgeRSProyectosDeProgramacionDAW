package com.politecnicomalaga.vista;

import java.util.Scanner;

public class UserInterface {

    public final static int CREAR_ESCENARIO_SELVA = 1;
    public final static int CREAR_ESCENARIO_DESIERTO = 2;
    public final static int CREAR_ESCENARIO_ESPACIO = 3;
    public final static int TERMINAR = 0;

    private Scanner lectorTeclado;

    public UserInterface (){
        lectorTeclado=new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("¿En qué escenario quieres jugar?\n" +
                "1. Selva.\n" +
                "2. Desierto.\n" +
                "3. Espacio.\n" +
                "0. Salir.\n" +
                "Introduzca una opción: ");
        return lectorTeclado.nextInt();
    }
}
