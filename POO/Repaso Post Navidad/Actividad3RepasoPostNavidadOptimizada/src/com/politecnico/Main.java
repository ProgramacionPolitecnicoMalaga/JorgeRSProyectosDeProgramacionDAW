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
                CalculadorSalario calc;
                switch (opcion){
                    case 1:
                        calc = new CalculadoraComisionado();
                        break;
                    case 2:
                        calc = new CalculadoraPorHoras();
                        break;
                    case 3:
                        calc = new CalculadoraAsalariado();
                        break;
                    default:
                        calc = null;
                }
                listadoEmpleados.añadirEmpleado(new Empleado(nombre, apellidos, horasTrabajadas, numVentas, calc));

            } else if (opcion==4){
                listadoEmpleados.mostrarInformeEmpleados();
            }
            interfazUsuario.opcionesGestionEmpleados();
            opcion=interfazUsuario.opcionLeida();
        }
    }
}
