package com.politecnico;

public class CriterioMejorValorado implements SelectorMejorProducto{
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        double mejorValoracion = Double.MIN_VALUE;
        Producto productoMejorValorado = null;
        for (int i = 0; i < lote.getTotalProductos(); i++) {
            Producto productoActual=lote.getProductoEnPosicion(i);
            double valoracionActual=productoActual.getValoracion();
            if (valoracionActual > mejorValoracion) {
                mejorValoracion = valoracionActual;
                productoMejorValorado = productoActual;
            }
        }
        return productoMejorValorado;
    }
}
