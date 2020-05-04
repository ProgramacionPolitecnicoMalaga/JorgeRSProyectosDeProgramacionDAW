package com.politecnicomalaga.servicioBuilder;

import com.politecnicomalaga.servicioComposite.Paquete;
import com.politecnicomalaga.servicioComposite.Producto;
import com.politecnicomalaga.servicioComposite.Servicio;

public class ServicioBuilder {

    private Servicio servicio;
    private ServicioBuilder servicioBuilderPadre;

    public ServicioBuilder(Servicio servicio){
        this.servicio = servicio;
        servicioBuilderPadre = null;
    }

    public ServicioBuilder(Servicio servicio, ServicioBuilder servicioBuilderPadre){
        this.servicio = servicio;
        this.servicioBuilderPadre = servicioBuilderPadre;
    }

    public ServicioBuilder generarNuevoPaquete(String nombreNuevoPaquete, double precio){
        Paquete paquete = new Paquete(nombreNuevoPaquete, precio);
        if (servicio.getTipo() == Servicio.PAQUETE) {
            ((Paquete) servicio).addServicioAPaquete(paquete);
        } else throw new IllegalArgumentException("El servicio dispuesto para agregar un paquete, no es un paquete");
        return new ServicioBuilder(paquete, this);
    }

    public ServicioBuilder finalizarPaquete(){
        return servicioBuilderPadre;
    }

    public ServicioBuilder addProducto(String nombreProducto, double precio){
        Producto productoAAgregarAlServicio = new Producto(nombreProducto, precio);
        ((Paquete)servicio).addServicioAPaquete(productoAAgregarAlServicio);
        return this;
    }

    public Servicio getResult(){
        return servicio;
    }

}
