package com.politecnico;

public class PorHoras extends Empleado {

    private final float sueldoPorHora=18;

    public PorHoras(String nombre, String apellidos, float horasTrabajadas, int numVentas) {
        super(nombre, apellidos, horasTrabajadas, numVentas);
    }

    @Override
    public float getSalario() {
        return getHorasTrabajadas()*sueldoPorHora;
    }
}
