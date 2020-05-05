package com.politecnicomalaga.modelo;

public class Producto {

    private String nombre;
    private double precio;
    private int valoracion;

    public Producto (String nombre, double precio, int valoracion){
        this.nombre=nombre;
        this.precio=precio;
        this.valoracion=valoracion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getValoracion() {
        return valoracion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", valoracion=" + valoracion +
                '}';
    }
}
