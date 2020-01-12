package com.politecnico;

import java.util.ArrayList;
import java.util.Iterator;

public class ListadoComerciales {

    private ArrayList<Comercial> listadoComerciales;

    public ListadoComerciales(){
        listadoComerciales=new ArrayList<Comercial>();
    }

    public void añadirComercialAListado(Comercial comercial){
        listadoComerciales.add(comercial);
    }

    public ArrayList<Comercial> getListadoDeComerciales(){
        return listadoComerciales;
    }

    public int buscarMayorVentaEnUnDia(){
        Comercial comercial;
        int mayorVentaTotal=0;
        Iterator<Comercial> it= listadoComerciales.iterator();
        while (it.hasNext()){
            comercial=it.next();
            int mayorVentaEmpleado=comercial.buscarMayorVentaDeComercial();
            if (mayorVentaTotal<mayorVentaEmpleado){
                mayorVentaTotal=mayorVentaEmpleado;
            }
        }
        return mayorVentaTotal;
    }

    public ArrayList<Comercial> listaDeComercialesConMayorVenta(){
        Comercial comercial;
        int mayorVentaTotal=buscarMayorVentaEnUnDia();
        ArrayList<Comercial> listaComercialesConMayorVenta=new ArrayList<Comercial>();
        Iterator<Comercial> it= listadoComerciales.iterator();
        while (it.hasNext()){
            comercial=it.next();
            if (comercial.buscarSiVendieronUnidades(mayorVentaTotal)){
                listaComercialesConMayorVenta.add(comercial);
            }
        }
        return listaComercialesConMayorVenta;
    }

    @Override
    public String toString() {
        return "ListadoComerciales{" +
                "listadoComerciales=" + listadoComerciales +
                '}';
    }
}
