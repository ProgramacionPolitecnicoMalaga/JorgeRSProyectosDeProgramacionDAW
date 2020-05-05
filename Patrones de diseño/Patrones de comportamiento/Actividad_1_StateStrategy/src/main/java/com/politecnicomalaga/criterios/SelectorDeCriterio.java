package com.politecnicomalaga.criterios;

import com.politecnicomalaga.modelo.LoteDeProductos;

public class SelectorDeCriterio {
    private SelectorDeMejorProducto criterioSeleccionado;

    public void setCriterioSeleccionado(SelectorDeMejorProducto criterioSeleccionado){
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public LoteDeProductos getProducto(LoteDeProductos loteProductos){
        return criterioSeleccionado.elegirMejoresProductos(loteProductos);
    }
}
