package com.politecnico;

public class Main {
    public static void main(String[] args) {

        InterfazUsuario interfazUsuario=new InterfazUsuario();
        ListadoEmpleados listadoEmpleados=new ListadoEmpleados();
        interfazUsuario.mensajeInicioPrograma();
        interfazUsuario.opcionesGestionEmpleados();
        int opcion=interfazUsuario.opcionLeida();
        while (opcion!=5){
            if(opcion>0&&opcion<=3){
                String nombre=interfazUsuario.pedirNombreNuevoEmpleado();
                String apellidos=interfazUsuario.pedirApellidosNuevoEmpleado();
                float horasTrabajadas=interfazUsuario.pedirHorasTrabajadasEmpleado();
                int numVentas=interfazUsuario.pedirNumVentasEmpleado();
                interfazUsuario.mensajeRegistroConExito();
                switch (opcion){
                    case 1:
                        Empleado empleadoComisionado=new Comisionado(nombre, apellidos, horasTrabajadas, numVentas);
                        listadoEmpleados.añadirEmpleado(empleadoComisionado);
                        break;
                    case 2:
                        Empleado empleadoPorHoras=new PorHoras(nombre, apellidos, horasTrabajadas, numVentas);
                        listadoEmpleados.añadirEmpleado(empleadoPorHoras);
                        break;
                    case 3:
                        Empleado empleadoAsalariado=new Asalariado(nombre, apellidos, horasTrabajadas, numVentas);
                        listadoEmpleados.añadirEmpleado(empleadoAsalariado);
                        break;
                }
            } else if (opcion==4){
                listadoEmpleados.mostrarInformeEmpleados();
            }
            interfazUsuario.opcionesGestionEmpleados();
            opcion=interfazUsuario.opcionLeida();
        }
    }
}
