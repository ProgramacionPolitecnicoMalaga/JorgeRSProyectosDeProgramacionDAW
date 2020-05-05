package com.politecnicomalaga.modelo;

import java.util.ArrayList;

public class LoteDeProductos {

    private ArrayList<Producto> listaProductos;

    public LoteDeProductos (){
        listaProductos=new ArrayList<>();
    }

    public int getTotalProductos(){
        return listaProductos.size();
    }

    public Producto getProductoEnPosicion(int i){
        return listaProductos.get(i);
    }

    public void addProducto(Producto producto){
        listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos(){
        return listaProductos;
    }

    @Override
    public String toString() {
        return "LoteDeMejoresProductos{" +
                 listaProductos +
                '}';
    }
}
