package com.politecnico;

import java.util.Scanner;

public class InterfazUsuario {

    Scanner lectorTeclado;

    public InterfazUsuario() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public void mensajeInicioPrograma(){
        System.out.println("Bienvenido al sistema de gestion de empleados.");
    }

    public void opcionesGestionEmpleados(){
        System.out.println("\nPor favor, elija una de estas opciones: \n\n" +
                "1.Introducir datos de empleado Comisionado.\n" +
                "2.Introducir datos de empleado Por Horas.\n" +
                "3.Introducir datos de empleado Asalariado.\n" +
                "4.Consultar informe de todos los empleados.\n" +
                "5.Salir.\n"+
                "Por favor, introduce una opción: ");
    }

    public String pedirNombreNuevoEmpleado(){
        System.out.print("Por favor, indique el nombre del nuevo empleado:");
        return lectorTeclado.next();
    }

    public String pedirApellidosNuevoEmpleado(){
        System.out.print("Por favor, indique el apellido del nuevo empleado:");
        return lectorTeclado.next();
    }

    public float pedirHorasTrabajadasEmpleado(){
        System.out.print("Por favor, indique las horas trabajadas del empleado:");
        return lectorTeclado.nextFloat();
    }

    public int pedirNumVentasEmpleado(){
        System.out.print("Por favor, indique las ventas del empleado:");
        return lectorTeclado.nextInt();
    }

    public void mensajeRegistroConExito(){
        System.out.println("\nEmpleado registrado con exito.");
    }

    public int opcionLeida(){
        return lectorTeclado.nextInt();
    }

}
