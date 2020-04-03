package com.politecnicomalaga.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaCredenciales {

    private ArrayList<Credencial> listaCredenciales;

    public ListaCredenciales (){
        listaCredenciales = new ArrayList<>();
    }

    public void addCredencial (Credencial credencial){
        listaCredenciales.add(credencial);
    }

    public Credencial getCredencial (Integer posicion){
        return listaCredenciales.get(posicion);
    }

    public ArrayList<Credencial> getListadoCredenciales (){
        return listaCredenciales;
    }
}
