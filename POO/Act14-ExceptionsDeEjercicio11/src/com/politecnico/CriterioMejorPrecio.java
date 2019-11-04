package com.politecnico;

public class CriterioMejorPrecio implements SelectorMejorProducto {
    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        double menorPrecio = Double.MAX_VALUE;
        Producto productoMasBarato = null;
        for (int i = 0; i < lote.getTotalProductos(); i++) {
            Producto productoActual=lote.getProductoEnPosicion(i);
            double precioActual=productoActual.getPrecio();
            if (precioActual < menorPrecio) {
                menorPrecio = precioActual;
                productoMasBarato = productoActual;
            }
        }
        return productoMasBarato;
    }

}
