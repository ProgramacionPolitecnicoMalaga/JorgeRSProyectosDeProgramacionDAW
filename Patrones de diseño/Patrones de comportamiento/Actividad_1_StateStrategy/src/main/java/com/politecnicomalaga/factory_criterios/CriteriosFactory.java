package com.politecnicomalaga.factory_criterios;

import com.politecnicomalaga.criterios.CriterioMasBarato;
import com.politecnicomalaga.criterios.CriterioMejorRelacionCalidadPrecio;
import com.politecnicomalaga.criterios.CriterioMejorValorado;
import com.politecnicomalaga.criterios.SelectorDeMejorProducto;

public class CriteriosFactory {

    public static SelectorDeMejorProducto crearCriterioDeEleccion (int tipoCriterio){
        switch (tipoCriterio){
            case SelectorDeMejorProducto.CRITERIO_MEJOR_VALORADO:
                return new CriterioMejorValorado();
            case SelectorDeMejorProducto.CRITERIO_MAS_BARATO:
                return new CriterioMasBarato();
            case SelectorDeMejorProducto.CRITERIO_MEJOR_RELACION_CALIDAD_PRECIO:
                return new CriterioMejorRelacionCalidadPrecio();
            default:
                return new CriterioMejorRelacionCalidadPrecio();
        }
    }
}
