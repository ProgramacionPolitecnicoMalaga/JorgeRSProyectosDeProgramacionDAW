package com.politecnico;

import java.util.ArrayList;
import java.util.Iterator;

public class ListadoEmpleados {

    private ArrayList<Empleado> listaEmpleado;

    public ListadoEmpleados (){
        listaEmpleado=new ArrayList<Empleado>();
    }

    public void añadirEmpleado (Empleado empleado){
        listaEmpleado.add(empleado);
    }

    public void mostrarInformeEmpleados (){
        Empleado empleado;
        Iterator<Empleado>it=listaEmpleado.iterator();
        while (it.hasNext()){
            empleado=it.next();
            System.out.println(empleado.toString());
        }
    }


}
