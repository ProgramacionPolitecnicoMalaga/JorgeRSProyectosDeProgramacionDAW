package com.politecnicomalaga;

import com.politecnicomalaga.servicioBuilder.ServicioBuilder;
import com.politecnicomalaga.servicioComposite.Paquete;
import com.politecnicomalaga.servicioComposite.Servicio;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {

        Servicio paqueteInicialPadre = new Paquete("iLink1", Servicio.PRECIO_ILINK);

        ServicioBuilder builder = new ServicioBuilder(paqueteInicialPadre);
        builder.generarNuevoPaquete("iLink_1.1", Servicio.PRECIO_ILINK)
                    .generarNuevoPaquete("Rack_1", Servicio.PRECIO_RACK)
                        .addProducto("Servidor_1", Servicio.PRECIO_SERVIDOR)
                        .addProducto("Servidor_2", Servicio.PRECIO_SERVIDOR)
                    .finalizarPaquete()
                    .generarNuevoPaquete("Rack_2", Servicio.PRECIO_RACK)
                        .addProducto("Servidor_3", Servicio.PRECIO_SERVIDOR)
                    .finalizarPaquete()
                .finalizarPaquete()
                .generarNuevoPaquete("CloudSolutions_1", Servicio.PRECIO_CLOUDSOLUTIONS)
                    .addProducto("VPS_1", Servicio.PRECIO_VPS)
                    .generarNuevoPaquete("Rack_3", Servicio.PRECIO_RACK)
                        .addProducto("VPS_2", Servicio.PRECIO_VPS)
                        .addProducto("VPS_3", Servicio.PRECIO_VPS)
                    .finalizarPaquete()
                .finalizarPaquete();

        Servicio servicioPrincipal = builder.getResult();

        System.out.println("La estructura contratada ilink1 quedaría de la siguiente forma: \n" + servicioPrincipal.toString() + "\n");
        System.out.println("El precio del servicio rack1 es de " + ((Paquete) servicioPrincipal).getServicioPorNombre("Rack_1").obtenerPrecioDeServicio() + "€" + "\n");
        System.out.println("El precio del servicio ilink1.1 es de " + ((Paquete) servicioPrincipal).getServicioPorNombre("iLink_1.1").obtenerPrecioDeServicio() + "€" + "\n");
        System.out.println("El precio del servicio ilink1 es de " + servicioPrincipal.obtenerPrecioDeServicio() + "€" + "\n");
        System.out.println("El precio del servicio cloud es de " + ((Paquete) servicioPrincipal).getServicioPorNombre("CloudSolutions_1").obtenerPrecioDeServicio() + "€");
        ((Paquete) servicioPrincipal).borrarServicioPorNombre("Rack_1", ((Paquete) servicioPrincipal).getListaServicios());
        System.out.println("La estructura contratada ilink1 quedaría de la siguiente forma despues del borrado del servicio Rack_1: \n" + servicioPrincipal.toString() + "\n");
        //System.out.println("El precio del servicio rack1 es de " + ((Paquete) servicioPrincipal).getServicioPorNombre("Rack_1").obtenerPrecioDeServicio() + "€" + "\n");
    }
}
