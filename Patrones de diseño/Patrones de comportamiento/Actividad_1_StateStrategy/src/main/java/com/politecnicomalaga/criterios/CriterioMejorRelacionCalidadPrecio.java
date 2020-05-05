package com.politecnicomalaga.criterios;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class CriterioMejorRelacionCalidadPrecio implements SelectorDeMejorProducto{
    @Override
    public LoteDeProductos elegirMejoresProductos(LoteDeProductos loteDeProductos) {
        LoteDeProductos loteResultado=new LoteDeProductos();
        Producto productoConMejorRelacion=null;
        double mejorRatio = Double.MAX_VALUE;
        for(Producto producto:loteDeProductos.getListaProductos()){
            double ratioProducto=producto.getPrecio()/producto.getValoracion();
            if(ratioProducto<mejorRatio){
                mejorRatio=ratioProducto;
                productoConMejorRelacion=producto;
            }
        }
        loteResultado.addProducto(productoConMejorRelacion);
        return loteResultado;
    }
}
