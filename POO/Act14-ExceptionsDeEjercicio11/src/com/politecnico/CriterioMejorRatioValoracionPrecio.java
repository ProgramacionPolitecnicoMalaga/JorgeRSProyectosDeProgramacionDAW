package com.politecnico;

public class CriterioMejorRatioValoracionPrecio implements SelectorMejorProducto {
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        double mejorRatio = Double.MIN_VALUE;
        Producto productoMejorRatio = null;
        for (int i = 0; i < lote.getTotalProductos(); i++) {
            Producto productoActual=lote.getProductoEnPosicion(i);
            double valoracionActual=productoActual.getValoracion();
            double precioActual=productoActual.getPrecio();
            double ratioActual=valoracionActual/precioActual;
            if (ratioActual > mejorRatio) {
                mejorRatio = ratioActual;
                productoMejorRatio = productoActual;
            }
        }
        return productoMejorRatio;
    }
}
