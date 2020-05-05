package com.politecnicomalaga.criterios;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class CriterioMejorValorado implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos(LoteDeProductos loteDeProductos) {
        LoteDeProductos loteResultado=new LoteDeProductos();
        int mejorValoracion = Integer.MIN_VALUE;
        Producto productoMejorValorado=null;
        for(Producto producto:loteDeProductos.getListaProductos()){
            if(producto.getValoracion()>mejorValoracion){
                mejorValoracion=producto.getValoracion();
                productoMejorValorado=producto;
            }
        }
        loteResultado.addProducto(productoMejorValorado);
        return loteResultado;
    }
}
