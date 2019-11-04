package com.politecnico;

public class LoteDeProductos {

    private Producto[] listaProductos;
    private final static int MAX_PRODUCTOS=100;
    private int totalProductos;
    private SelectorMejorProducto selectorMejorProducto;

    public LoteDeProductos(){
        totalProductos=0;
        listaProductos=new Producto[MAX_PRODUCTOS];
    }

    public void addProducto(Producto producto) throws NullProductException{
        if(producto == null){
            throw new NullProductException("No se permiten valores nulos");
        }
        if (totalProductos<listaProductos.length){
            listaProductos[totalProductos] = producto;
            totalProductos++;
        }
    }

    public Producto getProductoEnPosicion(int i) throws ProductPositionException{
        if((i < totalProductos) && (i>=0)){
            return listaProductos[i];
        } else{
            throw new ProductPositionException("No hay ningún elemento en esta posición. ", totalProductos-1);
        }
    }

    public int getTotalProductos(){
        return totalProductos;
    }

    public SelectorMejorProducto getSelectorMejorProducto() {
        return selectorMejorProducto;
    }

    public void setSelectorMejorProducto(SelectorMejorProducto selectorMejorProducto) {
        this.selectorMejorProducto = selectorMejorProducto;
    }

    public Producto getMejorProducto(){
        return selectorMejorProducto.elegirMejorProducto(this);
    }
}
