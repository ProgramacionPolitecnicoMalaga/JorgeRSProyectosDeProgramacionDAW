package com.politecnicomalaga.servicioComposite;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements Servicio{

    private String nombre;
    private double precio;
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
}
