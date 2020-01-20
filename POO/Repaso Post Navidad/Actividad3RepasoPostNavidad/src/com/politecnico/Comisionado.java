package com.politecnico;

public class Comisionado extends Empleado {

    private final float sueldoBase=500;
    private final float comision=50;

    public Comisionado(String nombre, String apellidos, float horasTrabajadas, int numVentas) {
        super(nombre, apellidos, horasTrabajadas, numVentas);
    }

    @Override
    public float getSalario() {
        return (getNumVentas()*comision)+sueldoBase;
    }
}
