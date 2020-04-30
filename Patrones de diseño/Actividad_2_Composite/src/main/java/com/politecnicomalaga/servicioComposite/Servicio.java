package com.politecnicomalaga.servicioComposite;

public interface Servicio {

    public static final int PAQUETE = 0;
    public static final int PRODUCTO = 1;
    public static final double PRECIO_ILINK = 30;
    public static final double PRECIO_RACK = 20;
    public static final double PRECIO_SERVIDOR = 25;
    public static final double PRECIO_CLOUDSOLUTIONS = 15;
    public static final double PRECIO_VPS = 20;

    public int getTipo();
    public void asignarPrecioAServicio(double precioAsignado);
    public double obtenerPrecioDeServicio();
    public String toString();
}
