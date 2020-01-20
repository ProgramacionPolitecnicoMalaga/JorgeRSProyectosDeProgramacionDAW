package com.politecnico;

public class Comercial {
    private String nombre;
    private String apellido;
    private int[] ventas;

    public Comercial (String nombre, String apellido, int[] ventas){
        this.nombre=nombre;
        this.apellido=apellido;
        this.ventas=ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int[] getVentas() {
        return ventas;
    }

    public void setVentas(int[] ventas) {
        this.ventas = ventas;
    }

    public boolean buscarSiVendieronUnidades (int numVentas){
        boolean encontrado = false;
        for (int i=0; i<ventas.length;i++) {
            if ((ventas[i] == numVentas) && !encontrado) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public double calculoPromedioVentas(){
        double promedioVentas = 0;
        for (int i = 0; i < ventas.length; i++)
            promedioVentas += ventas[i];
        return promedioVentas/ventas.length;
    }

    public int buscarMayorVentaDeComercial(){
        int mayorVenta = 0;
        for (int i = 0; i < ventas.length ; i++)
            if (ventas[i] > mayorVenta)
                mayorVenta = ventas[i];
        return mayorVenta;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
