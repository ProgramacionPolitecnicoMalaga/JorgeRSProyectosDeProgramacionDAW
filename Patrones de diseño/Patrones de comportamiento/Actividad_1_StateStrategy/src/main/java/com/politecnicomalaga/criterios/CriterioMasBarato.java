package com.politecnicomalaga.criterios;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class CriterioMasBarato implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos(LoteDeProductos loteDeProductos) {
        LoteDeProductos loteResultado=new LoteDeProductos();
        Double menorPrecio=Double.MAX_VALUE;
        Producto productoMasBarato=null;
        for(Producto producto:loteDeProductos.getListaProductos()){
            if(producto.getPrecio()<menorPrecio){
                menorPrecio=producto.getPrecio();
                productoMasBarato=producto;
            }
        }
        loteResultado.addProducto(productoMasBarato);
        return loteResultado;
    }
}
