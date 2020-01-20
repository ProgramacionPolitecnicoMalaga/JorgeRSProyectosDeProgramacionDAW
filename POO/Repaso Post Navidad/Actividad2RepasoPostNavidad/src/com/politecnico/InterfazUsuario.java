package com.politecnico;

public class InterfazUsuario {

    public InterfazUsuario(){}

    public void menuPrincipal (){
        System.out.println("¿Qué operación desea realizar?\n" +
                "1. Empleados que vendieron un número de items.\n" +
                "2. Obtener el promedio de ventas de cada uno\n" +
                "3. Averiguar quién ha conseguido el mayor número de ventas en un día\n" +
                "4. Insertar un nuevo empleado y sus ventas\n" +
                "5. Salir\n" +
                "Elige una opción: ");
    }

    public void opcionnumVentasABuscar(){
        System.out.println("Indique el numero de ventas que desea buscar: ");
    }

    public void comercialesConVentas(int numVentas){
        System.out.println("Los comerciales que vendieron "+numVentas+" items fueron: ");
    }

    public void opcionCalculoPromedios(){
        System.out.println("Los promedios de ventas son: \n");
    }

    public void registrarNombreEmpleado(){
        System.out.println("Indique el nombre del Empleado:");
    }

    public void registrarApellidoEmpleado(){
        System.out.println("Indique el apellido del Empleado:");
    }

    public void registrarVentasEmpleado(){
        System.out.println("Indique el numero de ventas realizadas por el empleado:");
    }

    public void registradoConExito(){
        System.out.println("Comercial registrado correctamente.");
    }
}
