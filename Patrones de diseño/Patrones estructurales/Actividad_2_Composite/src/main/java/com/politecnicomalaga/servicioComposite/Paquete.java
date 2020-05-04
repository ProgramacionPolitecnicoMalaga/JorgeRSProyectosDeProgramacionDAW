package com.politecnicomalaga.servicioComposite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Paquete implements Servicio{

    private String nombre;
    private Double precio;
    private List<Servicio> listaServiciosIncluidos;

    public Paquete(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
        listaServiciosIncluidos=new ArrayList<>();
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

    public void remove(int indice) {
        listaServiciosIncluidos.remove(indice);
    }

    public List getListaServicios(){
        return listaServiciosIncluidos;
    }

    public void addServicioAPaquete(Servicio servicio){
        listaServiciosIncluidos.add(servicio);
    }

    @Override
    public int getTipo() {
        return Servicio.PAQUETE;
    }

    @Override
    public void asignarPrecioAServicio(double precioAsignado) {
        this.precio=precioAsignado;
    }

    @Override
    public double obtenerPrecioDeServicio() {
        double totalCoste = precio;
        for (Servicio servicio: listaServiciosIncluidos) {
            totalCoste += servicio.obtenerPrecioDeServicio();
        }
        return totalCoste;
    }

    @Override
    public String toString() {
        String CadenaResultado = nombre + " [";
        for (int i=0; i<listaServiciosIncluidos.size(); i++) {
            if(i == listaServiciosIncluidos.size()-1) {
                CadenaResultado += listaServiciosIncluidos.get(i);
                CadenaResultado += "]";
            } else
            CadenaResultado += listaServiciosIncluidos.get(i).toString() + ", ";
        }
        return CadenaResultado;
    }

    public Servicio getServicioPorNombre(String nombreServicio) {
        if (nombre.equals(nombreServicio))
            return this;
        else for (Servicio servicio : listaServiciosIncluidos) {
            if (servicio.getTipo() == Servicio.PAQUETE){
                Servicio paquete = ((Paquete) servicio).getServicioPorNombre(nombreServicio);
                if (paquete!=null && ((Paquete) paquete).getNombre().equals(nombreServicio))
                    return paquete;
            } else if (((Producto) servicio).getNombre().equals(nombreServicio))
                return servicio;
        }
        return null;
    }

    public void borrarServicioPorNombre(String nombreServicio, List listaServiciosIncluidos) {
        for (int i=0; i<listaServiciosIncluidos.size(); i++) {
            Servicio servicio = (Servicio)listaServiciosIncluidos.get(i);
            if (servicio.getTipo() == Servicio.PAQUETE){
                if (servicio!=null && ((Paquete) servicio).getNombre().equals(nombreServicio)) {
                    listaServiciosIncluidos.remove(i);
                } else
                    borrarServicioPorNombre(nombreServicio, ((Paquete) servicio).getListaServicios());
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paquete paquete = (Paquete) o;
        return nombre.equals(paquete.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
