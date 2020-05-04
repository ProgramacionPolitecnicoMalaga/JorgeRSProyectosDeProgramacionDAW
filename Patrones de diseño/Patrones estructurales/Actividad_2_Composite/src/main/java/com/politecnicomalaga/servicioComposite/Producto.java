package com.politecnicomalaga.servicioComposite;

import java.util.Objects;

public class Producto implements Servicio{

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public int getTipo() {
        return Servicio.PRODUCTO;
    }

    @Override
    public void asignarPrecioAServicio(double precioAsignado) {
        this.precio=precioAsignado;
    }

    @Override
    public double obtenerPrecioDeServicio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " con precio = " + precio + "€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
