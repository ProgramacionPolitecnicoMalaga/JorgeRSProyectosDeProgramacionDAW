package com.politecnicomalaga.criterios;

import com.politecnicomalaga.modelo.LoteDeProductos;

public interface SelectorDeMejorProducto {

    public static final int CRITERIO_MEJOR_VALORADO=1;
    public static final int CRITERIO_MAS_BARATO=2;
    public static final int CRITERIO_MEJOR_RELACION_CALIDAD_PRECIO=3;

    public LoteDeProductos elegirMejoresProductos(LoteDeProductos loteDeProductos);

}
