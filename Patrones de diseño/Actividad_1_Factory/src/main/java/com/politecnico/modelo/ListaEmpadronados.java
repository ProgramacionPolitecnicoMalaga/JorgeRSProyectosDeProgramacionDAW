package com.politecnico.modelo;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ListaEmpadronados {

    private ArrayList<Padron> listaEmpadronados;

    public ListaEmpadronados(){
        listaEmpadronados=new ArrayList<Padron>();
    }

    public ArrayList getListaEmpadronados (){
        return listaEmpadronados;
    }

    public void insertPadronEnLista (Padron padron){
        listaEmpadronados.add(padron);
    }

}
