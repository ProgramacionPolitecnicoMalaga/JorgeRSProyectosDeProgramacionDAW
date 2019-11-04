package com.politecnico;

public class Actividad11Main {
    public static void main(String[] args) {
        LoteDeProductos lote = new LoteDeProductos();
        Producto producto=null;
        lote.addProducto(new Producto("p1", 3.2, 4.3));
        lote.addProducto(new Producto("p2", 3, 3.5));
        lote.addProducto(new Producto("p3", 30, 4.9));

        /*
        lote.setSelectorMejorProducto(new CriterioMejorPrecio());

        System.out.println(lote.getMejorProducto());

        lote.setSelectorMejorProducto(new CriterioMejorValorado());

        System.out.println(lote.getMejorProducto());

        lote.setSelectorMejorProducto(new CriterioMejorRatioValoracionPrecio());

        System.out.println(lote.getMejorProducto());
        */

        // System.out.println(lote.getProductoEnPosicion(100));

        lote.addProducto(producto);

    }
}
